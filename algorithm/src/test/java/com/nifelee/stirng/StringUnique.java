package com.nifelee.stirng;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 주어진 문자열에서 문자열을 구성하고 있는 각각의 문자열들이 고유한지를 판단
 */
@Slf4j
public class StringUnique {

  private String str = "abc123";
  private String wrongStr = "abc123abc";

  @Test
  public void uniqueBySet() {
    boolean isUnique = uniqueBySet(str);
    Assertions.assertThat(isUnique).isTrue();

    isUnique = uniqueBySet(wrongStr);
    Assertions.assertThat(isUnique).isFalse();
  }

  private boolean uniqueBySet(String str) {
    Set<Character> set = new HashSet<>();

    for (char c : str.toCharArray()) {
      if (set.contains(c)) {
        return false;
      }

      set.add(c);
    }

    return true;
  }

}
