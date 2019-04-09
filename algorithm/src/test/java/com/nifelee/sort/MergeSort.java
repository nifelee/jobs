package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 합병 정렬
 * <pre>
 * 1. 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다.
 * 2. 그렇지 않은 경우에는 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
 * 3. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
 * 4. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
 * </pre>
 *
 * - 최악 시간 복잡도 : O(n log n)
 * - 최선 시간 복잡도 : O(n log n)
 * - 평균 시간 복잡도 : O(n log n)
 * - 공간 복잡도 : O(n)
 */
@Slf4j
public class MergeSort {

  private static final int[] arr = new int[]{5, 2, 4, 6, 1, 3};

  @Test
  public void asc() {
    log.debug("before:{}", arr);

    mergeSort(arr, 0, arr.length - 1);

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

  private void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);

      merge(arr, left, mid, right);
    }
  }

  private void merge(int[] arr, int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    int k = left;
    int[] temp = new int[arr.length];

    while (i <= mid && j <= right) {
      if (arr[i] < arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    while (i <= mid)
      temp[k++] = arr[i++];

    while (j <= right)
      temp[k++] = arr[j++];

    for (int index = left; index < k; index++)
      arr[index] = temp[index];
  }

}
