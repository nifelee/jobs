package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

@Slf4j
//https://programmers.co.kr/learn/courses/30/lessons/49993
public class Solution_49993 {

  @Test
  public void test() {
    Assertions.assertThat(solution("CBD", new String[]{"BACDE", "CBADF", "AECB"})).isEqualTo(2);
  }

  //CBD [BACDE, CBADF, AECB, BDA] 2
  public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    for (String s : skill_trees) {
      if (isLearn(skill, s.toCharArray())) {
        log.debug("{}", s);
        ++answer;
      }
    }
    return answer;
  }

  private boolean isLearn(String skills, char[] skill) {
    int pivot = 0;

    for (char s : skill) {
      int index = skills.indexOf(s);
      if (index > -1) {
        if (index == pivot) {
          ++pivot;
        } else {
          return false;
        }
      }
    }

    return true;
  }

}
