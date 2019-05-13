package com.nifelee.lessons;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//실패율 (Kakao 2018)
//https://programmers.co.kr/learn/courses/30/lessons/42889
@Slf4j
public class Solution_42889 {

  @Test
  public void test1() {
    int N = 5;
    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    Assertions.assertThat(solution(N, stages)).isEqualTo(new int[]{3, 4, 2, 1, 5});
  }

  @Test
  public void test2() {
    int N = 4;
    int[] stages = {4, 4, 4, 4, 4};
    Assertions.assertThat(solution(N, stages)).isEqualTo(new int[]{4, 1, 2, 3});
  }

  @Test
  public void test3() {
    int N = 6;
    int[] stages = {1,4,4,2};
    Assertions.assertThat(solution(N, stages)).isEqualTo(new int[]{4, 2, 1, 3, 5, 6});
  }

  public int[] solution(int N, int[] stages) {
    int[] playingCount = new int[N + 2];
    for (int i : stages) {
      playingCount[i]++;
    }
    log.debug("{}", playingCount);

    int playerCount = 0;
    List<Stage> list = new ArrayList<>();
    for (int i = playingCount.length - 1; i > 0; i--) {
      playerCount += playingCount[i];

      if (i <= N)
        list.add(new Stage(i, playingCount[i], playerCount));
    }

    log.debug("{}", list);
    Collections.sort(list);
    log.debug("{}", list);

    int index = 0;
    int[] answer = new int[list.size()];
    for (Stage stage : list) {
      answer[index++] = stage.stage;
    }

    return answer;
  }

  @ToString
  @EqualsAndHashCode(of = "stage")
  private static class Stage implements Comparable<Stage> {
    final int stage;
    final double failRate;

    int playingCount;
    int playerCount;

    Stage(int stage, int playingCount, int playerCount) {
      this.stage = stage;
      this.failRate = playerCount == 0 ? 0.0 : playingCount / (double) playerCount;

      this.playingCount = playingCount;
      this.playerCount = playerCount;
    }

    @Override
    public int compareTo(Stage stage) {
      if (this.failRate == stage.failRate) {
        return this.stage - stage.stage;
      } else {
        if (this.failRate > stage.failRate) {
          return -1;
        } else if (this.failRate < stage.failRate) {
          return 1;
        }
        return 0;
      }
    }
  }

}
