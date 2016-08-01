import org.scalatest.{BeforeAndAfter, FunSuite}

class BidRequestTest extends FunSuite with BeforeAndAfter {

  var bidRequest: BidRequest = _

  before {
    bidRequest = BidRequest(id = "123", imp = List())
  }

  test("bid request must have an ID"){
    assert(bidRequest.id == "123")
  }

  test("bid request must have a list of impressions"){
    assert(bidRequest.imp.length == 0)
  }

  test("bid request may not have a publisher site object"){
    assert(bidRequest.site.isEmpty)
  }

  test("bid request may not have an app object"){
    assert(bidRequest.app.isEmpty)
  }

  test("bid request may not have a device object"){
    assert(bidRequest.device.isEmpty)
  }

  test("bid request may not have user object") {
    assert(bidRequest.user.isEmpty)
  }

  test("bid request may not have test mode defined") {
    assert(bidRequest.test.isEmpty)
  }

  test("value of test mode may not be defined"){
    assert(bidRequest.test.isEmpty)
  }

  test("bid request may not have auction type defined") {
    assert(bidRequest.at.isEmpty)
  }

  test("value of auction type in bid request may not be defined"){
    assert(bidRequest.at.isEmpty)
  }

  test("bid request may not contain a maximum time in milliseconds to make a bid"){
    assert(bidRequest.tmax.isEmpty)
  }

  test("bid request may not contain a whitelist of allowed buyers"){
    assert(bidRequest.wseat.isEmpty)
  }

  test("bid request may not define a flag to indicate if exchange can verify that the impressions offered are all available in the context"){
    assert(bidRequest.allimps.isEmpty)
  }

  test("bid request may not define impressions offered in context flag"){
    assert(bidRequest.allimps.isEmpty)
  }

  test("bid request may not have a list of currencies"){
    assert(bidRequest.cur.isEmpty)
  }

  test("bid request may not have a list of blocked categories"){
    assert(bidRequest.bcat.isEmpty)
  }

  test("bid request may not have a list of blocked advertiser domains"){
    assert(bidRequest.badv.isEmpty)
  }

  test("bid request may not have a list of blocked application's identifiers"){
    assert(bidRequest.bapp.isEmpty)
  }

  test("bid request may not have an object with regulations"){
    assert(bidRequest.regs.isEmpty)
  }

  test("bid request may not have an object with exchange-specific extensions"){
    assert(bidRequest.ext.isEmpty)
  }
}
