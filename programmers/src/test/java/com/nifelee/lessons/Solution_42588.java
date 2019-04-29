package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

@Slf4j
//https://programmers.co.kr/learn/courses/30/lessons/42588
public class Solution_42588 {

  //[6,9,5,7,4]	[0,0,2,2,4]
  //[3,9,9,3,5,7,2]	[0,0,0,3,3,3,6]
  //[1,5,3,6,7,6,5]	[0,0,2,0,0,5,6]
  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{6, 9, 5, 7, 4})).isEqualTo(new int[]{0, 0, 2, 2, 4});
    Assertions.assertThat(solution(new int[]{3, 9, 9, 3, 5, 7, 2})).isEqualTo(new int[]{0, 0, 0, 3, 3, 3, 6});
    Assertions.assertThat(solution(new int[]{1, 5, 3, 6, 7, 6, 5})).isEqualTo(new int[]{0, 0, 2, 0, 0, 5, 6});
  }

  public int[] solution(int[] heights) {
    int[] answer = new int[heights.length];
    for (int i=heights.length-1; i>0; i--) {
      for (int j=i-1; j>=0; j--) {
        if (heights[i] < heights[j]) {
          answer[i] = j + 1;
          break;
        }
      }
    }
    return answer;
  }

}
