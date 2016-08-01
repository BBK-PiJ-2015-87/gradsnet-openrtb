import org.scalatest.{BeforeAndAfter, FunSuite}

class ImpTest extends FunSuite with BeforeAndAfter {

  var impression: Imp = _

  before {
    impression = Imp(id = "123")
  }

  test("impression must have an ID"){
    assert(impression.id == "123")
  }
}
