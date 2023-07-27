package com.badoo.reaktive.utils.clock

import com.badoo.reaktive.utils.InternalReaktiveApi
import kotlin.time.Duration

@InternalReaktiveApi
expect object DefaultClock : Clock{
    override val uptime: Duration
}
