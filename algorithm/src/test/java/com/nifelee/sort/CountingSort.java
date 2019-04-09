package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

/**
 * 계수 정렬
 * <pre>
 * 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하면서 선형 시간에 정렬하는 효율적인 알고리즘
 * 1. 들어간 숫자 세기
 * 2. 배열 동일하게 하나 추가
 * 3. 배열 수 누적
 * 4. 기존 배열의 끝에서부터 누적합 위치 참조해서 넣어주고 누적합 - 1
 * </pre>
 *
 * - k(입력되는 정수의 범위)가 클 경우 비 효율적
 *
 * - 시간 복잡도 : O(k + n) 또는 k = O(n) 이면 O(n)
 */
@Slf4j
public class CountingSort {

  private static final int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};

  //Original
  @Test
  public void countingSort() {
    log.debug("before:{}", arr);

    int min = arr[0], max = arr[0];
    //min, max
    for (int x : arr) {
      min = Math.min(min, x);
      max = Math.max(max, x);
    }

    int[] counter = new int[max - min + 1];
    for (int x : arr)
      counter[x - min]++;
    log.debug("count:{}", counter);

    int index = 0;
    for (int i = 0; i < counter.length; i++) {
      Arrays.fill(arr, index, index + counter[i], i + min);
      index += counter[i];
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{0, 0, 2, 2, 3, 3, 3, 5});
  }

  //Original 누적 방법
  @Test
  public void countingSortByPrime() {
    log.debug("before:{}", arr);

    int max = arr[0];
    for (int x : arr) {
      max = Math.max(max, x);
    }

    int[] result = new int[arr.length];
    int[] counter = new int[max + 1];

    //각 원소 갯수
    for (int x : arr) {
      counter[x] += 1;
    }
    log.debug("counter:{}", counter);

    //누적 합
    for (int i = 1; i < counter.length; i++) {
      counter[i] += counter[i - 1];
    }
    log.debug("sum of counter:{}", counter);

    //누적합을 이용한 정렬
    for (int i = arr.length - 1; i >= 0; i--) {
      result[--counter[arr[i]]] = arr[i];
    }

    log.debug("after:{}", result);
    Assertions.assertThat(result).isEqualTo(new int[]{0, 0, 2, 2, 3, 3, 3, 5});
  }

  @Test
  public void originalSimple() {
    log.debug("before:{}", arr);

    int max = arr[0];
    //min, max
    for (int x : arr) {
      max = Math.max(max, x);
    }

    int[] counter = new int[max + 1];
    for (int x : arr) {
      counter[x]++;
    }

    for (int index=0, i=0; i<=max; i++) {
      for (int j=0; j<counter[i]; j++) {
        arr[index++] = i;
      }
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{0, 0, 2, 2, 3, 3, 3, 5});
  }

}
