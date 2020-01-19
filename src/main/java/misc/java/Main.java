package misc.java;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  private static void doTryFinally() {
    val tf = new TryFinally();
    tf.doSome();
  }

  private static void runScheduledExecutorService() {
    val executor = new RunScheduledExecutorService();
    executor.run();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    log.info("start");
    runScheduledExecutorService();
    log.info("end");
  }
}