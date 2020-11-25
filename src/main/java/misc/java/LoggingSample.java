package misc.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;

@Slf4j
public class LoggingSample {

  private void setLogLevel(String name, Level level) {
    val logger = (Logger) LoggerFactory.getLogger(name);
    logger.setLevel(level);
  }

  private void setAppender(String name) {
    val logger = (Logger) LoggerFactory.getLogger(name);
    val context = new LoggerContext();

    val encoder = new PatternLayoutEncoder();
    encoder.setContext(context);
    encoder.setPattern("%-5level custom logging %message%n");
    encoder.start();

    val filter = new LoggingFilter();
    filter.start();

    val appender = new ConsoleAppender<ILoggingEvent>();
    appender.setName("MyConsoleAppender");
    appender.setEncoder(encoder);
    appender.setContext(context);
    appender.addFilter(filter);
    appender.start();

    logger.addAppender(appender);
  }

  private void removeAppender(String loggerName, String appenderName) {
    val logger = (Logger) LoggerFactory.getLogger(loggerName);
    logger.detachAppender(appenderName);
  }

  public void show() {

    val pool = new ForkJoinPool(1);
    val future = pool.submit(new LoggingTask());
    log.info("submit thread");

    Utils.sleep(3000);

    val loggerName = "misc.java.LoggingTask";

    this.setLogLevel(loggerName, Level.INFO);
    log.info("changed log level: {}", Level.INFO);

    Utils.sleep(3000);

    this.setLogLevel(loggerName, Level.DEBUG);
    log.info("changed log level: {}", Level.DEBUG);

    Utils.sleep(3000);
    this.setLogLevel(loggerName, Level.INFO);
    log.info("changed log level: {}", Level.INFO);

    Utils.sleep(3000);
    this.setAppender(loggerName);
    log.info("appended newly my console logger");

    Utils.sleep(6000);
    this.removeAppender(loggerName, "MyConsoleAppender");
    log.info("removed my console logger");

    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
