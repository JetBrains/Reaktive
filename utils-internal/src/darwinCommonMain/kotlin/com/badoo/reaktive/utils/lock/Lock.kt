package com.badoo.reaktive.utils.lock

import com.badoo.reaktive.utils.InternalReaktiveApi
import platform.Foundation.NSRecursiveLock

@OptIn(ExperimentalMultiplatform::class)
@AllowDifferentMembersInActual
@InternalReaktiveApi
actual open class Lock {

    private val lock = NSRecursiveLock()

    actual inline fun <T> synchronized(block: () -> T): T {
        lock()
        try {
            return block()
        } finally {
            unlock()
        }
    }

    @PublishedApi
    internal fun lock() {
        lock.lock()
    }

    @PublishedApi
    internal fun unlock() {
        lock.unlock()
    }
}
