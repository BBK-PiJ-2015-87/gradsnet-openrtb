import org.scalatest.{BeforeAndAfter, FunSuite}

class NativeTest extends FunSuite with BeforeAndAfter {

  var native: Native = _

  before {
    native = Native()
  }

  test("must have request specified"){
    assert(native.request == "")
  }
}
