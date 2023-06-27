package com.badoo.reaktive.utils.atomic

import com.badoo.reaktive.utils.InternalReaktiveApi

@InternalReaktiveApi
expect class AtomicBoolean(initialValue: Boolean = false) {

    var value: Boolean

    fun compareAndSet(p0: Boolean, p1: Boolean): Boolean
}
