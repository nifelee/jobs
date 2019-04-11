package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

@Slf4j
//TODO : 실패하는 테스트 케이스 찾아서 수정할 것
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
    Set<Stage> set = new TreeSet<>();
    for (int i = playingCount.length - 1; i > 0; i--) {
      playerCount += playingCount[i];

      if (i <= N)
        set.add(new Stage(i, playingCount[i], playerCount));
    }
    log.debug("{}", set);

    int index = 0;
    int[] answer = new int[set.size()];
    for (Stage stage : set) {
      answer[index++] = stage.stage;
    }

    return answer;
  }

  @ToString
  private static class Stage implements Comparable<Stage> {
    final int stage;
    final int failRate;

    int playingCount;
    int playerCount;

    Stage(int stage, int playingCount, int playerCount) {
      this.stage = stage;
      this.failRate = (int) (playingCount / (double) playerCount * 1000);

      this.playingCount = playingCount;
      this.playerCount = playerCount;
    }

    @Override
    public int compareTo(Stage stage) {
      if (this.failRate == stage.failRate) {
        return this.stage - stage.stage;
      } else {
        return stage.failRate - this.failRate;
      }
    }
  }

}
