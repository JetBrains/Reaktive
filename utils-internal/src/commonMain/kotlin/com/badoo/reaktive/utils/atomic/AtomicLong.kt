package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
expect class AtomicLong(initialValue: Long = 0L) {

    var value: Long

    fun addAndGet(p0: Long): Long

    fun compareAndSet(p0: Long, p1: Long): Boolean
}
