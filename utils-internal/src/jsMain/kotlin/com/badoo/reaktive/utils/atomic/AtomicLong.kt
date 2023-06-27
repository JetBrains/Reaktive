package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicLong actual constructor(initialValue: Long) {

    actual var value: Long = initialValue

    actual fun addAndGet(p0: Long): Long {
        value += p0

        return value
    }

    actual fun compareAndSet(p0: Long, p1: Long): Boolean =
        if (value == p0) {
            value = p1
            true
        } else {
            false
        }
}
