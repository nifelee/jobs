package com.nifelee;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 주어진 문자열을 역순으로 출력
 */
public class StringToReversePrint {

  private String str = "abc0123";
  private String result = "3210cba";

  @Test
  public void stringToReversePrint() {
    char[] chars = str.toCharArray();
    char[] newChars = new char[chars.length];

    for (int i=0; i<chars.length; i++) {
      newChars[chars.length - i - 1] = chars[i];
    }

    String result = new String(newChars);
    Assertions.assertThat(result).isEqualTo(this.result);
  }

  @Test
  public void stringToReversePrint2() {
    String result = new StringBuffer(str).reverse().toString();
    Assertions.assertThat(result).isEqualTo(this.result);
  }

  @Test
  public void stringToReversePrint3() {
    char[] chars = str.toCharArray();
    char temp;

    for (int i=0; i<chars.length / 2; i++) {
      temp = chars[i];
      chars[i] = chars[chars.length - i - 1];
      chars[chars.length - i - 1] = temp;
    }

    String result = new String(chars);
    Assertions.assertThat(result).isEqualTo(this.result);
  }

}
