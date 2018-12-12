import org.scalatest.FunSuite

class SetTest extends FunSuite{

  test("simpleSet"){

    val futureCompany = Set("S","4","N")

    assert(Set("S","4","N")=== futureCompany)
  }

  /********************************************
    Tests
    *****************************************/
  test("usingApply"){
    val futureCompany = Set("S","4","N")

    val actual = futureCompany.apply("4")

    assert(true === actual)
  }

  test("usingApply02"){
    val futureCompany = Set("S","4","N")

    val actual = futureCompany.contains("4")

    assert(true === actual)
  }

  test("usingApply03"){
    val futureCompany = Set("S","4","N")

    val actual = futureCompany("4")

    assert(true === actual)
  }

  test("usingSubsetOf "){

    val fullName = Set("Naren", "David", "De Avila", "Julio")

    val firstName = Set("Naren")

    val actual = firstName.subsetOf(fullName)

    assert(true === actual)
  }

  /***************************************************
    Additions
    ************************************************/
  test("addingOneElementOfASet"){

    val principles = Set("Purpose", "Autonomy", "Mastery", "Distributed intelligence", "No dress code")

    val actual = principles + "No code of schedule"

    assert(Set("Purpose", "Autonomy", "Mastery", "Distributed intelligence", "No dress code", "No code of schedule")=== actual)
  }

  test("addingMoreThanOneElementOfASet"){

    val principles = Set("Purpose", "Autonomy", "Mastery", "Distributed intelligence", "No dress code")

    val actual = principles ++ Set("No dress code", "No code of schedule")

    assert(Set("Purpose", "Autonomy", "Mastery", "Distributed intelligence", "No dress code", "No code of schedule")=== actual)
  }

  /*************************************************
    Removals
    ************************************************/

  test("removingOneElementOfASet"){

    val clients = Set("CopaAirlines", "SURA","ATH", "BancoX")

    val actual = clients - "BancoX"

    assert(Set("CopaAirlines", "SURA","ATH") === actual)
  }
  test("removingMoreThanOneElementOfASet"){

    val clients = Set("CopaAirlines", "SURA","ATH", "BancoX", "BadClients")

    val actual = clients -- Set("BancoX", "BadClients")

    assert(Set("CopaAirlines", "SURA","ATH") === actual)
  }

  /************************************************************
    Set operations for union, intersection, and set difference.

    alphabetic    symbolic
               :
    union      :  |
    intersect  :  &
    diff       :  &~
    **********************************************************/

  test("unionOfSets"){

    val odds = Set(2,4,6,8)

    val evens = Set(1,3,5,7,9)

    val actual = odds.union(evens)

    assert(Set(1,2,3,4,5,6,7,8,9) === actual)

  }

  test("intersectionOfSets"){

    val someNumbers = Set(1,2,3,4,5,6,8)

    val evens = Set(1,3,5,7,9)

    val actual = someNumbers.intersect(evens)

    assert(Set(1,3,5) === actual)

  }

  test("differenceOfSets"){

    val someNumbers = Set(1,2,3,4,5,6,8)

    val evens = Set(1,3,5,7,9)

    val actual = someNumbers.diff(evens)

    assert(Set(2,4,6,8) === actual)

  }
}
