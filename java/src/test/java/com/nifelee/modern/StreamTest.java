package com.nifelee.modern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://www.slideshare.net/arawnkr/api-42494051
@Slf4j
public class StreamTest {

  private List<VO> list = new ArrayList<>();

  private void setList() {
    list.add(new VO(1L, "c"));
    list.add(new VO(2L, "b"));
    list.add(new VO(1L, "a"));
  }

  @Test
  public void listToMap() {
    setList();

    Map<Long, List<VO>> map = list.stream().collect(
        Collectors.groupingBy(VO::getId));

    log.debug("{}", map);
  }

  @Test
  public void test() {
    Map<Long, VO> map = list.stream().collect(
        Collectors.toMap(VO::getId, Function.identity()));

    log.debug("{}", map);
  }

  @Getter
  @ToString
  @EqualsAndHashCode(of = "id")
  @RequiredArgsConstructor
  private class VO {
    final private Long id;
    final private String name;
  }

  @Test
  public void sum() {
    int sum = IntStream.rangeClosed(1, 100)
        //.reduce(0, (left, right) -> left + right);
        .reduce(0, Integer::sum);
    log.debug("{}", sum);
  }

  @Test
  public void summaryStatistics() {
    setList();

    //list.stream().mapToLong(vo -> vo.id).max();
    //list.stream().mapToLong(vo -> vo.id).min();
    //list.stream().mapToLong(vo -> vo.id).average();

    LongSummaryStatistics summaryStatistics = list.stream()
        .mapToLong(vo -> vo.id)
        .summaryStatistics();

    log.debug("max : {}", summaryStatistics.getMax());
    log.debug("min : {}", summaryStatistics.getMin());
    log.debug("average : {}", summaryStatistics.getAverage());
  }

}
