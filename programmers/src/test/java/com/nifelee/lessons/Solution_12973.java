package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Stack;

//짝지어 제거하기
//https://programmers.co.kr/learn/courses/30/lessons/12973
@Slf4j
public class Solution_12973 {

  @Test
  public void test() {
    Assertions.assertThat(solution("baabaa")).isEqualTo(1);
    Assertions.assertThat(solution("cdcd")).isEqualTo(0);
    Assertions.assertThat(solution("cddcda")).isEqualTo(0);
    Assertions.assertThat(solution("baa")).isEqualTo(0);
  }

  //s	result
  //baabaa	1
  //cdcd	0
  public int solution(String s)
  {
    if (s.length() % 2 != 0) return 0;

    Stack<Character> stack = new Stack<>();
    stack.push(s.charAt(0));

    for (int i=1; i<s.length(); i++) {
      if (stack.peek() == s.charAt(i)) {
        stack.pop();
      } else {
        stack.push(s.charAt(i));
      }

      if (stack.isEmpty() && i + 1 < s.length()) {
        stack.push(s.charAt(i + 1));
        i++;
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }

}
