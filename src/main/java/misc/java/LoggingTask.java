package misc.java;

import java.util.concurrent.ForkJoinTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingTask extends ForkJoinTask<Void> {

  private static final long serialVersionUID = 1L;

  @Override
  protected boolean exec() {
    var i = 0;
    var j = 0;
    while (i < 1000) {
      log.info("i: {}", i);
      log.debug("j: {}", j);
      i++;
      j++;
      Utils.sleep(1000);
    }
    return true;
  }

  @Override
  public Void getRawResult() {
    return null;
  }

  @Override
  protected void setRawResult(Void value) {}
}
