package misc.java;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {
    log.info("start");
    val tf = new TryFinally();
    tf.doSome();
    log.info("end");
  }
}
