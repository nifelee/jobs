package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 합병 정렬
 * <pre>
 * 1. 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다. 그렇지 않은 경우에는
 * 2. 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
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

  private static final int[] arr = {5, 2, 4, 6, 1, 3};

  @Test
  public void asc() {
    log.debug("before:{}", arr);

    mergeSort(arr);

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

  private int[] mergeSort(int[] numbers) {
    int length = numbers.length;
    if (length == 1) return numbers;

    int center = length / 2;
    int[] leftNumbers = new int[center];
    int[] rightNumbers = new int[length - center];

    for (int i = 0; i < center; i++)
      leftNumbers[i] = numbers[i];

    for (int i = 0; i < length - center; i++)
      rightNumbers[i] = numbers[center + i];

    leftNumbers = mergeSort(leftNumbers);
    rightNumbers = mergeSort(rightNumbers);

    return merge(leftNumbers, rightNumbers, numbers);
  }

  private int[] merge(int[] leftNumbers, int[] rightNumbers, int[] numbers) {
    int left = 0, right = 0, merge = 0;
    while (leftNumbers.length != left && rightNumbers.length != right) {
      if (leftNumbers[left] < rightNumbers[right]) {
        numbers[merge] = leftNumbers[left];
        left++;
        merge++;
      } else {
        numbers[merge] = rightNumbers[right];
        right++;
        merge++;
      }
    }

    while (leftNumbers.length != left) {
      numbers[merge] = leftNumbers[left];
      left++;
      merge++;
    }

    while (rightNumbers.length != right) {
      numbers[merge] = rightNumbers[right];
      right++;
      merge++;
    }

    return numbers;
  }

}
