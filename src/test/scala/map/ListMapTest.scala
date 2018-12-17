package map

import org.scalatest.FunSuite
import scala.collection.immutable.ListMap

class ListMapTest extends FunSuite {

  /**************************************
                Map
                 |
          ----------------
          |
      ListMap

    *************************************/

  test("simpleListMap") {

    val actual = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    assert(ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico") === actual)
  }

  test("emptyListMap") {

    val actual = ListMap.empty[Int, String]

    println(actual)
  }

  test("usingApplyMethod1") {

    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit.apply(1)

    assert("Colombia" === actual)
  }

  test("usingApplyMethod2") {

    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit(1)

    assert("Colombia" === actual)
  }
  test("usingHeadMethod1") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit.head

    assert((1, "Colombia") === actual)
  }

  test("usingTailMethod1") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit.tail

    assert(ListMap(2 -> "Cuba", 3 -> "Puerto Rico") === actual)
  }

  test(" addElementsToListMap ") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit + (4 -> "Irlanda")

    assert(ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico", 4 -> "Irlanda") === actual)
  }
  test(" addElementsToListMap2") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit ++ ListMap(4 -> "Irlanda")

    assert(ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico", 4 -> "Irlanda") === actual)
  }

  test("removingElementsFromAListMap") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit - (3)

    assert(ListMap(1 -> "Colombia", 2 -> "Cuba") === actual)

  }

  test("usingMapValues") {
    val countrysToVisit = ListMap(1 -> "Colombia", 2 -> "Cuba", 3 -> "Puerto Rico")

    val actual = countrysToVisit.mapValues(_.toUpperCase())

    assert(ListMap(1 -> "COLOMBIA", 2 -> "CUBA", 3->"PUERTO RICO") === actual)

  }
}
