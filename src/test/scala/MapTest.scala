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
  test("simpleMap03"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    val actual = departaments.apply(2)

    assert("Antioquia" === actual)
  }

  test("simpleMap04"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    val actual = departaments(2)

    assert("Antioquia" === actual)
  }

  test("simpleMap044"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.get(1)

    assert(Some("Bolivar") === actual)
  }

  test("simpleMap0444"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.get(4)

    assert(None === actual)
  }

  test("simpleMap05"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))
    val actual = departaments.getOrElse(4, "default")

    assert("default" === actual)
  }

  test("simpleMap06"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.contains(4)

    assert(false === actual)
  }

  test("simpleMap07"){
    val departaments = Map((1,"Bolivar"), (2, "Antioquia"), (3,"Valle del Cauca"))

    val actual = departaments.contains(3)

    assert(true === actual)
  }
}
