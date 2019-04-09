package com.nifelee.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 구하기
 * 에라토네스의 체
 */
@Slf4j
public class PrimeNumber {

  @Test
  public void primeNumber() {
    int n = 100;

    List<Integer> primes = new ArrayList<>();
    boolean isPrime;
    for (int i=2; i<=n; i++) {
      isPrime = true;

      //for (int j=2; j<=Math.sqrt(i); j++) {
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime)
        primes.add(i);
    }

    log.debug("{}", primes.size());
    log.debug("{}", primes);
  }

  @Test
  public void notPrimeNumber() {
    int n = 10;
    boolean[] notPrimes = new boolean[n];
    List<Integer> list = new ArrayList<>();

    for (int i = 2; i < n; i++) {
      if (!notPrimes[i]) {
        for (int j = i * i; j < n; j += i) {
          notPrimes[j] = true;
          list.add(j);
        }
      }
    }

    log.debug("{}", list);
  }

}
