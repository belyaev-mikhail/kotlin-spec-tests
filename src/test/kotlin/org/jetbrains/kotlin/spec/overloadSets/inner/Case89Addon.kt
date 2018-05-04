package org.jetbrains.kotlin.spec.overloadSets.inner

import org.jetbrains.kotlin.spec.overloadSets.Tmp1
import org.jetbrains.kotlin.spec.overloadSets.Tmp2
import org.jetbrains.kotlin.spec.overloadSets.Tmp3

object Example8

val Example8.f get() = Tmp1()
val Example8.g get() = Tmp2()
val Example8.h get() = {2}
val Example8.i get() = Tmp3()