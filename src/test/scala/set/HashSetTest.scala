package set

import org.scalatest.FunSuite
import scala.collection.immutable.HashSet

class HashSetTest extends FunSuite{

  /**************************************
                Set
                 |
          ----------------
          |
      HashSet

    *************************************/

  test("simpleHashSet"){

    val actual = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    assert( HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela") === actual)
  }

  test("applyMethodHashSet0"){
    val coastPlate = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    val actual = coastPlate("Mojarra Frita")

    assert(actual)

  }

  test("addingOneElementToAHashSet"){

    val coastPlate = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    val actual = coastPlate + "Aguacate"

    assert( HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela", "Aguacate") === actual)
  }

  test("addingMoreThanOneElementToAHashSet"){

    val partsOfCoastPlate1 = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    val partsOfCoastPlate2 = HashSet("Aguacate")

    val actual = partsOfCoastPlate1 ++ partsOfCoastPlate2

    assert( HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela", "Aguacate") === actual)
  }

  test("removeOneElementFromAHashSet"){
    val partsOfCoastPlate1 = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela", "Arepa")

    val actual = partsOfCoastPlate1 - "Arepa"

    assert(HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela") === actual)
  }

  test("usingApplyMethod01"){
    val partsOfCoastPlate1 = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    val actual = partsOfCoastPlate1.apply("Agua de Panela")

    assert(true === actual)
  }

  test("usingApplyMethod02"){
    val partsOfCoastPlate1 = HashSet("Arroz de Coco","Mojarra Frita","Patacones", "Agua de Panela")

    val actual = partsOfCoastPlate1("Agua de Panela")

    assert(true === actual)
  }

  test("usingFor"){

    val album = HashSet(Seq("Song1", "Song2"), Seq("Song3", "Song4", "Xong5"))

    val nameOfSongs = for {
      volumens <- album

      song <- volumens if song.contains("S")

    } yield song.toUpperCase()

    assert(HashSet("SONG2", "SONG3", "SONG4", "SONG1") === nameOfSongs)

  }

  test("usingMap"){
    val volumen = HashSet("Song1", "Song2","Song3", "Song4", "Xong5")

    val nameOfTheSongs = volumen.map(x => x.toUpperCase)

    assert(HashSet("SONG2", "SONG3", "SONG4", "SONG1", "XONG5") === nameOfTheSongs)
  }

  test("usingFlatten"){
    val album = HashSet(Seq("Song1", "Song2"), Seq("Song3", "Song4", "Xong5"))

    val nameOfTheSong = album.flatten

    assert(HashSet("Song1", "Song2","Song3", "Song4", "Xong5") === nameOfTheSong)
  }

  test("usingFlatMap"){
    val album = HashSet(Seq("Song1", "Song2"), Seq("Song3", "Song4", "Xong5"))

    val namesOfTheSongs = album.flatMap(x => x.map(_.concat("-S4N")))

    assert(Set("Song4-S4N", "Xong5-S4N", "Song1-S4N", "Song3-S4N", "Song2-S4N") === namesOfTheSongs)
  }

}
