package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case10 {

    fun f(i: List<Any>) = 1
    @JvmName("___f")
    fun <T : Number> f(i: List<T>) = 2

    @Test
    fun case9() {
        assertEquals(2, f(listOf(2)))
    }

}