package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Stack;

//기능개발
//https://programmers.co.kr/learn/courses/30/lessons/42586
@Slf4j
public class Solution_42586 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).isEqualTo(new int[]{2, 1});
    Assertions.assertThat(solution(new int[]{93, 30, 55, 60, 40, 65}, new int[]{1, 30, 5, 10, 60, 7})).isEqualTo(new int[]{2, 4});
  }

  //progresses	speeds	return
  //[93,30,55]	[1,30,5]	[2,1]
  public int[] solution(int[] progresses, int[] speeds) {
    Stack<Job> jobs = new Stack<>();
    for (int i=0; i<progresses.length; i++) {
      int days = 0;
      int pro = progresses[i];
      while (pro <= 100) {
        ++days;
        pro += speeds[i];
      }

      if (jobs.isEmpty()) {
        jobs.push(new Job(days, 1));
      } else if (jobs.peek().days >= days) {
        jobs.peek().cnt++;
      } else {
        jobs.push(new Job(days, 1));
      }
    }

    int[] answer = new int[jobs.size()];
    int index = jobs.size() - 1;
    while (!jobs.isEmpty()) {
      answer[index--] = jobs.pop().cnt;
    }
    return answer;
  }

  @ToString
  class Job {
    int days;
    int cnt;

    Job(int days, int cnt) {
      this.days = days;
      this.cnt = cnt;
    }
  }

}
