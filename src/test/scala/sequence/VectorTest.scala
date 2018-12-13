package sequence

import com.vamosaprogramar.entity.{PartyTicket, Person}
import org.scalatest.FunSuite

class VectorTest extends FunSuite {

  /**************************************
                Seq
                 |
          ----------------
          |
      IndexedSeq
          |
     -------------
     |
   Vector

    *************************************/

  test("simpleVector"){
    val tickets =  Vector(PartyTicket("Official seller"), PartyTicket("Street seller"), PartyTicket("Gift ticket"))

    assert(Vector(PartyTicket("Official seller"), PartyTicket("Street seller"), PartyTicket("Gift ticket")) === tickets  )
  }

  test("simpleVector02"){
    val actual = Vector.apply(1,2,3)

    assert(Vector(1,2,3) === actual)
  }

  test("emptyVector"){
    val actual = Vector[Int]()
    assert(Vector() === actual)
  }

  test("usingRangeMethodToCreateAVector"){

    val actual1 = ('a' to 'f').toVector
    val actual2 = ('a' until 'f').toVector

    assert(Vector('a','b','c','d','e','f') === actual1)
    assert(Vector('a','b','c','d','e') === actual2)
  }
  test("usingRangeMethodToCreateAVector02"){

    val actual = Vector.range(1, 5)

    assert(Vector(1,2,3,4) === actual)
  }

  /***********************************************
    To add elements
    *********************************************/
  test("appendOneElementToAVector"){
    val vector  = Vector(1,2,3)

    val actual = vector :+ 4

    assert(Vector(1,2,3,4) === actual)
  }

  test("appendMoreThanOneElementToAVector"){
    val vector  = Vector(1,2,3)

    val actual = vector ++ Seq(4,5)

    assert(Vector(1,2,3,4,5) === actual)
  }

  test("prependOneElementToAVector"){
    val vector  = Vector(1,2,3)

    val actual = 4 +: vector

    assert(Vector(4,1,2,3) === actual)
  }

  test("prependMoreThanOneElementToAVector"){
    val vector  = Vector(1,2,3)

    val actual = Seq(4,5) ++: vector

    assert(Vector(4,5, 1,2,3) === actual)
  }

  /****************************************
    Remove elements
    ****************************************/

  test("usingDistinct"){
    val letters = Vector("S","S","4","N","N")

    val actual = letters.distinct

    assert(Vector("S","4","N") === actual)
  }

  test("usingDrop"){

    val numbers = Vector(1,2,3,4,5,6)

    val actual = numbers.drop(3)

    assert(Vector(4,5,6) === actual)
  }


  test("usingDropRight"){

    val numbers = Vector(1,2,3,4,5,6)

    val actual = numbers.dropRight(3)

    assert(Vector(1,2,3) === actual)
  }

  test("usingFilter"){
    val persons = Vector(Person("Pedro", 25), Person("Alberto", 16), Person("Camilo", 19))

    val actual = persons.filter(_.age < 20)

    assert(Vector(Person("Alberto", 16), Person("Camilo", 19)) === actual)
  }


  test("usingHead"){
    val persons = Vector(Person("Pedro", 25), Person("Alberto", 16), Person("Camilo", 19))

    val actual = persons.head

    assert(Person("Pedro", 25) === actual)
  }

  test("usingHeadThenThrowException"){
    val persons = Vector[Person]()

    intercept[UnsupportedOperationException] {
      val actual = persons.head
    }

  }

  test("usingTail"){
    val persons = Vector(Person("Pedro", 25), Person("Alberto", 16), Person("Camilo", 19))

    val actual = persons.tail

    assert(Vector(Person("Alberto", 16), Person("Camilo", 19)) === actual)
  }

  /****************************************
    Transformer methods
    ***************************************/

  test("usingCollect"){
    val letters = Vector(None, Some("S"), None, Some("4"), Some("N"))

    val actual = letters.collect{case Some(x) => x}


    assert(Vector("S","4","N") === actual)

  }

  test("usingFlatten"){
    val letters = Vector(Seq(Person("Naren", 23)), Seq(Person("David", 21)))

    val actual = letters.flatten

    assert(Vector(Person("Naren", 23), Person("David", 21)) === actual)
  }

  test("usingMap"){
    val letters = Vector("s4n")
    val actual = letters.map(x => x.toUpperCase())

    assert(Vector("S4N") === actual)
  }

  test("usingFlatMap"){
    val letters = Vector("s4n")

    val actual = letters.flatMap(x => x.toUpperCase())

    assert(Vector('S', '4', 'N') === actual)
  }

  /*******************************************
    Looping over a Vector
    *****************************************/

  test("usingFor"){

    val persons = Vector(Person("Mr Black", 32),
      Person("Koffe Cafetero", 26),
      Person("Twister", 25),
      Person("Papo Man", 36),Person("El Afinaito", 42))

    val oldSchoolSingers = for{

      x <-  persons
      if x.age > 30
    } yield x

    assert(Vector(Person("Mr Black", 32),Person("Papo Man", 36),Person("El Afinaito", 42)) === oldSchoolSingers)
  }

}