package com.nifelee.modern;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
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
    Assertions.assertThat(rtn).isEqualTo(2);
  }

  @Test(expected = NullPointerException.class)
  public void compute_npe() {
    map.compute("가", (key, value) -> ++value);
  }

  /**
   * default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
   */
  //`compute`와 반대, `key`가 없을 경우 return
  @Test
  public void computeIfAbsent() {
    int rtn = map.computeIfAbsent("가", key -> 1);
    log.debug("rtn : {}", rtn);
    Assertions.assertThat(rtn).isEqualTo(1);
  }

  /**
   * default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
   */
  //`computeIfAbsent`와 반대
  @Test
  public void computeIfPresent() {
    int rtn = map.computeIfPresent("a", (key, value) -> ++value);
    log.debug("rtn : {}", rtn);
    Assertions.assertThat(rtn).isEqualTo(2);
  }

  /**
   * default V getOrDefault(Object key, V defaultValue)
   */
  @Test
  public void getOrDefault() {
    int rtn = map.getOrDefault("가", 1);
    log.debug("rtn : {}", rtn);
    Assertions.assertThat(rtn).isEqualTo(1);
  }

  /**
   * default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
   */
  @Test
  public void merge() {
    int rtn = map.merge("a", 1, Integer::sum);
    log.debug("rtn : {}", rtn);
    Assertions.assertThat(rtn).isEqualTo(2);

    int rtn2 = map.merge("가", 1, Integer::sum);
    log.debug("rtn2 : {}", rtn2);
    Assertions.assertThat(rtn2).isEqualTo(1);
  }

  /**
   * default V putIfAbsent(K key, V value)
   */
  @Test
  public void putIfAbsent() {
    map.putIfAbsent("가", 1);
    int rtn = map.get("가");
    log.debug("rtn : {}", rtn);
    Assertions.assertThat(rtn).isEqualTo(1);
  }

  /**
   * default boolean remove(Object key, Object value)
   */
  @Test
  public void remove() {
    boolean isRemove = map.remove("a", 1);
    Assertions.assertThat(isRemove).isTrue();

    boolean isRemove2 = map.remove("가", 1);
    Assertions.assertThat(isRemove2).isFalse();
  }

  /**
   * default V replace(K key, V value)
   */
  @Test
  public void replace() {
    int value = map.replace("a", 2);
    Assertions.assertThat(value).isEqualTo(1);

    Integer value2 = map.replace("가", 1);
    Assertions.assertThat(value2).isEqualTo(null);
  }

  /**
   * default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
   */
  @Test
  public void replaceAll() {
    map.replaceAll((key, value) -> value + 1);

    int a = map.get("a");
    int b = map.get("b");
    Assertions.assertThat(a).isEqualTo(2);
    Assertions.assertThat(b).isEqualTo(3);
  }

}
