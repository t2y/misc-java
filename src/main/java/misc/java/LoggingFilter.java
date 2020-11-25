package misc.java;

import lombok.val;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LoggingFilter extends Filter<ILoggingEvent> {

  @Override
  public FilterReply decide(ILoggingEvent event) {
    val args = event.getArgumentArray();
    val number = (int) args[0];
    if (number % 2 == 0) {
      return FilterReply.ACCEPT;
    }
    return FilterReply.DENY;
  }
}
