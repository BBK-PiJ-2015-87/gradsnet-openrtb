import org.scalatest._

class BidRequestTest extends FunSuite with BeforeAndAfter {

  var bidRequest: BidRequest = _

  before {
    bidRequest = BidRequest(id = "123", imp = List(new Imp))
  }

  test("bid request must have an ID"){
    intercept[IllegalArgumentException]{
      bidRequest.copy(id = "")
    }
  }

  test("bid request must have at least one impression"){
    intercept[IllegalArgumentException]{
      bidRequest.copy(imp = List())
    }
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

  test("if defined, value of test mode in bid request must be set to 0 or 1"){
    bidRequest = bidRequest.copy(test = Some(0))
    assert(bidRequest.test.get == 0)

    bidRequest = bidRequest.copy(test = Some(1))
    assert(bidRequest.test.get == 1)

    intercept[IllegalArgumentException]{
      bidRequest.copy(test = Some(3))
    }
  }

  test("bid request may not have auction typedefined") {
    assert(!bidRequest.at.isDefined)
  }

  test("if defined, value of auction type in bid request must be set to 1 (First price) or 2 (Second price) or be greater than 500 if exchange specific"){
    bidRequest = bidRequest.copy(at = Some(1))
    assert(bidRequest.at.get == 1)

    bidRequest = bidRequest.copy(at = Some(2))
    assert(bidRequest.at.get == 2)

    bidRequest = bidRequest.copy(at = Some(501))
    assert(bidRequest.at.get == 501)

    intercept[IllegalArgumentException]{
      bidRequest.copy(at = Some(450))
    }
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

  test("bid request must indicate to exchange that the impressions offered in context flag is set to 0 (no or unknown) or 1 (yes)"){
    bidRequest = bidRequest.copy(allimps = Some(0))
    assert(bidRequest.allimps.get == 0)

    bidRequest = bidRequest.copy(allimps = Some(1))
    assert(bidRequest.allimps.get == 1)

    intercept[IllegalArgumentException]{
      bidRequest.copy(allimps = Some(2))
    }
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
