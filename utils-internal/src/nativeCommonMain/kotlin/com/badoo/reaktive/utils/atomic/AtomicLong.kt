package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicLong actual constructor(initialValue: Long) {

    private val delegate = kotlin.native.concurrent.AtomicLong(initialValue)

    actual var value: Long
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    actual fun addAndGet(p0: Long): Long = delegate.addAndGet(p0)

    actual fun compareAndSet(p0: Long, p1: Long): Boolean =
        delegate.compareAndSet(p0, p1)
}
