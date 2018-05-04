package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

/*
* member function vs member property
* */
object Example4 {
    val f = Tmp1()
    val g = Tmp2()
    val h = {2}
    val i = Tmp3()
}
fun Example4.f() = 1
fun Example4.g() = 1
fun Example4.h() = 1
fun Example4.i() = 1

private operator fun Tmp3.invoke() = 2

class Case4 {
    @Test
    fun case4() {
        /**
         * Member with imported or package extension looses to extension func
         */
        assertEquals(1, Example4.f())
        assertEquals(1, Example4.i())

        /**
         * But member with _local_ extension somehow wins
         */
        operator fun Tmp2.invoke() = 2
        assertEquals(2, Example4.g())

        /**
         * Member with member wins over extension
         */
        assertEquals(2, Example4.h())
    }
}
