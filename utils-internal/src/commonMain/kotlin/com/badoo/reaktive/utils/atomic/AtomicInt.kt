package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
expect class AtomicInt(initialValue: Int = 0) {

    var value: Int

    fun addAndGet(p0: Int): Int

    fun compareAndSet(p0: Int, p1: Int): Boolean
}
