package it.unibo.pps.u02

import scala.annotation.tailrec

object Tasks {
  @main
  def main(): Unit =
    val positive: Int => String = _ match
      case x if x >= 0 => "positive"
      case _ => "negative"

    def positive2(x: Int): String = x match
      case x if x >= 0 => "positive"
      case _ => "negative"

    //println(positive(-1))
    //println(positive2(-1))

    //val predicate: String => Boolean = _ == ""
    val neg: (String => Boolean) => (String => Boolean) = predicate => !predicate(_)

    val empty: String => Boolean = _ == "" // predicate on strings
    val notEmpty = neg(empty) // which type of notEmpty?

    //println(notEmpty("foo")) // true
    //println(notEmpty("")) // false
    //println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test

    //Implement a predicate that checks whether its arguments x, y,z
    //respect the relation x ≤ y = z, in 4 variants (curried / non - curried × val/def)
    val p1: Double => Double => Double => Boolean = x => y => z => x match
      case _ => (x <= y && y == z)

    //println(p1(1)(2)(2))
    //println(p1(1)(2)(3))

    val p2: (x: Double, y: Double, z: Double) => Boolean = (x, y, z) => x match
      case _ => (x <= y && y == z)

    //println(p2(1, 2, 2))
    //println(p2(1, 2, 3))

    def p3(x: Double)(y: Double)(z: Double): Boolean = x match
      case _ => (x <= y && y == z)

    //println(p3(1)(2)(2))
    //println(p3(1)(2)(3))

    def p4: (x: Double, y: Double, z: Double) => Boolean = (x, y, z) => x match
      case _ => (x <= y && y == z)

    //println(p4(1, 2, 2))
    //println(p4(1, 2, 3))

    def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
    //println(compose(_ - 1, _ * 2)(5))

    def power(base: Double, exponent: Int): Double = (base, exponent) match
      case _ if exponent == 0 => 1
      case _ => base * power(base, exponent - 1)

    //println((power(2, 3), power(5, 2)))

    def powerTail(base: Double, exponent: Int): Double =
      @annotation.tailrec
      def power(base: Double, exponent: Int, acc: Double): Double = base match
        case _ if exponent == 0 => acc
        case _ => power(base, exponent - 1, acc * base)
      power(base, exponent, 1)

    //println((powerTail(2, 3), powerTail(5, 2)))
}