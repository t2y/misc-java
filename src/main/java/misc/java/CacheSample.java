package misc.java;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheSample {

  private Cache<Integer, String> cache = CacheBuilder.newBuilder().initialCapacity(100).build();

  private LoadingCache<Integer, String> loadingCache =
      CacheBuilder.newBuilder()
          .maximumSize(100)
          .build(
              new CacheLoader<Integer, String>() {
                public String load(Integer key) {
                  log.info("creating cache in loadingCache ...");
                  try {
                    Thread.sleep(3000);
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                  log.info("created cache in loadingCache!");
                  return key.toString();
                }
              });

  private String createCache(Integer key) {
    log.info("creating cache as loader ...");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    log.info("created cache as loader!");
    return key.toString();
  }

  public void useCache() {
    log.info("start: Cache interface");
    Integer key1 = 1;
    cache.put(key1, key1.toString());
    try {
      log.info("before: cache.get(existent)");
      val value = cache.get(key1, () -> createCache(key1));
      log.info("after: cache.get(existent): {}", value);
    } catch (ExecutionException e) {
      log.error(e.getMessage());
    }

    try {
      log.info("before: cache.get(none)");
      Integer key2 = 2;
      val value = cache.get(key2, () -> createCache(key2));
      log.info("after: cache.get(none): {}", value);
    } catch (ExecutionException e) {
      log.error(e.getMessage());
    }
    log.info("end: Cache interface");
  }

  public void useLoadingCache() {
    log.info("start: LoadingCache interface");
    Integer key1 = 1;
    loadingCache.put(key1, key1.toString());
    try {
      log.info("before: cache.get(existent)");
      val value1 = loadingCache.get(key1);
      log.info("after: cache.get(existent): {}", value1);
    } catch (ExecutionException e) {
      log.error(e.getMessage());
    }

    log.info("before: cache.get(none)");
    try {
      Integer key2 = 2;
      val value2 = loadingCache.get(key2);
      log.info("after: cache.get(none): {}", value2);
    } catch (ExecutionException e) {
      log.error(e.getMessage());
    }

    log.info("before: cache.getUnchecked(none)");
    Integer key3 = 3;
    val value3 = loadingCache.getUnchecked(key3);
    log.info("after: cache.getUnchecked(none): {}", value3);

    try {
      log.info("before: cache.get(none, loader)");
      Integer key4 = 4;
      val value4 = loadingCache.get(key4, () -> createCache(key4));
      log.info("after: cache.get(none, loader): {}", value4);
    } catch (ExecutionException e) {
      log.error(e.getMessage());
    }

    log.info("end: LoadingCache interface");
  }
}
