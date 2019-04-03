package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 삽입 정렬
 * <pre>
 * 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
 * 자신의 위치를 찾아 삽입함으로써 정렬
 * </pre>
 *
 * - 최악 시간 복잡도 : O(n^2), 입력 자료 역순
 * - 최선 시간 복잡도 : O(n), 이미 정렬
 * - 평균 시간 복잡도 : O(n^2)
 * - 시간 복잡도 : O(n)
 */
@Slf4j
public class InsertionSort {

  private static final int[] arr = {5, 2, 4, 6, 1, 3};

  @Test
  public void asc() {
    log.debug("before:{}", arr);

    int key, j;
    for (int i = 1; i < arr.length; i++) {
      key = arr[i];

      for (j = i - 1; j >= 0 && key < arr[j]; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = key;
      log.debug("{} - {}", i, arr);
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

}
