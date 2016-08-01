import org.scalatest.{BeforeAndAfter, FunSuite}

class ImpTest extends FunSuite with BeforeAndAfter {

  var impression: Imp = _

  before {
    impression = Imp(id = "123")
  }

  test("impression must have an ID"){
    assert(impression.id == "123")
  }

  test("impression with default values as per OpenRTB spec"){
    impression = Imp.withDefaults

    assert(impression.id == "")
    assert(impression.instl.get == 0)
    assert(impression.bidfloor.get == 0)
    assert(impression.bidfloorcur.get == "USD")
  }
}
