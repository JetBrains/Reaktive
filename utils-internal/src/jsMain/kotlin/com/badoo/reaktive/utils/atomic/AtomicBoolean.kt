package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
actual class AtomicBoolean actual constructor(initialValue: Boolean) {

    actual var value: Boolean = initialValue

    actual fun compareAndSet(p0: Boolean, p1: Boolean): Boolean =
        if (value == p0) {
            value = p1
            true
        } else {
            false
        }
}
