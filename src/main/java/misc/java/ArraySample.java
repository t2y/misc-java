package misc.java;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraySample {

  public void showCompareResults() {
    List<String> x = Arrays.asList("a", "b", "c");
    List<String> y = Arrays.asList("b", "c", "a");
    List<String> z = Arrays.asList("a", "b", "c");
    log.info("compare1: " + x.equals(y));
    log.info("compare2: " + z.equals(x));
  }
}
