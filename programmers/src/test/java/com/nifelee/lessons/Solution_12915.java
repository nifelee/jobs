package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12915
@Slf4j
public class Solution_12915 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new String[]{"sun", "bed", "car"}, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
    Assertions.assertThat(solution(new String[]{"abce", "abcd", "cdx"}, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
  }

  //[sun, bed, car]	1	[car, bed, sun]
  //[abce, abcd, cdx]	2	[abcd, abce, cdx]
  public String[] solution(String[] strings, int n) {
    Arrays.sort(strings, (s1, s2) -> {
      if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
      else return Character.compare(s1.charAt(n), s2.charAt(n));
    });

    return strings;
  }

}
