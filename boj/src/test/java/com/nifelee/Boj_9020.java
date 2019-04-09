package com.nifelee;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 골드바흐 파티션 출력
 * 골드바흐의 추측 : 2보다 큰 모든 짝수는 두 개의 소수(Prime number)의 합으로 표시할 수 있다
 * e.g. 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7
 */
@Slf4j
public class Boj_9020 {

  @Test
  public void test() {
    int[] numbers = {8, 10, 16};
    int n = 10000;
    boolean[] primes = new boolean[n];

    for (int i = 2; i < n; i++) {
      if (!primes[i]) {
        for (int j = i * i; j < n; j += i)
          primes[j] = true;
      }
    }

    for (int number : numbers) {
      int n1 = number / 2;
      int n2 = number / 2;

      while (true) {
        if (!primes[n1] && !primes[n2])
          break;

        n1--;
        n2++;
      }

      log.debug("{} {}", n1, n2);
    }
  }

}
