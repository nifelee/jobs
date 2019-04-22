package com.nifelee.codingdojang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

//http://codingdojang.com/scode/410
/*
이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌

김씨와 이씨는 각각 몇 명 인가요?
"이재영"이란 이름이 몇 번 반복되나요?
중복을 제거한 이름을 출력하세요.
중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.
 */
@Slf4j
public class Scope410 {

  private String str = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";

  @Test
  public void test() {
    int countKim = 0;
    int countLee = 0;

    String[] str = this.str.split(",");
    for (int i=0; i<str.length; i++) {
      if (str[i].matches("김.*"))
        countKim++;
      if (str[i].matches("이.*"))
        countLee++;
    }

    log.debug("countKim : {}", countKim);
    log.debug("countLee : {}", countLee);
  }

}
