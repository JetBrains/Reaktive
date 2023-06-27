package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicReference<T> actual constructor(initialValue: T) {

    private val delegate = kotlin.native.concurrent.AtomicReference(initialValue)

    actual var value: T
        get() = delegate.value
        set(value) {
            delegate.value = value
        }

    actual fun getAndSet(p0: T): T =
        getAndChange { p0 }

    actual fun compareAndSet(p0: T, p1: T): Boolean =
        delegate.compareAndSet(p0, p1)
}
