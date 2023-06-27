package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
expect class AtomicReference<T>(initialValue: T) {

    var value: T

    fun getAndSet(p0: T): T

    fun compareAndSet(p0: T, p1: T): Boolean
}
