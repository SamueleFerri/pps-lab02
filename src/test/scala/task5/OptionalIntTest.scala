package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/
  @Test def mapIntShouldBeEmpty(): Unit =
    val empty = OptionalInt.mapInt(OptionalInt.Empty(), (_ + 1))
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def mapIntShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.mapInt(OptionalInt.Just(5), (_ + 1))
    assertEquals(OptionalInt.Just(6), nonEmpty)

  @Test def filterShouldBeEmpty(): Unit =
    val empty1 = OptionalInt.filter(OptionalInt.Empty(), (_ > 2))
    val empty2 = OptionalInt.filter(OptionalInt.Just(5), (_ > 8))
    assertTrue(OptionalInt.isEmpty(empty1))
    assertTrue(OptionalInt.isEmpty(empty2))

  @Test def filterShouldNotBeEmpty(): Unit =
    val notEmpty = OptionalInt.filter(OptionalInt.Just(5), (_ > 2))
    assertEquals(OptionalInt.Just(5), notEmpty)