package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case9 {

    fun <T: Any?> f(i: T, d: Int = 2) = 1
    @JvmName("___f")
    fun <T> f(i: T, d: Double = 2.0) where T: Any, T: Comparable<Int>? = 2

    @Test
    fun case9() {
        assertEquals(2, f(2))
    }

}
