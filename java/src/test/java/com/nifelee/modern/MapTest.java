package com.nifelee.modern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapTest {

  private final Map<String, Integer> map = new HashMap<>();

  @Before
  public void before() {
    map.put("a", 1);
    map.put("b", 2);
  }

  /**
   * default void forEach(BiConsumer<? super K, ? super V> action)
   */
  @Test
  public void forEach() {
    map.forEach((key, value) -> log.debug("{}:{}", key, value));
  }

  /**
   * default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
   */
  @Test
  public void compute() {
    //classic java
    //int val = map.get("a");
    //map.put("a", ++val);

    int rtn = map.compute("a", (key, value) -> ++value);
    log.debug("rtn : {}", rtn);
  }

  @Test(expected = NullPointerException.class)
  public void compute_npe() {
    map.compute("가", (key, value) -> ++value);
  }

}
