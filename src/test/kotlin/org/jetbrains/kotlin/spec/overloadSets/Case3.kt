package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

/*
* member function vs member property
* */
object Example3 {
    val f = {1}
    fun f() = 2
}

class Case3 {
    @Test
    fun case3() {
        assertEquals(2, Example3.f())
    }
}