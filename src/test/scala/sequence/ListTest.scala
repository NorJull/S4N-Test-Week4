package sequence

import com.vamosaprogramar.entity.{Laptop, Person}
import org.scalatest.FunSuite

class ListTest  extends FunSuite{

  /***************************************
                    Seq
                     |
          ---------------------
                              |
                           LinearSeq
                              |
                           -------
                                 |
                               List

    *****************************************/


  test("simpleList"){

    val actual: List[Int] = List(1,2,3,4,5)

    assert(List(1,2,3,4,5) === actual)
  }


  test("usingRangeMethodToCreateAList"){
    val actual = List.range(1,5)

    assert(List(1,2,3,4) === actual)
  }

  test("usingRangeMethodToCreateAList02"){
    val actual = List.range(1,10,2)

    assert(List(1, 3, 5, 7, 9) === actual)
  }


    test("usingFillMethodToCreateAList"){
      val actual = List.fill(2)(Person("someone", 2))

      assert(List(Person("someone",2),Person("someone",2)) === actual)
    }



  test("usingTabulateMethodToCreateAList"){
    val actual = List.tabulate(5)(x => x + 2)

    assert(List(2,3,4,5,6) === actual)
  }

  /********************************************
    * Adding elements to a List
    ******************************************/
  test("addingOneElementToAList"){

    val company = List("4", "N")

    val actual = "S"::company

    assert(List("S","4","N") === actual)

  }

  test("mergingLists01"){
    val cities1 = List("Medellin", "Bogota")

    val cities2 = List("Seattle")

    val actual = cities1:::cities2

    assert(List("Medellin", "Bogota","Seattle") === actual)
  }

  test("mergingLists02"){
    val cities1 = List("Medellin", "Bogota")

    val cities2 = List("Seattle")

    val actual = List.concat(cities1,cities2)

    assert(List("Medellin", "Bogota","Seattle") === actual)
  }

  /************************************************
    Iterating lists
    **********************************************/
  test("usingForeachInAList"){
    val players = List(Person("Carlos", 14),
      Person("Pepe",16), Person("Naren", 23), Person("Victor", 15))

    println("Team sub 16")
    players.foreach(x => {
      if(x.age <= 16)
        println(x)
    } )

  }

  test("usingForInAList"){

      val players = List(Person("Carlos", 14),
        Person("Pepe",16), Person("Naren", 23), Person("Victor", 15))

      println("Team sub 16")

      for(player <- players if player.age <= 16)
        println(player)

  }

  /************************************************
    Filtering
    **********************************************/
  test("usingFilterInAList"){

    val laptops = List(Laptop(1, "MacBook Air", Some("Colombia")),
      Laptop(2, "2-1 Laptop", None),
      Laptop(3, "AsusXL", Some("Colombia")))

    val actual = laptops.filter( x => x.originPlace.getOrElse("Without origin").equals("Colombia"))

    assert(List(Laptop(1, "MacBook Air", Some("Colombia")), Laptop(3, "AsusXL", Some("Colombia")))=== actual)
  }

  test("usingTakeWhileInAList"){

    val laptops = List(Laptop(1, "MacBook Air", Some("Colombia")),
      Laptop(2, "2-1 Laptop", None),
      Laptop(3, "AsusXL", Some("Colombia")))

    val actual = laptops.takeWhile( x => x.originPlace.getOrElse("Without origin").equals("Colombia"))

    assert(List(Laptop(1, "MacBook Air", Some("Colombia")))=== actual)
  }

  /*****************************************
    Mapping
    **************************************/

  test("usingMapInAList"){
    val fullName = List("Naren", "David", "De Avila", "Julio")

    val actual = fullName.map(x => x.toUpperCase())

    assert(List("NAREN","DAVID","DE AVILA","JULIO") === actual)
  }

  test("usingFlatMapInAListOfList"){

    val lettersOfTheCompanyName = List(List("s"),List("4"), List("n"))

    val actual = lettersOfTheCompanyName.flatMap(x => x.map(_.toUpperCase()))

    assert(List("S","4","N") === actual)
  }


}
