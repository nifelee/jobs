package com.nifelee;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 주어진 문자열을 int 형으로 변환
 */
public class StringToInteger {

  private String str = "5838";
  private int result = 5838;

  @Test
  public void stringToInteger() {
    int result = 0;

    for (int i=0; i<str.length(); i++) {
      result *= 10;
      result += Integer.valueOf(str.substring(i, i+1));
    }

    Assertions.assertThat(result).isEqualTo(this.result);
  }

  @Test
  public void stringToInteger2() {
    char[] strArr = str.toCharArray();
    int result = 0;

    for (char c : strArr) {
      result *= 10;
      result += c - '0';
    }

    Assertions.assertThat(result).isEqualTo(this.result);
  }

}
