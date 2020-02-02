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

  private static void showClassName() {
    log.info("getName(): " + Main.class.getName());
    log.info("getSimpleName(): " + Main.class.getSimpleName());
  }

  private static void showFunctionalProgramming() {
    val fp = new FunctionalProgramming();
    fp.showDemo();
  }

  private static void showArraySample() {
    val a = new ArraySample();
    a.showCompareResults();
  }

  public static void main(String[] args) {
    log.info("start");
    showArraySample();
    log.info("end");
  }
}
