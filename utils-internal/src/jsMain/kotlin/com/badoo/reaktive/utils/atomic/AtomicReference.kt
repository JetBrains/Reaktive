package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicReference<T> actual constructor(initialValue: T) {

    actual var value: T = initialValue

    actual fun getAndSet(p0: T): T =
        value.also { value = p0 }

    actual fun compareAndSet(p0: T, p1: T): Boolean =
        if (value == p0) {
            value = p1
            true
        } else {
            false
        }
}
