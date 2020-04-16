package misc.java;

import java.util.Arrays;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListSample {

  public void showSubList() {
    val data = Arrays.asList(1, 2, 3, 4, 5);
    for (val e : data.subList(2, 4)) {
      log.info("e : {}", e);
    }
    log.info("--------------------------------");
    
    for (val e : data.subList(1, data.size())) {
      log.info("e : {}", e);
    }
    log.info("--------------------------------");
    
    val view = data.subList(2,  data.size());
    view.set(0, 9);
    for (val e : data) {
      log.info("(data) e: {}", e);
    }
    log.info("--------------------------------");
    data.set(2, 8);
    for (val e : view) {
      log.info("(view) e: {}", e);
    }
    
    
  }
}
