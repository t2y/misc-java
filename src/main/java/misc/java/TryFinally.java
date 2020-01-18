package misc.java;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryFinally {

  private void doHeavyProcess(String name, int maxCount) {
    var count = 0;
    while (count < maxCount) {
      log.info(name + ", count: " + count);
      try {
        TimeUnit.SECONDS.sleep(1);
        count++;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void terminateProcess() {
    this.doHeavyProcess("terminate", 10);
  }

  private void mainProcess() {
    this.doHeavyProcess("main", 5);
  }

  public void doSome() {
    try {
      //if (true) throw new RuntimeException("test");
      mainProcess();
    } finally {
      terminateProcess();
    }
  }
}
