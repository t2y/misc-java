package misc.java;

import com.google.common.base.Strings;

import java.util.Optional;
import java.util.function.Predicate;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalSample {

  private void showWithJava11() {
    log.info("in case java11");
    val value1 = "test";
    val opt1 = Optional.ofNullable(value1).filter(Predicate.not(String::isEmpty));
    log.info("opt1: {}", opt1.isEmpty());
    log.info("opt1 value: {}", opt1.get());

    val value2 = "";
    val opt2 = Optional.ofNullable(value2).filter(Predicate.not(String::isEmpty));
    log.info("opt2: {}", opt2.isEmpty());

    String value3 = null;
    val opt3 = Optional.ofNullable(value3).filter(Predicate.not(String::isEmpty));
    log.info("opt3: {}", opt3.isEmpty());
  }

  private void showWithGuava() {
    log.info("in case guava");
    val value1 = "test";
    Optional<String> opt1 = Optional.ofNullable(Strings.emptyToNull(value1));
    log.info("opt1: {}", opt1.isEmpty());
    log.info("opt1 value: {}", opt1.get());

    val value2 = "";
    val opt2 = Optional.ofNullable(Strings.emptyToNull(value2));
    log.info("opt2: {}", opt2.isEmpty());

    String value3 = null;
    val opt3 = Optional.ofNullable(Strings.emptyToNull(value3));
    log.info("opt3: {}", opt3.isEmpty());
  }

  public void show() {
    this.showWithJava11();
    log.info("--------------------------------");
    this.showWithGuava();
  }
}
