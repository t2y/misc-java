package misc.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamSample {

  private static String[] ranges =
      IntStream.rangeClosed(0, 10).boxed().map(String::valueOf).toArray(String[]::new);

  private static List<Tuple<Integer, String>> multiRanges =
      IntStream.rangeClosed(0, 10)
          .boxed()
          .map(e -> Tuple.of(e, String.valueOf(e)))
          .collect(Collectors.toList());

  public void show() {
    for (int i : IntStream.rangeClosed(0, 10).toArray()) {
      log.info("{}", i);
    }
    log.info("--------------------------------");
    for (String i : ranges) {
      log.info("{}", i);
    }
    log.info("--------------------------------");
    for (Tuple<Integer, String> t : multiRanges) {
      log.info("{}, {}", t.getLeft(), t.getRight());
    }
  }
}
