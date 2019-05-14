package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//구명보트
//https://programmers.co.kr/learn/courses/30/lessons/42885
@Slf4j
public class Solution_42885 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{70, 50, 80, 50}, 100)).isEqualTo(3);
    Assertions.assertThat(solution(new int[]{70, 80, 50}, 100)).isEqualTo(3);

    Assertions.assertThat(solution2(new int[]{70, 50, 80, 50}, 100)).isEqualTo(3);
    Assertions.assertThat(solution2(new int[]{70, 80, 50}, 100)).isEqualTo(3);
    Assertions.assertThat(solution2(new int[]{10, 10, 10}, 10)).isEqualTo(3);
    Assertions.assertThat(solution2(new int[]{10, 10, 10}, 100)).isEqualTo(1);
  }

  //people	limit	return
  //[70, 50, 80, 50]	100	3
  //[70, 80, 50]	100	3
  //시간 초과;;
  public int solution(int[] people, int limit) {
    Queue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> asc = new PriorityQueue<>();
    for (int p : people) {
      desc.offer(p);
      asc.offer(p);
    }

    int answer = 0;
    int min = 0, max = people.length - 1;
    while (min <= max) {
      int weight = 0;
      while (!desc.isEmpty() && limit >= weight + desc.peek()) {
        weight += desc.poll();
        max--;
      }

      while (!asc.isEmpty() && limit >= weight + asc.peek()) {
        weight += asc.poll();
        min++;
      }

      answer++;
    }
    return answer;
  }

  public int solution2(int[] people, int limit) {
    Arrays.sort(people);

    int answer = 0;
    int begin = 0, end = people.length - 1;
    while (begin <= end) {
      int weight = people[end--];
      while(end >= begin && weight + people[end] <= limit) weight += people[end--];
      while (begin < end && weight + people[begin] <= limit) weight += people[begin++];

      answer++;
    }
    return answer;
  }

}
