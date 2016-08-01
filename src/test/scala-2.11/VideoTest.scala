import org.scalatest.{BeforeAndAfter, FunSuite}

class VideoTest extends FunSuite with BeforeAndAfter {

  var video: Video = _

  before{
    video = Video()
  }

  test("must have a list with mime types"){
    assert(video.mimes.length == 0)
  }

  test("should have default values as per OpenRTB spec"){
    video = Video.withDefaults

    assert(video.skipmin.get == 0)
    assert(video.skipafter.get == 0)
    assert(video.boxingallowed.get == 1)
  }
}
