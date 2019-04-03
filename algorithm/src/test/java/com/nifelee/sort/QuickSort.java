package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 퀵 소트
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

  private int[] quickSort(int[] arr, int begin, int end) {
    int left = begin;
    int right = end;
    int pivot = arr[(begin + end) / 2]; // pivot = length / 2

    do {
      while (arr[left] < pivot) left++;
      while (arr[right] > pivot) right--;
      if (left <= right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
    } while (left <= right);

    if (begin < right) quickSort(arr, begin, right);
    if (end > left) quickSort(arr, left, end);

    return arr;
  }

}
