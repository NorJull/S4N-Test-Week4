import com.vamosaprogramar.entity.PartyTicket
import org.scalatest.FunSuite

class MapTest extends FunSuite{

  test("simpleMap"){
    val departaments = Map(1 -> "Bolivar", 2 -> "Antioquia", 3 -> "Valle del Cauca")

    assert(Map(1 -> "Bolivar", 2 -> "Antioquia", 3 -> "Valle del Cauca") === departaments)
  }

  test("simpleMap02"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    assert(Map(1 -> "Bolivar", 2 -> "Antioquia", 3 -> "Valle del Cauca") === departaments)

  }
  test("simpleMapUsingApply"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    val actual = departaments.apply(2)

    assert("Antioquia" === actual)
  }

  test("simpleMapUsingApply02"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    val actual = departaments(2)

    assert("Antioquia" === actual)
  }

  test("simpleMapUsingGet"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.get(1)

    assert(Some("Bolivar") === actual)
  }

  test("simpleMapUsingGet02"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.get(4)

    assert(None === actual)
  }

  test("simpleMapUsingGetOrElse"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.getOrElse(4, "default")

    assert("default" === actual)
  }

  test("simpleMapUsingContanins_ThenFalse"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.contains(4)

    assert(false === actual)
  }

  test("simpleMapUsingContanins_ThenTrue"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.contains(3)

    assert(true === actual)
  }

  test("simpleMapUsingIsDefinedAt_ThenTrue"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.isDefinedAt(2)

    assert(true === actual)
  }

  test("simpleMapUsingIsDefinedAt_ThenFalse"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.isDefinedAt(9)

    assert(false === actual)
  }

  /***************************************************
    Additions and Updates
    *************************************************/

  test("updatingValuesInAMap"){

    val partyTickets = Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))

    val actual = partyTickets + (1 -> PartyTicket("Friend"))

    assert( Map(1 -> PartyTicket("Friend"), 2 -> PartyTicket("Street seller")) === actual)
  }

  test("addingValuesInAMap"){

    val partyTickets = Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))

    val actual = partyTickets + (3 -> PartyTicket("Friend"))

    assert( Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"), 3 -> PartyTicket("Friend")) === actual)
  }

  test("updatingMoreThanOneValuesInAMap"){

    val partyTickets = Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))

    val actual = partyTickets + (1 -> PartyTicket("Friend"), 2 -> PartyTicket("Wholesaler"))

    assert( Map(1 -> PartyTicket("Friend"), 2 -> PartyTicket("Wholesaler")) === actual)
  }

  test("addingMoreThanOneValuesInAMap"){

    val partyTickets = Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))

    val actual = partyTickets + (3 -> PartyTicket("Friend"), 4 -> PartyTicket("Wholesaler"))

    assert( Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"), 3 -> PartyTicket("Friend"),4 -> PartyTicket("Wholesaler")) === actual)
  }

  test("concatenationOfTwoMap"){
    val partyTickets1 = Map(1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))

    val partyTicket2 = Map(3 -> PartyTicket("Friend"))

    val actual = partyTickets1 ++ partyTicket2

    assert(Map(3 -> PartyTicket("Friend"),1 -> PartyTicket("Official seller"), 2 -> PartyTicket("Street seller"))=== actual)
  }

  /*****************************************************
    Removals
    *************************************************/
  test("removeOneValueInAMap"){

    val names = Map("A" -> "Carlos", "B" -> "Naren", "C" -> "Daniel")

    val actual = names - "A"

    assert(Map("B" -> "Naren", "C" -> "Daniel") === actual)
  }

  test("removeMoreThatOneValueInAMap"){

    val names = Map("A" -> "Carlos", "B" -> "Naren", "C" -> "Daniel")

    val actual = names - ("A","C")

    assert(Map("B" -> "Naren") === actual)
  }

  test("differentBetweenMapAndSeq"){
    val names1 = Map("A" -> "Carlos", "B" -> "Naren", "C" -> "Daniel")

    val names2 = Seq( "C","Daniel")

    val actual = names1 -- names2

    assert(Map("A" -> "Carlos", "B" -> "Naren") === actual)
  }

  /**********************************************
    Subcollections
    *********************************************/

  test("setWithAllTheKeys"){
    val names = Map("A" -> "Carlos", "B" -> "Naren", "C" -> "Daniel")

    val actual = names.keySet

    assert(Set("A","B","C")=== actual)
  }

  /************************************************
    Transformation
    **********************************************/

  test("usingFilterKeys "){

    val ages = Map(23 -> "Naren", 50 -> "Sadith", 60 -> "Orlando")

    val parents = ages.filterKeys(x => x >49)

    assert(Map(50 -> "Sadith", 60 -> "Orlando")===parents)
  }

  test("usingMapValues"){

    val ages = Map(23 -> "Naren", 50 -> "Sadith", 60 -> "Orlando")

    val actual = ages.mapValues(x => x.toUpperCase())

    assert(Map(23 -> "NAREN", 50 -> "SADITH", 60 -> "ORLANDO") === actual)
  }


}
