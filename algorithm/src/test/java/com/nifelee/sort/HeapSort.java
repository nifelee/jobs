package com.nifelee.sort;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * 힙 정렬
 * <pre>
 * 1. n개의 노드에 대한 완전 이진 트리를 구성한다. 이때 루트 노드부터 부모노드, 왼쪽 자식노드, 오른쪽 자식노드 순으로 구성한다.
 * 2. 최대 힙을 구성한다. 최대 힙이란 부노드가 자식노드보다 큰 트리를 말하는데, 단말 노드를 자식노드로 가진 부모노드부터 구성하며 아래부터 루트까지 올라오며 순차적으로 만들어 갈 수 있다.
 * 3. 가장 큰 수(루트에 위치)를 가장 작은 수와 교환한다.
 * 4. 2와 3을 반복한다.
 * </pre>
 *
 * - Max Heapify
 * : root node가 child node보다 작으면 두 개의 child node 중 큰 node와 root node를 교체
 *
 * - 최악 시간 복잡도 : O(n)
 * - 최선 시간 복잡도 : O(n log n)
 * - 평균 시간 복잡도
 * - 공간 복잡도 : O(1)
 */
@Slf4j
public class HeapSort {

  //private static final int[] arr = {1, 2, 3, 4, 5, 6};
  //private static final int[] arr = {6, 5, 4, 3, 2, 1};
  private static final int[] arr = {5, 2, 4, 6, 1, 3};

  @Test
  public void asc() {
    log.debug("before:{}", arr);

    heapSort(arr);

    log.debug("after:{}", arr);
    Assertions.assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
  }

  private void heapSort(int[] arr) {
    int length = arr.length;

    //build max heap
    for (int i = length / 2; i >= 0; i--) {
      maxHeapify(arr, length, i);
    }

    //extract max element from heap
    for (int i = length - 1; i > 0; i--) {
      swap(arr, 0, i);
      maxHeapify(arr, i, 0);
    }
  }

  private void maxHeapify(int[] arr, int length, int i) {
    int left = i * 2;
    int right = i * 2 + 1;
    int largest;

    if (left < length && arr[i] < arr[left]) {
      largest = left;
    } else {
      largest = i;
    }

    if (right < length && arr[largest] < arr[right]) {
      largest = right;
    }

    if (largest != i) {
      swap(arr, largest, i);
      maxHeapify(arr, length, largest);
    }
  }

  private void swap(int[] arr, int source, int target) {
    int temp = arr[source];
    arr[source] = arr[target];
    arr[target] = temp;
  }

}
