package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case6 {

    fun<T> f(i: List<T>) = 1
    @JvmName("__f")
    fun<T> f(i: List<List<T>>) = 2

    @Test
    fun case6() {
        assertEquals(2, f(listOf(listOf(2))))
        assertEquals(2, f(listOf(listOf(2))))
    }
}
