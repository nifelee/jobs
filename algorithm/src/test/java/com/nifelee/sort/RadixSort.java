package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 기수 정렬
 * <pre>
 * 낮은 자리수부터 비교하여 정렬해 간다는 것을 기본 개념으로 하는 정렬 알고리즘
 * </pre>
 * <p>
 * - 비교 연산을 하지 않으며 정렬 속도가 빠르지만 데이터 전체 크기에 기수 테이블의 크기만한 메모리가 더 필요
 * <p>
 * - 시간 복잡도 : O( d(n + k) )
 * d :자릿 수
 * k : 진법
 */
@Slf4j
public class RadixSort {

  private final static int[] arr = {9, 1, 22, 4, 0, 1, 22, 100, 10};

  @Test
  public void radixSort() {
    log.debug("before:{}", arr);

    int max = arr[0];
    for (int x : arr) {
      max = Math.max(max, x);
    }

    int base = 10;
    int exp, i, j, length = arr.length;
    for (exp = 1; exp <= max; exp *= base) {
      int[] count = new int[base];
      int[] output = new int[length];

      for (i = 0; i < length; i++){
        count[(arr[i] / exp) % base]++;
      }

      for (i = 1; i < base; i++){
        count[i] += count[i - 1];
      }

      for (i = length - 1; i > -1; i--) {
        j = (arr[i] / exp) % base;
        output[count[j] - 1] = arr[i];
        count[j]--;
      }

      for (i = 0; i < length; i++) {
        arr[i] = output[i];
      }
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{0, 1, 1, 4, 9, 10, 22, 22, 100});
  }

}
