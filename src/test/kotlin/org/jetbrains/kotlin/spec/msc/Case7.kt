package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case7 {

    fun<T> f(i: List<T> = listOf()) where T: Comparable<String>, T : CharSequence = 1
    @JvmName("__f")
    fun<T : CharSequence> f(i: List<T> = listOf()) = 2

    @Test
    fun case6() {
        assertEquals(1, f(listOf("Hello")))
        assertEquals(1, f(listOf("Hello")))
    }
}