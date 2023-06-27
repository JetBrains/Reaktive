package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicInt actual constructor(initialValue: Int) {

    actual var value: Int = initialValue

    actual fun addAndGet(p0: Int): Int {
        value += p0

        return value
    }

    actual fun compareAndSet(p0: Int, p1: Int): Boolean =
        if (value == p0) {
            value = p1
            true
        } else {
            false
        }
}
