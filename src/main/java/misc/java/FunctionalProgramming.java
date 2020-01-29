package misc.java;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalProgramming {

  private static Predicate<Object> NON_NULL = v -> Objects.nonNull(v);

  public void showDemo() {
    List<String> data = Arrays.asList("foo", null, "bar", null);
    log.info(data.toString());
    val results = data.stream().filter(NON_NULL).collect(Collectors.toList());
    log.info(results.toString());
  }
}
