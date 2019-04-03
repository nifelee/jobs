package com.nifelee.math;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 입력받은 두 수의 최대 공약수, 최소 공배수를 구한다.
 * 최대 공약수 : greatest common divisor
 * 최소 공배수 : least common multiple
 */
public class GcdAndLcm {

  @Test
  public void gcd() {
    Assertions.assertThat(getGcd(-1, 0)).isEqualTo(-1);
    Assertions.assertThat(getGcd(6, 8)).isEqualTo(2);
    Assertions.assertThat(getGcd(3, 3)).isEqualTo(3);
    Assertions.assertThat(getGcd(18, 12)).isEqualTo(6);
  }

  /**
   * 최대 공약수
   *
   * TODO : 유클리드 호제법
   * 시작복잡도 : O( log2(min(a, b)) )
   *
   * <pre>
   * f(a, b) = gcd(a, b)라 합시다.
   * 이 때 a mod b = 0 이라면, f(a, b) = b임이 자명함을 알 수 있습니다.
   * 이 때 a mod b이 0이 아닌 경우, f(a, b) = f(b, a mod b)가 성립
   * </pre>
   */
  private int getGcd(int val1, int val2) {
    if (val1 < 0 || val2 < 0)
      return -1;

    int mod;
    while (val2 != 0) {
      mod = val1 % val2;
      val1 = val2;
      val2 = mod;
    }

    return val1;
  }

  //유클리드 호제법 재귀 함수
  @Test
  public void gcd2() {
    Assertions.assertThat(getGcdByRecursion(-1, 0)).isEqualTo(-1);
    Assertions.assertThat(getGcdByRecursion(6, 8)).isEqualTo(2);
    Assertions.assertThat(getGcdByRecursion(3, 3)).isEqualTo(3);
    Assertions.assertThat(getGcdByRecursion(18, 12)).isEqualTo(6);
  }

  private int getGcdByRecursion(int val1, int val2) {
    if (val1 < 0 || val2 < 0)
      return -1;

    if (val1 % val2 == 0) {
      return val2;
    } else {
      return getGcdByRecursion(val2, val1 % val2);
    }
  }

  /**
   * 최소 공배수
   *
   * gcd(a,b) : a와b의 최대공약수
   * (최소공배수 * 최대공약수 = a * b)를 이용
   * a * b / gcd(a,b)
   */
  @Test
  public void lcm() {
    Assertions.assertThat(getLcm(6, 8)).isEqualTo(24);
  }

  private int getLcm(int val1, int val2) {
    if (val1 < 0 || val2 < 0)
      return -1;

    return val1 * val2 / (getGcd(val1, val2));
  }

}
