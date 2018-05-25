package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case8 {

    interface X
    interface Y
    interface Z

    class Mu : X, Z
    class Ni : Y, Z

    @JvmName("___f")
    fun<A, B, C> f(i: Triple<A, B, C>) where A: Z, B: Ni, C: Mu = 1
    @JvmName("__f")
    fun<A, B> f(i: Triple<A, B, Mu>) where A: Z, B: Z  = 2

    @Test
    fun case6() {
        assertEquals(1, f(Triple(Mu(), Ni(), Mu())))
    }
}