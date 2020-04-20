package misc.java;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamSample {

  private static String[] ranges =
      IntStream.rangeClosed(0, 10).boxed().map(String::valueOf).toArray(String[]::new);

  public void show() {
    for (int i : IntStream.rangeClosed(0, 10).toArray()) {
      log.info("{}", i);
    }
    log.info("--------------------------------");
    for (String i : ranges) {
      log.info("{}", i);
    }
  }
}
