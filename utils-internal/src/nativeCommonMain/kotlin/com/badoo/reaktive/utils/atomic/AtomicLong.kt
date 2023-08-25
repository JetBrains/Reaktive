package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi
import kotlin.concurrent.AtomicLong

@InternalReaktiveApi
actual class AtomicLong actual constructor(initialValue: Long) {

    private val delegate = AtomicLong(initialValue)

    actual var value: Long
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    actual fun addAndGet(delta: Long): Long = delegate.addAndGet(delta)

    actual fun compareAndSet(expectedValue: Long, newValue: Long): Boolean =
        delegate.compareAndSet(expectedValue, newValue)
}
