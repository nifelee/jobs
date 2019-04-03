package com.nifelee.recursion;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

@Slf4j
public class RecursionExample {

  //주어진 문자열을 역순으로 출력
  @Test
  public void reverse() {
    String result = reverse("abc0123");
    Assertions.assertThat(result).isEqualTo("3210cba");
  }

  private String reverse(String str) {
    if ("".equals(str)) {
      return "";
    } else {
      String s = reverse(str.substring(1));
      return s + str.substring(0, 1);
    }
  }

  //주어진 문자열 길이
  @Test
  public void length() {
    int result = length("abc");
    Assertions.assertThat(result).isEqualTo(3);
  }

  private int length(String str) {
    if ("".equals(str))
      return 0;

    return 1 + length(str.substring(1));
  }

  //배열에서 최대값 찾기
  @Test
  public void max() {
    int[] data = {1, 6, 3, 4, 5, 8, 2, 7};
    int result = max(data, 0, data.length - 1);
    Assertions.assertThat(result).isEqualTo(8);
  }

  private int max(int[] data, int begin, int end) {
    if (begin == end) {
      return data[begin];
    } else {
      return Math.max(data[begin], max(data, begin + 1, end));
    }
  }

  //이진 검색 (정렬)
  @Test
  public void binarySearch() {
    //int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int result = binarySearch(data, 7, 0, data.length - 1);
    Assertions.assertThat(result).isEqualTo(6);
  }

  private int binarySearch(int[] data, int target, int begin, int end) {
    if (begin > end)
      return -1;

    int middle = (begin + end) / 2;
    int compare = target - data[middle];
    log.debug("begin:{}, end:{}, compare:{}", begin, end, compare);

    if (compare == 0) {
      return middle;
    } else if (compare < 0) {
      return binarySearch(data, target, begin, middle - 1);
    } else {
      return binarySearch(data, target, middle + 1, end);
    }
  }

  //배열에서 찾고자 하는 값의 인덱스 찾기
  @Test
  public void search() {
    //int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] data = {1, 6, 3, 4, 5, 8, 2, 7};
    int result = search(data, 0, data.length - 1, 3);
    Assertions.assertThat(result).isEqualTo(2);
  }

  private int search(int[] data, int begin, int end, int target) {
    if (begin > end)
      return -1;

    int middle = (begin + end) / 2;
    if (data[middle] == target)
      return middle;

    int index = search(data, begin, middle - 1, target);
    if (index != -1) {
      return index;
    } else {
      return search(data, middle + 1, end, target);
    }
  }

}
