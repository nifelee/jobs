package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/42840
@Slf4j
public class Solution_42840 {

  @Test
  public void test1() {
    int[] answers = {1, 2, 3, 4, 5};
    int[] rtn = {1};
    Assertions.assertThat(solution(answers)).isEqualTo(rtn);
  }

  @Test
  public void test2() {
    int[] answers = {1, 3, 2, 4, 2};
    int[] rtn = {1, 2, 3};
    Assertions.assertThat(solution(answers)).isEqualTo(rtn);
  }

  private int[] s1 = {1, 2, 3, 4, 5}; //5
  private int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
  private int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10

  public int[] solution(int[] answers) {
    int[] cnt = new int[3];
    for (int i=0; i<answers.length; i++) {
      if (answers[i] == s1[i % 5])  cnt[0]++;
      if (answers[i] == s2[i % 8])  cnt[1]++;
      if (answers[i] == s3[i % 10]) cnt[2]++;
    }

    int max = 0;
    for (int value : cnt) {
      if (value > max)
        max = value;
    }

    List<Integer> list = new ArrayList<>();
    for (int i=0; i<cnt.length; i++) {
      if (cnt[i] == max)
        list.add(i+1);
    }

    int[] answer = new int[list.size()];
    for (int i=0; i<list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

}
