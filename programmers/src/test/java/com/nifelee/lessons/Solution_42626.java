package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//더 맵게
//https://programmers.co.kr/learn/courses/30/lessons/42626
@Slf4j
public class Solution_42626 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{1, 2, 3, 9, 10, 12}, 7)).isEqualTo(2);
    Assertions.assertThat(solution(new int[]{1, 2}, 5)).isEqualTo(1);
  }

  //scoville	K	return
  //[1, 2, 3, 9, 10, 12]	7	2
  public int solution(int[] scoville, int K) {
    Queue<Integer> queue = new PriorityQueue<>();
    for (int s : scoville) {
      queue.offer(s);
    }
    log.debug("{}", queue);

    int answer = 0;
    while (queue.size() >= 2) {
      if (queue.peek() >= K)
        return answer;

      int min1 = queue.remove();
      int min2 = queue.remove();

      queue.offer(min1 + (min2 * 2));
      log.debug("{}", queue);

      ++answer;
    }

    return queue.remove() >= K ? answer : -1;
  }

}
