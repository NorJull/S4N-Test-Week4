package map

import org.scalatest.FunSuite
import scala.collection.immutable.HashMap

class HashMapTest extends FunSuite{

  /**************************************
                Map
                 |
          ----------------
          |
      HashMap

    *************************************/

  test("simpleHashMap01"){
    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    assert( HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana") === topFavoriteFruits)
  }

  test("simpleHashMap02"){
    val topFavoriteFruits =  HashMap((1, "pineapple"), (2 , "orange"), (3 , "banana"))

    assert( HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana") === topFavoriteFruits)
  }

  test("gettingValues01"){
    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits(1)

    assert("pineapple" === actual)
  }


  test("gettingValues02"){
    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits.apply(1)

    assert("pineapple" === actual)
  }


  test("addingElmentsToAHashMap01"){
    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits + (4 -> "apple")

    assert( HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana", 4 -> "apple") === actual)

  }


  test("addingElmentsToAHashMap02"){
    val topFavoriteFruits1 =  HashMap(1 -> "pineapple")

    val actual = topFavoriteFruits1 + (2 -> "orange", 3 -> "banana")

    assert( HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana") === actual)

  }


  test("addingElmentsToAHashMap03"){
    val topFavoriteFruits1 =  HashMap(1 -> "pineapple")

    val topFavoriteFruits2 = HashMap(2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits1 ++ topFavoriteFruits2

    assert( HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana") === actual)

  }

  test("removingElmentsFromAHashMap01"){

    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits - 3

    assert( HashMap(1 -> "pineapple", 2 -> "orange") === actual)
  }

  test("usingMapValues"){
    val topFavoriteFruits =  HashMap(1 -> "pineapple", 2 -> "orange", 3 -> "banana")

    val actual = topFavoriteFruits.mapValues(x => x.length)

    assert(HashMap(1 -> 9, 2 -> 6, 3 -> 6) === actual)
  }

}
