package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi
import kotlin.concurrent.AtomicInt

@InternalReaktiveApi
actual class AtomicInt actual constructor(initialValue: Int) {

    private val delegate = AtomicInt(initialValue)

    actual var value: Int
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    actual fun addAndGet(delta: Int): Int = delegate.addAndGet(delta)

    actual fun compareAndSet(expectedValue: Int, newValue: Int): Boolean =
        delegate.compareAndSet(expectedValue, newValue)
}
