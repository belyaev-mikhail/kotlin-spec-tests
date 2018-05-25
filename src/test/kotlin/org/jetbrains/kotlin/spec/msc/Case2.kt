package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

/*
* The guy without varargs wins
* */

class Case2 {
    fun f(x: Int = 2, vararg z: Int) = 1
    fun f(x: Int = 4, y: Int = 6, z: Int = 18) = 2

    @Test
    fun test() {
        assertEquals(2, f())
        assertEquals(2, f(1, 2))
        assertEquals(2, f(1))
        assertEquals(2, f(x = 1))
        assertEquals(2, f(z = 1))
    }
}
