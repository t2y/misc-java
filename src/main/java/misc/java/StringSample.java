package misc.java;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringSample {

  public void show() {
    val s1 = " test  ";
    log.info("'{}'.trim() : '{}'", s1, s1.trim());
    log.info("'{}'.strip(): '{}'", s1, s1.strip());
    val s2 = "\u205F\u205Ftest\u205F";
    log.info("'{}'.trim() : '{}'", s2, s2.trim());
    log.info("'{}'.strip(): '{}'", s2, s2.strip());
  }
}
