package com.badoo.reaktive.observable

import com.badoo.reaktive.disposable.Disposable
import com.badoo.reaktive.test.doInBackground
import com.badoo.reaktive.test.observable.test
import com.badoo.reaktive.utils.lock.ConditionLock
import com.badoo.reaktive.utils.lock.synchronized
import com.badoo.reaktive.utils.lock.waitFor
import com.badoo.reaktive.utils.lock.waitForOrFail
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.time.Duration.Companion.seconds

class RefCountThreadingTest {

    // flaky https://jetbrains.slack.com/archives/C06QB5UHN9Y/p1713508726403819
    @Ignore
    @Test
    fun does_not_connect_second_time_concurrently_while_disconnecting() {
        val lock = ConditionLock()
        var isDisconnecting = false
        var isSecondTime = false
        var isConnectedSecondTimeConcurrently = false

        val disposable =
            Disposable {
                lock.synchronized {
                    isDisconnecting = true
                    isSecondTime = true
                    lock.signal()
                    lock.waitFor(timeout = 1.seconds) { false }
                    isDisconnecting = false
                }
            }

        val upstream =
            testUpstream(
                connect = { onConnect ->
                    lock.synchronized {
                        if (!isSecondTime) {
                            onConnect?.invoke(disposable)
                        } else {
                            isConnectedSecondTimeConcurrently = isDisconnecting
                        }
                    }
                }
            )

        val refCount = upstream.refCount(subscriberCount = 1)
        val observer = refCount.test()
        doInBackground { observer.dispose() }

        lock.synchronized {
            lock.waitForOrFail { isSecondTime }
        }

        refCount.test()

        assertFalse(isConnectedSecondTimeConcurrently)
    }

    private fun testUpstream(
        connect: (onConnect: ((Disposable) -> Unit)?) -> Unit = {},
    ): ConnectableObservable<Int?> =
        object : ConnectableObservable<Int?> {
            override fun connect(onConnect: ((Disposable) -> Unit)?) {
                connect.invoke(onConnect)
            }

            override fun subscribe(observer: ObservableObserver<Int?>) {
                observer.onSubscribe(Disposable())
            }
        }
}
