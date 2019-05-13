package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//쇠막대기
//https://programmers.co.kr/learn/courses/30/lessons/42585
@Slf4j
public class Solution_42585 {

  @Test
  public void test2() {
    Assertions.assertThat(solution2("()(((()())(())()))(())")).isEqualTo(17);
    Assertions.assertThat(solution2("((()(())))")).isEqualTo(8);
  }

  //arrangement	return
  //()(((()())(())()))(())	17
  public int solution2(String arrangement) {
    int answer = 0;
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < arrangement.length(); i++) {
      if (arrangement.charAt(i) == '(') {
        st.push(i);
      } else if (arrangement.charAt(i) == ')') {
        if (st.peek() + 1 == i) {
          st.pop();
          answer += st.size();
        } else {
          st.pop();
          answer += 1;
        }
      }
    }
    return answer;
  }

  @Test
  public void test() {
    Assertions.assertThat(solution("()(((()())(())()))(())")).isEqualTo(17);
  }

  //arrangement	return
  //()(((()())(())()))(())	17
  public int solution(String arrangement) {
    int answer = 0;
    List<Integer> list = new ArrayList<>();
    char prev = '\0';
    for (char arr : arrangement.toCharArray()) {
      if (prev == '(') {
        if (arr == '(') {
          list.add(1);
        } else if (arr == ')') {
          slice(list);
          log.debug("{}", list);
        }
      } else if (prev == ')' && arr == ')' && list.size() > 0) {
        answer += list.get(list.size() - 1);
        list.remove(list.size() - 1);
      }
      prev = arr;
    }
    return answer;
  }

  private void slice(List<Integer> list) {
    for (int i=0; i<list.size(); i++) {
      list.set(i, list.get(i) + 1);
    }
  }

}
