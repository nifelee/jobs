package com.nifelee.lessons;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Solution_42888 {

  @Test
  public void test() {
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    String[] answer = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
    Assertions.assertThat(solution(record)).isEqualTo(answer);
  }

  private String[] solution(String[] record) {
    Map<String, String> users = new HashMap<>();
    List<Action> result = new ArrayList<>();

    String[] temp;
    for (String r : record) {
      temp = r.split(" ");

      switch (temp[0]) {
        case "Enter" :
          users.put(temp[1], temp[2]);
          result.add(new Action(temp[1], "님이 들어왔습니다."));
          break;
        case "Change" :
          users.replace(temp[1], temp[2]);
          break;
        default:
          result.add(new Action(temp[1], "님이 나갔습니다."));
          break;
      }
    }

    String[] answer = new String[result.size()];

    for (int i=0; i<result.size(); i++) {
      Action action = result.get(i);
      answer[i] = users.get(action.userId) + action.action;
    }

    return answer;
  }

  private static class Action {
    final String userId;
    final String action;

    Action(String userId, String action) {
      this.userId = userId;
      this.action = action;
    }
  }

}
