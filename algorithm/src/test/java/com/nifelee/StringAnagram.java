package com.nifelee;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 주어진 문자열이 애너그램인지를 판단
 */
@Slf4j
public class StringAnagram {

  @Test
  public void anagram() {
    Assertions.assertThat(isAnagram("rca", "car")).isTrue();

    Assertions.assertThat(isAnagram("rca", "carr")).isFalse();
    Assertions.assertThat(isAnagram("rca", "caz")).isFalse();

    Assertions.assertThat(isAnagram("caabbbb", "abababc")).isFalse();
  }

  private boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;

    Map<Character, Integer> map = new HashMap<>();
    for (char c : str1.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }

    for (char c : str2.toCharArray()) {
      if (map.get(c) == null)
        return false;

      if (map.get(c) == 0)
        return false;

      map.merge(c, -1, Integer::sum);
    }

    return true;
  }

}
