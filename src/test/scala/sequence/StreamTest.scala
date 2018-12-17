package sequence

import org.scalatest.FunSuite

class StreamTest extends FunSuite{

  /***************************************
                    Seq
                     |
          ---------------------
                              |
                           LinearSeq
                              |
                           -------
                                 |
                               Stream

    *****************************************/

  test("simpleStream") {
    val actual = 1 #:: 2 #:: 3 #:: Stream.empty

    print(actual)
  }

  test("simpleStream02") {
    val actual = Range.apply(1, 100).toStream

    println(actual)
  }

  test("usingHead") {
    val stream = Range.apply(1, 100).toStream

    val actual = stream.head

    assert(1 === actual)
  }
  test("usingTail") {

    val stream = (1 to 100).toStream

    val actual = stream.tail
    println(actual)
  }

  test("filterInAStream") {
    val stream = (1 to 100000).toStream

    val actual = stream.filter(x => x > 500)

    print(actual) //Stream(501, ?)
  }

  test("usingMapInAStream") {
    val stream = ('a' to 'z').toStream

    val actual = stream.map(x => x.toUpper)

    println(actual) //Stream(A, ?)
  }

  test("calculateLazyElements") {

    val stream = ('a' to 'z').toStream

    val actual = stream(10)

    print(stream) //Stream(a, b, c, d, e, f, g, h, i, j, k, ?)
  }

  test("retrivingElements") {
    val stream = ('a' to 'z').toStream

    val actual = stream(10)

    assert('k' === actual)

  }
  /*
  ALERT: be careful with methods that aren’t transformers.
  Calls to the following strict methods are evaluated
  immediately and can easily cause java.lang.OutOfMemoryError errors:
  stream.max
  stream.size
  stream.sum

   */


}
