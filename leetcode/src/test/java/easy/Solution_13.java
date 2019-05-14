package easy;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
@Slf4j
public class Solution_13 {

  @Test
  public void test() {
    List<Integer> list = new ArrayList<>();
    for (Integer i : list) {

    }
    Assertions.assertThat(romanToInt("III")).isEqualTo(3);
    Assertions.assertThat(romanToInt("IV")).isEqualTo(4);
    Assertions.assertThat(romanToInt("IX")).isEqualTo(9);
    Assertions.assertThat(romanToInt("LVIII")).isEqualTo(58);
    Assertions.assertThat(romanToInt("MCMXCIV")).isEqualTo(1994);
  }

  /*
   * Symbol       Value
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   */
  //MCMXCIV : 1994 (M = 1000, CM = 900, XC = 90 and IV = 4)
  public int romanToInt(String s) {
    Map<String, Integer> symbol = new HashMap<>();
    symbol.put("I", 1);
    symbol.put("V", 5);
    symbol.put("X", 10);
    symbol.put("L", 50);
    symbol.put("C", 100);
    symbol.put("D", 500);
    symbol.put("M", 1000);

    int num = 0, index = 0;
    while (index < s.length()) {
      int val = symbol.get(s.substring(index, index + 1));
      if (index < s.length() - 1) {
        int next = symbol.get(s.substring(index + 1, index + 2));

        if (next > val) {
          num += next - val;
          index += 2;
        } else {
          num += val;
          index++;
        }
      } else {
        num += val;
        index++;
      }
    }

    return num;
  }

  @Test
  public void asdf() {
    long l = solution(123L);
    log.debug("{}", l);
  }

  private long solution(long n) {
    int[] l = new int[10];

    while (n > 0) {
      l[(int) (n % 10)]++;
      n /= 10;
    }

    long answer = 0L;
    int x = 1;
    for (int i=9; i>=0; i--) {
      if (l[i] != 0) {
        for (int j=0; j<l[i]; j++) {
          answer = answer * x + i;
          x = 10;
        }
      }
    }

    return answer;
  }

}
