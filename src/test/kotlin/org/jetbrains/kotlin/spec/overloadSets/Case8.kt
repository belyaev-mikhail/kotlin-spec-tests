package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

// this is exactly the same as Case7 save for these explicit imports:
import org.jetbrains.kotlin.spec.overloadSets.inner.f
import org.jetbrains.kotlin.spec.overloadSets.inner.g
import org.jetbrains.kotlin.spec.overloadSets.inner.h
import org.jetbrains.kotlin.spec.overloadSets.inner.i
import org.jetbrains.kotlin.spec.overloadSets.inner.Example8

/*
* member function vs extension property
* */

fun Example8.f() = 1
fun Example8.g() = 1
fun Example8.h() = 1
fun Example8.i() = 1

private operator fun Tmp3.invoke() = 2

class Case8 {
    @Test
    fun case8() {
        /**
         * Extension property with imported or package extension looses to extension func
         */
        assertEquals(1, Example8.f())
        assertEquals(1, Example8.i())

        /**
         * explicitly imported extension property with local extension invoke
         */
        operator fun Tmp2.invoke() = 2
        assertEquals(2, Example8.g())

        /**
         * Extension property with member wins over extension func
         */
        assertEquals(2, Example8.h())
    }
}
