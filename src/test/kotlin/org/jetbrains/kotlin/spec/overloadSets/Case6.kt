package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

/*
* member function vs extension property
* */
object Example6

val Example6.f get() = Tmp1()
val Example6.g get() = Tmp2()
val Example6.h get() = {2}
val Example6.i get() = Tmp3()

fun Example6.f() = 1
fun Example6.g() = 1
fun Example6.h() = 1
fun Example6.i() = 1

private operator fun Tmp3.invoke() = 2

class Case6 {
    @Test
    fun case6() {
        /**
         * Extension property with imported or package extension looses to extension func
         */
        assertEquals(1, Example6.f())
        assertEquals(1, Example6.i())

        /**
         * Extension property with _local_ extension still loses to extension
         */
        operator fun Tmp2.invoke() = 2
        assertEquals(1, Example6.g())

        /**
         * Extension property with member still loses to extension
         */
        assertEquals(1, Example6.h())
    }
}
