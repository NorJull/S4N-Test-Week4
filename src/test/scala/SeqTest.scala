import com.vamosaprogramar.entity.Person
import org.scalatest.FunSuite

import scala.collection.LinearSeq

class SeqTest extends FunSuite{

  test("simpleSeq"){
    val actual: Seq[String] = Seq("Naren","David","David","De Avila", "Julio")

    assert(List("Naren","David","David","De Avila", "Julio") === actual)
  }

  test("toAccessElementsInSeq"){
    val sequence: Seq[String] = Seq("Naren","David","David","De Avila", "Julio")

    val actual = sequence(0)

    assert("Naren" === actual)

    val actual2 = sequence(2)

    assert("David" === actual2)
  }


  test("emptySeq"){
    val actual: Seq[String] = Seq.empty[String]

    assert(List() === actual)
  }


  /******************************************************
         Seq
          |
    ---------------
    |             |
  IndexedSeq    LinearSeq
    ******************************************************/
  test("VectorAsDefaultImplementationOfIndexedSeq"){

    val actual: IndexedSeq[String] = IndexedSeq("S","4","N")

    assert(Vector("S","4","N") === actual)
  }

  test("ListAsDefaultImplementationOfLinearSeq"){

    val actual: LinearSeq[String] = LinearSeq("S","4","N")

    assert(List("S","4","N") === actual)
  }
  /************************************************
  //Append elements
  *************************************************/

  test("toAddElementsInSeq"){

    val sequence: Seq[String] = Seq("S","4");

    val actual: Seq[String] = sequence :+ "N"

    assert(List("S","4","N") === actual)
  }

  test("toAddElementsInSeq02"){

    val sequence1: Seq[String] = Seq("S")

    val sequence2: Seq[String] = Seq("4", "N")

    val actual = sequence1 ++ sequence2

    assert(List("S", "4", "N") === actual)
  }
  /************************************************
  //Prepend elements
    *************************************************/
  test("toAddElementsInSeq03"){

    val sequence: Seq[String] = Seq("S","4");

    val actual: Seq[String] = "N" +: sequence

    assert(List("N","S","4") === actual)
  }

  test("toAddElementsInSeq04"){

    val sequence1: Seq[String] = Seq("S")

    val sequence2: Seq[String] = Seq("4", "N")

    val actual = sequence2 ++: sequence1

    println(List("4","N","S") === actual)

  }

  /*******************************************************
    "Remove" elements from a immutable Seq
    *****************************************************/

  //	Return the first element; can throw an exception if the Seq is empty
  test("retriveHeadFromASeq"){
    val sequence: Seq[String] = Seq("Naren","David","David","De Avila", "Julio")

    val actual = sequence.head

    assert("Naren" === actual)
  }

  test("retriveHeadFromASeq_ThenThrowAException"){
    val sequence: Seq[String] = Seq.empty[String]


    intercept[NoSuchElementException] {
      val actual = sequence.head
    }

   }

  //All elements after the first element
  test("retriveTailFromASeq"){
    val sequence: Seq[String] = Seq("Naren","David","David","De Avila", "Julio")

    val actual = sequence.tail
    assert(List("David","David","De Avila", "Julio") === actual)
  }

  //Return a new sequence with no duplicate elements
  test("distinctElementsInASeq"){
    val sequence: Seq[String] = Seq("Naren","David","David","De Avila", "Julio")

    val actual: Seq[String] = sequence.distinct

    assert(List("Naren","David","De Avila", "Julio") === actual)
  }

  //	Return all elements after the first n elements
  test("ToDropASeq"){
    val sequence: Seq[Person] = Seq(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67),Person("Victor",72))

    val actual = sequence.drop(2)

    assert(List(Person("Zobeida",67), Person("Victor",72)) === actual)
  }

  //Return all elements except the last n elements
  test("toDropRightASeq"){
    val sequence: Seq[Person] = Seq(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67),Person("Victor",72))

    val actual = sequence.dropRight(1)

    assert(List(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67)) === actual)
  }

  //Drop the first sequence of elements that matches the predicate p
  test("toDropWhileASeq"){
    val sequence: Seq[Person] = Seq(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67),Person("Victor",72))

    val actual = sequence.dropWhile(x => x.age <61)

    assert(List( Person("Zobeida",67),Person("Victor",72)) === actual)
  }

  //Return all elements that match the predicate p
  test("toFilterASeq"){
    val sequence: Seq[Person] = Seq(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67),Person("Victor",72))

    val actual = sequence.filter(x => x.name.contains("a"))

    assert(List(Person("Sadith",51),Person("Orlando",60), Person("Zobeida",67)) === actual)
  }
}
