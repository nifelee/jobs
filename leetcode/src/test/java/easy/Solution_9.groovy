package easy

import spock.lang.Specification
import spock.lang.Unroll

//https://leetcode.com/problems/palindrome-number/
class Solution_9 extends Specification {

  @Unroll
  def "Palindrome Number [nums: #nums, result: #result]" () {
    expect:
    isPalindrome(nums) == result

    where:
    nums | result
    121  | true
    1221 | true
    -121 | false
  }

  boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0))
      return false

    print("before x:" + x)

    int revertedNumber = 0
    while(x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10
      x /= 10
    }

    println(", after x:" + x + ", revertedNumber" + revertedNumber)

    return x == revertedNumber || x == (revertedNumber/10) as int
  }

}
