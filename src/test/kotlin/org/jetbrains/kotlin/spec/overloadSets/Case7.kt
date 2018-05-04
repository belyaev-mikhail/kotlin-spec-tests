package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

// this is exactly the same as Case6 save for this explicit import:
import org.jetbrains.kotlin.spec.overloadSets.invoke

// it doesn't change much though

/*
* member function vs extension property
* */
object Example7

val Example7.f get() = Tmp1()
val Example7.g get() = Tmp2()
val Example7.h get() = {2}
val Example7.i get() = Tmp3()

fun Example7.f() = 1
fun Example7.g() = 1
fun Example7.h() = 1
fun Example7.i() = 1

private operator fun Tmp3.invoke() = 2

class Case7 {
    @Test
    fun case7() {
        /**
         * Extension property with imported or package extension looses to extension func
         */
        assertEquals(1, Example7.f())
        assertEquals(1, Example7.i())

        /**
         * Extension property with _local_ extension still loses to extension
         */
        operator fun Tmp2.invoke() = 2
        assertEquals(1, Example7.g())

        /**
         * Extension property with member still loses to extension
         */
        assertEquals(1, Example7.h())
    }
}
