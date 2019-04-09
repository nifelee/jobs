package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 선택 정렬
 * <pre>
 * 1. 기준값(최소/최대값)을 찾음
 * 2. 기준값을 첫 원소와 비교하여 위치 변경
 * 3. 맨 처음 위치를 뺀 나머지를 같은 방법으로 반복
 * </pre>
 *
 * - 최악 시간 복잡도 : O(n^2) 비교, O(n) 교환
 * - 최선 시간 복잡도 : O(n^2) 비교, O(n) 교환
 * - 평균 시간 복잡도 : O(n^2) 비교, O(n) 교환
 * - 공간 복잡도 : O(n)
 */
@Slf4j
public class SelectionSort {

  private static final int[] arr = {5, 2, 4, 6, 1, 3};

  //오름차순 : 최소값을 찾음
  @Test
  public void asc() {
    log.debug("before:{}", arr);
    int minIndex, temp;

    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = i;

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) //최소값
          minIndex = j;
      }

      temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

  //내림차순 : 최대값을 찾음
  @Test
  public void desc() {
    log.debug("before:{}", arr);
    int temp;

    for (int i = 0; i < arr.length - 1; i++) {
      int maxIndex = i;

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > arr[maxIndex]) //최대값
          maxIndex = j;
      }

      temp = arr[maxIndex];
      arr[maxIndex] = arr[i];
      arr[i] = temp;
    }

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{6, 5, 4, 3, 2, 1});
  }

}
