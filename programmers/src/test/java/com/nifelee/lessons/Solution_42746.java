package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//가장 큰 수
//https://programmers.co.kr/learn/courses/30/lessons/42746
@Slf4j
public class Solution_42746 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{6, 10, 2})).isEqualTo("6210");
    Assertions.assertThat(solution(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    Assertions.assertThat(solution(new int[]{40, 403})).isEqualTo("40403");
    Assertions.assertThat(solution(new int[]{0, 0, 0, 1000})).isEqualTo("1000000");
    Assertions.assertThat(solution(new int[]{12, 1213})).isEqualTo("121312");
    Assertions.assertThat(solution(new int[]{2, 22, 223})).isEqualTo("223222");
    Assertions.assertThat(solution(new int[]{0,0,0,1000})).isEqualTo("1000000");
  }

  //numbers	return
  //[6, 10, 2]	6210
  //[3, 30, 34, 5, 9]	9534330
  public String solution(int[] numbers) {
    List<String> list = new ArrayList<>();
    for (int n : numbers) {
      list.add(String.valueOf(n));
    }

    list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
    if (list.get(0).equals("0")) return "0";

    StringBuilder answer = new StringBuilder();
    for (String s : list)
      answer.append(s);
    return answer.toString();
  }

}
