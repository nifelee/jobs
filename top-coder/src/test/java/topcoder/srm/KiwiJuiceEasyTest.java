package topcoder.srm;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/* Examples
 * 0)
 *   {20, 20}
 *   {5, 8}
 *   {0}
 *   {1}
 * Returns: {0, 13 }
 *   He pours kiwi juice from bottle 0 to bottle 1. After pouring, bottle 0 will become empty and
 *   bottle 1 will contain 13 liters of kiwi juice.
 *
 * 1)
 *   {10, 10}
 *   {5, 8}
 *   {0}
 *   {1}
 * Returns: {3, 10 }
 *   He will stop pouring when bottle 1 becomes full.
 *
 * 2)
 *   {30, 20, 10}
 *   {10, 5, 5}
 *   {0, 1, 2}
 *   {1, 2, 0}
 * Returns: {10, 10, 0 }
 *
 * 3)
 *   {14, 35, 86, 58, 25, 62}
 *   {6, 34, 27, 38, 9, 60}
 *   {1, 2, 4, 5, 3, 3, 1, 0}
 *   {0, 1, 2, 4, 2, 5, 3, 1}
 * Returns: {0, 14, 65, 35, 25, 35 }
 *
 * 4)
 *   {700000, 800000, 900000, 1000000}
 *   {478478, 478478, 478478, 478478}
 *   {2, 3, 2, 0, 1}
 *   {0, 1, 1, 3, 2}
 * Returns: {0, 156956, 900000, 856956 }
 *
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or
 * reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2010, TopCoder, Inc. All rights reserved.
 *
 * This problem was used for:
 *        Member Single Round Match 478 Round 1 - Division II, Level One
 */
@Slf4j
public class KiwiJuiceEasyTest {

  private List<TestData> dataList = new ArrayList<>();

  @Before
  public void before() {
    this.dataList.add(TestData.builder()
        .capacities(new int[]{20, 20})
        .bottles(new int[]{5, 8})
        .fromId(new int[]{0})
        .toId(new int[]{1})
        .expected(new int[]{0, 13})
        .build());

    this.dataList.add(TestData.builder()
        .capacities(new int[]{10, 10})
        .bottles(new int[]{5, 8})
        .fromId(new int[]{0})
        .toId(new int[]{1})
        .expected(new int[]{3, 10})
        .build());

    this.dataList.add(TestData.builder()
        .capacities(new int[]{30, 20, 10})
        .bottles(new int[]{10, 5, 5})
        .fromId(new int[]{0, 1, 2})
        .toId(new int[]{1, 2, 0})
        .expected(new int[]{10, 10, 0})
        .build());

    this.dataList.add(TestData.builder()
        .capacities(new int[]{14, 35, 86, 58, 25, 62})
        .bottles(new int[]{6, 34, 27, 38, 9, 60})
        .fromId(new int[]{1, 2, 4, 5, 3, 3, 1, 0})
        .toId(new int[]{0, 1, 2, 4, 2, 5, 3, 1})
        .expected(new int[]{0, 14, 65, 35, 25, 35})
        .build());

    this.dataList.add(TestData.builder()
        .capacities(new int[]{700000, 800000, 900000, 1000000})
        .bottles(new int[]{478478, 478478, 478478, 478478})
        .fromId(new int[]{2, 3, 2, 0, 1})
        .toId(new int[]{0, 1, 1, 3, 2})
        .expected(new int[]{0, 156956, 900000, 856956})
        .build());
  }

  @Test
  public void test() {
    this.dataList.forEach(data -> {
      int[] result = new KiwiJuiceEasy().thePouring(data.capacities, data.bottles, data.fromId, data.toId);

      log.debug("data : {}, result : {}", data, result);
      Assertions.assertThat(result).isEqualTo(data.expected);
    });
  }

  @ToString
  @Builder
  public static class TestData {
    int[] capacities;
    int[] bottles;
    int[] fromId;
    int[] toId;
    int[] expected;
  }
}
