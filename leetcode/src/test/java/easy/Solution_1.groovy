package easy

import spock.lang.Specification
import spock.lang.Unroll

class Solution_1 extends Specification {

  @Unroll
  def "Brute Force[nums: #nums, target: #target, result: #result]"() {
    expect:
    "Brute Force"(nums, target) == result

    where:
    nums                    | target | result
    [2, 7, 11, 15] as int[] | 9      | [0, 1] as int[]
    [2, 7, 11, 15] as int[] | 18     | [1, 2] as int[]
  }

  int[] "Brute Force"(int[] nums, int target) {
    int[] result = new int[2]
    int size = nums.length

    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i
          result[1] = j
          return result
        }
      }
    }
    return result
  }

  @Unroll
  def "Two-pass Has Table [nums: #nums, target: #target, result: #result"() {
    expect:
    "Two-pass Hash Table"(nums, target) == result

    where:
    nums                    | target | result
    [2, 7, 11, 15] as int[] | 9      | [0, 1] as int[]
    [2, 7, 11, 15] as int[] | 18     | [1, 2] as int[]
  }

  int[] "Two-pass Hash Table"(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>()
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i)
    }
    println map

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i]
      if (map.containsKey(complement) && map.get(complement) != i) {
        return [i, map.get(complement)] as int[]
      }
    }

    throw new IllegalArgumentException("No two sum solution")
  }

  @Unroll
  def "One-pass Has Table [nums: #nums, target: #target, result: #result"() {
    expect:
    "One-pass Hash Table"(nums, target) == result

    where:
    nums                    | target | result
    [2, 7, 11, 15] as int[] | 9      | [0, 1] as int[]
    [2, 7, 11, 15] as int[] | 18     | [1, 2] as int[]
  }

  int[] "One-pass Hash Table"(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>()

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i]
      if (map.containsKey(complement)) {
        return [map.get(complement), i] as int[]
      }

      map.put(nums[i], i)
    }

    throw new IllegalArgumentException("No two sum solution")
  }

}
