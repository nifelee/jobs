package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 퀵 소트
 * <pre></pre>
 * 1. 리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
 * 2. 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다. 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
 * 3. 분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.
 *
 * - 최악 시간 복잡도 : O(n ^ 2)
 * - 최선 시간 복잡도 : O(n log n)
 * - 평균 시간 복잡도 : O(n log n)
 * - 공간 복잡도 : O(1)
 */
@Slf4j
public class QuickSort {

  private static final int[] arr = {5, 2, 4, 6, 1, 3};

  @Test
  public void asc() {
    log.debug("before:{}", arr);

    quickSort(arr, 0, arr.length - 1);

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

  private void quickSort(int[] arr, int left, int right) {
    int i = left;
    int j = right;
    int pivot = arr[(left + right) / 2]; // pivot = length / 2

    do {
      while (arr[i] < pivot) i++;
      while (arr[j] > pivot) j--;

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    } while (i <= j);

    if (left < j) quickSort(arr, left, j);
    if (right > i) quickSort(arr, i, right);
  }

}
