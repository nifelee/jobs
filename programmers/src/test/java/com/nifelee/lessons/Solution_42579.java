package com.nifelee.lessons;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//베스트앨범
//https://programmers.co.kr/learn/courses/30/lessons/42579
@Slf4j
public class Solution_42579 {

  @Test
  public void test() {
    Assertions.assertThat(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})).isEqualTo(new int[]{4, 1, 3, 0});
    Assertions.assertThat(solution(new String[]{"classic", "classic", "classic"}, new int[]{500, 150, 800})).isEqualTo(new int[]{2, 0});
    Assertions.assertThat(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 2500, 800, 800, 2500})).isEqualTo(new int[]{1, 4, 2, 3});
    Assertions.assertThat(solution(new String[]{"classic", "pop", "classic", "classic", "jazz"}, new int[]{500, 600, 150, 800, 2500})).isEqualTo(new int[]{4, 3, 0});
  }

  //genres	plays	return
  //[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
  public int[] solution(String[] genres, int[] plays) {
    Map<String, PlayList> map = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      if (map.containsKey(genres[i])) {
        PlayList playList = map.get(genres[i]);
        playList.total += plays[i];
        playList.songs.add(new Song(i, plays[i]));
      } else {
        PlayList playList = new PlayList(genres[i], plays[i]);
        playList.songs.add(new Song(i, plays[i]));
        map.put(genres[i], playList);
      }
    }

    Set<PlayList> playLists = new TreeSet<>(map.values());

    List<Integer> list = new ArrayList<>();
    int i = 0;
    for (PlayList playList : playLists) {
      if (i > 1) break;
      Collections.sort(playList.songs);

      for (int j = 0; j < playList.songs.size() && j < 2; j++) {
        list.add(playList.songs.get(j).index);
      }
      i++;
    }

    int[] answer = new int[list.size()];
    for (i = 0; i < list.size(); i++)
      answer[i] = list.get(i);
    return answer;
  }

  @ToString
  class PlayList implements Comparable<PlayList> {
    String genre;
    int total;
    List<Song> songs = new ArrayList<>();

    PlayList(String genre, int total) {
      this.genre = genre;
      this.total = total;
    }

    @Override
    public int compareTo(PlayList playList) {
      return playList.total - this.total;
    }
  }

  @ToString
  class Song implements Comparable<Song> {
    int index;
    int play;

    Song(int index, int play) {
      this.index = index;
      this.play = play;
    }

    @Override
    public int compareTo(Song song) {
      if (this.play == song.play) {
        return this.index - song.index;
      } else {
        return song.play - this.play;
      }
    }
  }

}
