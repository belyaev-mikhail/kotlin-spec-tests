package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

/*
* The guy with less defaults wins
* */

class Case1 {
    fun f(x: Int = 2, y: Int = 3) = 1
    fun f(x: Int = 4, y: Int = 6, z: Int = 8) = 2

    @Test
    fun test() {
        assertEquals(1, f())
        assertEquals(1, f(y = 0))
        assertEquals(1, f(0, y = 0))
        assertEquals(2, f(z = 0))
    }
}
