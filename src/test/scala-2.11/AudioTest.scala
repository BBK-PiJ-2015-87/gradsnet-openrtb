import org.scalatest.{BeforeAndAfter, FunSuite}

class AudioTest extends FunSuite with BeforeAndAfter {

  var audio: Audio = _

  before {
    audio = Audio()
  }

  test("must have a list of mime types"){
    assert(audio.mimes.length == 0)
  }

}
