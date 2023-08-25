package com.badoo.reaktive.looperthread

internal class FixedLooperThreadStrategy(threadCount: Int) : LooperThreadStrategy {

    private val pool = List(threadCount) { LooperThread() }
    private val threadIndex = kotlin.concurrent.AtomicInt(-1)

    override fun get(): LooperThread = pool[threadIndex.addAndGet(1) % pool.size]

    override fun recycle(looperThread: LooperThread) {
        // no-op
    }

    override fun destroy() {
        pool.forEach(LooperThread::destroy)
    }
}
