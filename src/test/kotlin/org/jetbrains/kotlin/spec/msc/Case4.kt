package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case4 {

    fun f(i: Int) = 1
    fun <T> f(i: T) = 2

    @Test
    fun case4() {
        assertEquals(1, f(2))
        assertEquals(1, f(i = 2))
    }
}
