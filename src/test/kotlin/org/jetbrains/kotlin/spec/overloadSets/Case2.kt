package org.jetbrains.kotlin.spec.overloadSets

import org.junit.Test
import kotlin.test.assertEquals

object Callable2a {
    operator fun invoke() = 1
}
object Callable2b
operator fun Callable2b.invoke() = 2
interface Ex2a {
    val f get() = Callable2b
}
interface Ex2b
val Ex2b.f get() = Callable2a

object Ex2: Ex2a, Ex2b

class Case2 {

    @Test
    fun case2() {
        assertEquals(2, Ex2.f())
    }

}
