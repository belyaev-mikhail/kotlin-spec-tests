package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

class Example1 {
    fun f() = 1
}

fun Example1.f() = 2

class Case1 {
    @Test
    fun case1() {
        assertEquals(1, Example1().f()) // method wins
        run {
            fun Example1.f() = 3
            assertEquals(1, Example1().f()) // method wins even over local extension
        }
    }
}
