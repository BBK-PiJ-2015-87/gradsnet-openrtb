import com.fasterxml.jackson.databind.{ObjectMapper, JsonNode}
import org.openrtb.validator.{OpenRtbVersion, OpenRtbInputType, OpenRtbValidatorFactory}
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.io.Source

class BidRequestTransformerTest extends FunSuite with BeforeAndAfter{

  val transformer = BidRequestTransformer

  test("should construct bid request from json file"){
    val json = scala.io.Source.fromFile("src/test/resources/mobileBidRequest.json").mkString
    val bidRequest = transformer.fromJsonToBidRequest(json)

    val imp = bidRequest.imp(0)
    val banner = imp.banner.get
    val app = bidRequest.app.get
    val publisher = app.publisher.get
    val device = bidRequest.device.get
    val geo = device.geo.get
    val user = bidRequest.user.get

    assert(bidRequest.id == "IxexyLDIIk")
    assert(imp.id == "1")
    assert(imp.instl.get == 0)
    assert(imp.tagid.get == "agltb3B1Yi1pbmNyDQsSBFNpdGUY7fD0FAw")
    assert(imp.bidfloor.get == 0.5f)
    assert(banner.w.get == 728)
    assert(banner.h.get == 90)
    assert(banner.pos.get == 1)
    assert(banner.btype.get == List(4))
    assert(banner.battr.get == List(14))
    assert(banner.api.get == List(3))
    assert(app.id.get == "agltb3B1Yi1pbmNyDAsSA0FwcBiJkfIUDA")
    assert(app.name.get == "Yahoo Weather")
    assert(app.cat.get == List("weather", "IAB15", "IAB15-10"))
    assert(app.ver.get == "1.0.2")
    assert(app.storeurl.get == "https://itunes.apple.com/id628677149")
    assert(app.bundle.get == "628677149")
    assert(publisher.id.get == "agltb3B1Yi1pbmNyDAsSA0FwcBiJkfTUCV")
    assert(publisher.name.get == "yahoo")
    assert(publisher.domain.get == "www.yahoo.com")
    assert(device.dnt.get == 0)
    assert(device.ua.get == "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3")
    assert(device.ip.get == "123.145.167.189")
    assert(device.dpidsha1.get == "AA000DFE74168477C70D291f574D344790E0BB11")
    assert(device.dpidmd5.get == "AA003EABFB29E6F759F3BDAB34E50BB11")
    assert(device.carrier.get == "310-410")
    assert(device.language.get == "en")
    assert(device.make.get == "Apple")
    assert(device.model.get == "iPhone")
    assert(device.os.get == "iOS")
    assert(device.osv.get == "6.1")
    assert(device.js.get == 1)
    assert(device.connectiontype.get == 3)
    assert(device.devicetype.get == 1)
    assert(geo.country.get == "USA")
    assert(geo.lat.get == 35.012345d)
    assert(geo.lon.get == -115.12345d)
    assert(geo.city.get == "Los Angeles")
    assert(geo.metro.get == "803")
    assert(geo.region.get == "CA")
    assert(geo.zip.get == "90049")
    assert(user.id.get == "ffffffd5135596709273b3a1a07e466ea2bf4fff")
    assert(user.yob.get == 1984)
    assert(user.gender.get == "M")
    assert(bidRequest.at.get == 2)
    assert(bidRequest.bcat.get == List("IAB25", "IAB7-39", "IAB8-18", "IAB8-5", "IAB9-9"))
    assert(bidRequest.badv.get == List("apple.com", "go-text.me", "heywire.com"))
  }


  test("should transform bid request object to json string "){
    val mapper = new ObjectMapper;
    val jsonNode = mapper.readTree("{\"key\":\"value\"}");

    val id = "1"
    val banner = Banner(id = Some("1"), w = Some(1))
    val imp1 = Imp(id = "1", banner = Some(banner))
    val imp2 = Imp(id = "2", banner = Some(banner))
    val site = Site(id = Some("1"))
    val app = App(id = Some("1"))
    val device = Device(ua = Some("Firefox"))
    val user = User(id = Some("1"))
    val test = Some(1)
    val at = Some(1)
    val tmax = Some(1)
    val wseat = Some(List("1", "2"))
    val allimps = Some(1)
    val cur = Some(List("USD", "GBP"))
    val bcat = Some(List("one", "two"))
    val badv = Some(List("google", "yahoo"))
    val bapp = Some(List("istore", "googlestore"))
    val regs = Regs()
    val ext = Ext(None)

    val bidRequest = BidRequest(
      id,
      List(imp1, imp2),
      Some(site),
      Some(app),
      Some(device),
      Some(user),
      test,
      at,
      tmax,
      wseat,
      allimps,
      cur,
      bcat,
      badv,
      bapp,
      Some(regs),
      Some(ext)
    )

    val validator = OpenRtbValidatorFactory.getValidator(OpenRtbInputType.BID_REQUEST, OpenRtbVersion.V2_3)

    val expected = Source.fromFile("src/test/resources/bidRequestAsString.txt").mkString
    val result = transformer.bidRequestToJson(bidRequest)

    val result2 = validator.validate(result)
    println(result2.isValid)

    assert(result == expected)
  }
}
