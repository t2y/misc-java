package misc.java;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTimeSample {

  public static final ZoneId ASIA_TOKYO = ZoneId.of("Asia/Tokyo");

  public void showDemo() {
    val now = ZonedDateTime.ofInstant(Instant.now(), ASIA_TOKYO);
    val nowDate = now.truncatedTo(ChronoUnit.DAYS);
    log.info("{}", now);
    log.info("{}", now.toInstant());
    log.info("{}", nowDate);

    val dt = LocalDateTime.of(2020, Month.APRIL, 11, 11, 4, 15);
    val dtInstant = dt.atZone(ASIA_TOKYO).toInstant();
    log.info("{}", dt);
    log.info("{}", dtInstant);

    val dtZoned = ZonedDateTime.of(dt, ASIA_TOKYO);
    val dtZonedDate = dtZoned.truncatedTo(ChronoUnit.DAYS);
    log.info("{}", dtZoned);
    log.info("{}", dtZonedDate);

    log.info("has date and time");
    log.info("compare: {}", now.compareTo(dtZoned));
    log.info("equals: {}", now.equals(dtZoned));

    log.info("has date only");
    log.info("compare: {}", nowDate.compareTo(dtZonedDate));
    log.info("equals: {}", nowDate.equals(dtZonedDate));
  }
}
