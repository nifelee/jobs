package com.nifelee.lessons;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/42583
@Slf4j
public class Solution_42583 {

  @Test
  public void test() {
    Assertions.assertThat(solution(2, 10, new int[]{7, 4, 5, 6})).isEqualTo(8);
  }

  //bridge_length	weight	truck_weights	return
  //2	10	[7,4,5,6]	8
  //100	100	[10]	101
  //100	100	[10,10,10,10,10,10,10,10,10,10]	110
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Truck> queue = new LinkedList<>();
    for (int w : truck_weights) {
      queue.offer(new Truck(w, bridge_length));
    }

    List<Truck> in = new ArrayList<>();
    int second = 0, remainWeight = weight;
    while (!(queue.isEmpty() && in.isEmpty())) {
      second++;

      if (!in.isEmpty() && in.get(0).distance == 0) {
        remainWeight += in.get(0).weight;
        in.remove(0);
      }

      if (!queue.isEmpty() && remainWeight - queue.peek().weight >= 0) {
        remainWeight -= queue.peek().weight;
        in.add(queue.poll());
      }

      for (Truck truck : in) {
        truck.distance--;
      }
    }

    return second;
  }

  @ToString(of = "weight")
  @AllArgsConstructor
  class Truck {
    final int weight;
    int distance;
  }

}
