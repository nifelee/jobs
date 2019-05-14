package com.nifelee.modern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.Normalizer;

@Slf4j
public class NormalizeTest {

  private static final String str = "ㅅㅏㅁㅅㅓㅇㅈㅓㄴㅈㅏ";

  @Test
  public void test() {
    for (Normalizer.Form form : Normalizer.Form.values()) {
      log.debug("{}: {}", form, Normalizer.normalize(str, form));
    }
  }

  @Test
  public void test2() {
    String han = Normalizer.normalize(str, Normalizer.Form.NFC);
    printIt(han);
  }

  private void printIt(String string) {
    System.out.println(string);
    for (int i = 0; i < string.length(); i++) {
      System.out.print(String.format("U+%04X ", string.codePointAt(i)));
    }
    System.out.println();
  }

}
