package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicBoolean actual constructor(initialValue: Boolean) {

    private val delegate = kotlin.native.concurrent.AtomicInt(initialValue.intValue)

    actual var value: Boolean
        get() = delegate.value != 0
        set(value) {
            delegate.value = value.intValue
        }

    actual fun compareAndSet(p0: Boolean, p1: Boolean): Boolean =
        delegate.compareAndSet(p0.intValue, p1.intValue)

    private companion object {
        private val Boolean.intValue: Int get() = if (this) 1 else 0
    }
}
