package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicInt actual constructor(initialValue: Int) {

    private val delegate = kotlin.native.concurrent.AtomicInt(initialValue)

    actual var value: Int
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    actual fun addAndGet(p0: Int): Int = delegate.addAndGet(p0)

    actual fun compareAndSet(p0: Int, p1: Int): Boolean =
        delegate.compareAndSet(p0, p1)
}
