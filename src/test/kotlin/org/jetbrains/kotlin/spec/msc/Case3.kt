package org.jetbrains.kotlin.spec.msc

import org.junit.Test
import kotlin.test.assertEquals

class Case3 {

    inline fun <reified T> baz(): T {
        when {
            null is T -> return null as T
            1.0 is T -> return 3.14 as T
            2 is T -> return 42 as T
            {} is T -> return { 4.18 } as T
            else -> TODO()
        }
    }

    // lambda is more generic, so it wins, albeit counter-intuitively
    fun <T> bar(i: T) = i
    fun <T> bar(i: () -> T) = i()

    @Test
    fun test() {
        assertEquals(4.18, bar(baz()))
    }
}