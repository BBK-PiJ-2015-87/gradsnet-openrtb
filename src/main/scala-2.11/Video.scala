/**
  *
  * @param mimes
  * @param minduration
  * @param maxduration
  * @param protocols
  * @param protocol
  * @param w
  * @param h
  * @param startdelay
  * @param linearity
  * @param skip
  * @param skipmin
  * @param skipafter
  * @param sequence
  * @param battr
  * @param maxextended
  * @param minbitrate
  * @param maxbitrate
  * @param boxingallowed
  * @param playbackmethod
  * @param delivery
  * @param pos
  * @param companionad
  * @param api
  * @param companiontype
  * @param ext
  */
case class Video(
                   mimes:           List[String] = List(),
                   minduration:     Option[Int] = None,
                   maxduration:     Option[Int] = None,
                   protocols:       Option[List[Int]] = None,
                   protocol:        Option[Int] = None,
                   w:               Option[Int] = None,
                   h:               Option[Int] = None,
                   startdelay:      Option[Int] = None,
                   linearity:       Option[Int] = None,
                   skip:            Option[Int] = None,
                   skipmin:         Option[Int] = None,
                   skipafter:       Option[Int] = None,
                   sequence:        Option[Int] = None,
                   battr:           Option[List[Int]] = None,
                   maxextended:     Option[Int] = None,
                   minbitrate:      Option[Int] = None,
                   maxbitrate:      Option[Int] = None,
                   boxingallowed:   Option[Int] = None,
                   playbackmethod:  Option[List[Int]] = None,
                   delivery:        Option[List[Int]] = None,
                   pos:             Option[Int] = None,
                   companionad:     Option[List[Banner]] = None,
                   api:             Option[List[Int]] = None,
                   companiontype:   Option[List[Int]] = None,
                   ext:             Option[Ext] = None
                )
{

}

object Video {

}
