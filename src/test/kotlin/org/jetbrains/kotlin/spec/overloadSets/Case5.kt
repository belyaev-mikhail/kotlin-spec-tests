package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

// this is exactly the same as Case4 save for this explicit import:
import org.jetbrains.kotlin.spec.overloadSets.invoke

/*
* member function vs member property
* */
object Example5 {
    val f = Tmp1()
    val g = Tmp2()
    val h = {2}
    val i = Tmp3()
}
fun Example5.f() = 1
fun Example5.g() = 1
fun Example5.h() = 1
fun Example5.i() = 1

private operator fun Tmp3.invoke() = 2

class Case5 {
    @Test
    fun case5() {
        /**
         * Member with extension looses to extension func
         */
        assertEquals(42, Example5.f())

        // it's this-package, but still counts as explicitly-imported
        assertEquals(2, Example5.i())

        operator fun Tmp2.invoke() = 2
        assertEquals(2, Example5.g())

        /**
         * But member with member does not
         */
        assertEquals(2, Example5.h())
    }
}
