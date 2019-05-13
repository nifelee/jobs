package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

//124 나라의 숫자
//https://programmers.co.kr/learn/courses/30/lessons/12899
@Slf4j
public class Solution_12899 {

  @Test
  public void test() {
    Assertions.assertThat(solution(1)).isEqualTo("1");
    Assertions.assertThat(solution(2)).isEqualTo("2");
    Assertions.assertThat(solution(3)).isEqualTo("4");

    Assertions.assertThat(solution(4)).isEqualTo("11");
    Assertions.assertThat(solution(5)).isEqualTo("12");
    Assertions.assertThat(solution(6)).isEqualTo("14");

    Assertions.assertThat(solution(18)).isEqualTo("124");
    Assertions.assertThat(solution(24)).isEqualTo("214");
  }

  /*
  1-1, 2-2, 3-4
  4-11, 5-12, 6-14
  7-21, 8-22, 9-24
  10-41, 11-42, 12-44
  13-111, 14-112, 15-114
  16-121, 17-122, 18-124
  19-141, 20-142, 21-144
  22-211, 23-212, 24-214
  */
  public String solution(int n) {
    String answer = "";
    int[] reminder = {4, 1, 2};

    while (n > 0) {
      int r = n % 3;
      if (r == 0)
        --n;

      answer = reminder[r] + answer;
      n /= 3;
    }

    return answer;
  }

}
