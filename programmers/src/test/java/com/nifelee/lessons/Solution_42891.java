package com.nifelee.lessons;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//무지의 먹방 라이브 (2018)
//https://programmers.co.kr/learn/courses/30/lessons/42891
@Slf4j
public class Solution_42891 {

  @Test
  public void test1() {
    int[] food_times = {3, 1, 2};
    long k = 5L;
    Assertions.assertThat(solution(food_times, k)).isEqualTo(1);
  }

  @Test
  public void test2() {
    int[] food_times = {3, 1, 2};
    long k = 1L;
    Assertions.assertThat(solution(food_times, k)).isEqualTo(2);
  }

  @Test
  public void test3() {
    int[] food_times = {3, 1, 2};
    long k = 10L;
    Assertions.assertThat(solution(food_times, k)).isEqualTo(-1);
  }

  public int solution(int[] food_times, long k) {
    int len = food_times.length;

    List<Food> foods = new LinkedList<>();
    for (int i=0; i<len; i++) {
      foods.add(new Food(i + 1, food_times[i]));
    }

    foods.sort(compTime);

    int preTime = 0;
    int index = 0;
    for (Food food : foods) {
      long diff = food.time - preTime;

      if (diff != 0) {
        long spend = diff * len;
        if (spend <= k) {
          k -= spend;
          preTime = food.time;
        } else {
          k %= len;
          foods.subList(index, food_times.length).sort(compIndex);
          return foods.get(index + (int) k).index;
        }
      }

      index++;
      len--;
    }

    return -1;
  }

  @ToString
  @RequiredArgsConstructor
  private static class Food {
    final int index;
    final int time;
  }

  private Comparator<Food> compTime = Comparator.comparingInt(o -> o.time);

  private Comparator<Food> compIndex = Comparator.comparingInt(o -> o.index);

}
