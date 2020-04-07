package misc.java;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapSample {

  private final Map<String, String> m = new HashMap<>();

  {
    m.put("key1", "value1");
    m.put("key2", "value2");
    m.put("key3", null);
  }

  public void show() {
    log.info("key1: {}", m.get("key1"));
    log.info("key3: {}", m.get("key3"));
    log.info("key4: {}", m.get("key4"));
  }
}
