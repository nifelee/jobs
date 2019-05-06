package com.nifelee.codingdojang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//http://codingdojang.com/scode/365
@Slf4j
public class Scope365 {

  private Set<Integer> set = new HashSet<>();

  @Test
  public void test() {
    IntStream intStream = IntStream.rangeClosed(1, 5000);

    intStream
        .forEach(this::divideAndSum);

    int sum = intStream
        .filter(i -> !set.contains(i))
        .sum();

    //log.debug("set : {}", set);
    log.debug("sum : {}", sum);
  }

  private void divideAndSum(int N) {
    int sum = 0;
    String n = String.valueOf(N);
    for (int i=0; i<n.length(); i++) {
      sum += Integer.valueOf(n.substring(i, i+1));
    }

    set.add(sum);
  }

}
