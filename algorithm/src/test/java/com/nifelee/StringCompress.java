package com.nifelee;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 주어진 문자열을 길이와 함께 적어주면서 압축
 */
@Slf4j
public class StringCompress {

  private String str = "abc123abc";
  private String result = "a2b2c2112131";

  @Test
  public void compress() {
    Map<Character, Integer> map = new LinkedHashMap<>();
    char[] chars = str.toCharArray();

    for (char c : chars) {
      //int count = map.getOrDefault(c, 0);
      //map.put(c, ++count);

      map.merge(c, 1, Integer::sum);
    }

    StringBuilder result = new StringBuilder();
    map.forEach((character, integer) -> result.append(character).append(integer));
    Assertions.assertThat(result.toString()).isEqualTo(this.result);
  }

  @Test
  public void compress2() {

  }

}
