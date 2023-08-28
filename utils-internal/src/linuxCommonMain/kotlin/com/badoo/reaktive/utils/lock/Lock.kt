package com.badoo.reaktive.utils.lock

import com.badoo.reaktive.utils.InternalReaktiveApi

@OptIn(ExperimentalMultiplatform::class)
@AllowDifferentMembersInActual
@InternalReaktiveApi
actual open class Lock : ConditionLock() {

    actual inline fun <T> synchronized(block: () -> T): T {
        lock()
        try {
            return block()
        } finally {
            unlock()
        }
    }
}
