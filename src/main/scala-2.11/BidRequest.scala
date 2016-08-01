/**
  * BidRequest represents a request from the Exchange.
  *
  * @param id
  * @param imp
  * @param site
  * @param app
  * @param device
  * @param user
  * @param test
  * @param at
  * @param tmax
  * @param wseat
  * @param allimps
  * @param cur
  * @param bcat
  * @param badv
  * @param bapp
  * @param regs
  * @param ext
  */
case class BidRequest (
                      id:       String = "",
                      imp:      List[Imp] = List(),
                      site:     Option[Site] = None,
                      app:      Option[App]= None,
                      device:   Option[Device] = None,
                      user:     Option[User] = None,
                      test:     Option[Int] = None,
                      at:       Option[Int] = None,
                      tmax:     Option[Int] = None,
                      wseat:    Option[List[String]] = None,
                      allimps:  Option[Int] = None,
                      cur:      Option[List[String]] = None,
                      bcat:     Option[List[String]] = None,
                      badv:     Option[List[String]] = None,
                      bapp:     Option[List[String]] = None,
                      regs:     Option[Regs] = None,
                      ext:      Option[Ext] = None
                      ) {
  //required by OpenRTB
  require(!id.isEmpty, "ID is required")
  require(!imp.isEmpty, "At least one impression is required")

  //default values by OpenRTB
  require(test.isEmpty || test.contains(0) || test.contains(1), "If provided, indicator of test must be 0 (live mode) or 1 (test mode)")
  require(at.isEmpty || at.contains(1) || at.contains(2) || at.get > 500, "If provided, auction type must be 1 (first price), 2 (second price) or > 500 (for exchange-specific")
  require(allimps.isEmpty || allimps.contains(0) || allimps.contains(1), "If provided, flag must be set to 0 (no) or 1 (yes)")

}
