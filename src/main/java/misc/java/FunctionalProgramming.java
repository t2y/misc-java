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

  public void showDemo1() {
    List<String> data = Arrays.asList("foo", null, "bar", null);
    log.info(data.toString());
    val results = data.stream().filter(NON_NULL).collect(Collectors.toList());
    log.info(results.toString());
  }

  private static final NumberComparableOperator<Integer> MORE_THAN_OR_EQUAL =
      (t1, t2) -> t1.compareTo(t2) >= 0;
  private static final NumberComparableOperator<Integer> MORE_THAN = (t1, t2) -> t1.compareTo(t2) > 0;

  public void showDemo2() {
    val x = 3;
    val y = 3;
    val z = 5;
    log.info("{}", MORE_THAN_OR_EQUAL.apply(x, y));
    log.info("{}", MORE_THAN_OR_EQUAL.apply(x, z));
    log.info("{}", MORE_THAN.apply(x, y));

    ExpressionComparatorImpl<NumberComparableOperator<Integer>, Integer> ec =
        new ExpressionComparatorImpl<>();
    log.info("{}", ec.test(MORE_THAN_OR_EQUAL, x, y));
    log.info("{}", ec.test(MORE_THAN, x, y));
  }
}
