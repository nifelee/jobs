package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//위장
//https://programmers.co.kr/learn/courses/30/lessons/42578
@Slf4j
public class Solution_42578 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})).isEqualTo(5);
    Assertions.assertThat(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})).isEqualTo(3);
  }

  //clothes	return
  //[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
  //[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();
    for (String[] clothe : clothes) {
      map.merge(clothe[1], 1, Integer::sum);
    }

    int answer = 1;
    for (int i : map.values()) {
      answer *= (i + 1);
    }
    return answer - 1;
  }

}
