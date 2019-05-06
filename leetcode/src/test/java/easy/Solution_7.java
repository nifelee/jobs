package easy;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

@Slf4j
public class Solution_7 {

  @Test
  public void test() {
    Assertions.assertThat(reverse(123)).isEqualTo(321);
    Assertions.assertThat(reverse(-123)).isEqualTo(-321);
    Assertions.assertThat(reverse(120)).isEqualTo(21);

    Assertions.assertThat(reverse(1534236469)).isEqualTo(0);
  }

  public int reverse(int x) {
    String s = String.valueOf(x);
    char[] chars = s.toCharArray();
    StringBuilder str = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == '-') {
        str.insert(0, '-');
      } else {
        str.append(chars[i]);
      }
    }

    try {
      return Integer.parseInt(str.toString());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

}
