package misc.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunScheduledExecutorService {

  public void run() {
    ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
    scheduled.scheduleAtFixedRate(
        () -> {
          log.info("called from schedule service");
        },
        1,
        1,
        TimeUnit.SECONDS);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    scheduled.shutdown();
  }
}
