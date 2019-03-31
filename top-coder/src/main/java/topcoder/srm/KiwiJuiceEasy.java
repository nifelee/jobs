package topcoder.srm;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=11020
 *
 * Problem Statement for KiwiJuiceEasy
 *
 * Problem Statement
 *   Taro has prepared delicious kiwi fruit juice. He poured it into N bottles numbered from 0 to N-1.
 *   The capacity of the i-th bottle is capacities[i] liters, and he poured bottles[i] liters of kiwi juice into this bottle.
 *
 *   Now he wants to redistribute juice in the bottles. In order to do this, he will perform M operations numbered
 *   from 0 to M-1 in the order in which he will perform them. For the i-th operation, he will pour kiwi juice
 *   from bottle fromId[i] to bottle toId[i]. He will stop pouring when bottle fromId[i] becomes empty or
 *   bottle toId[i] becomes full, whichever happens earlier.
 *
 *   Return an int[] that contains exactly N elements and whose i-th element is the amount of kiwi juice
 *   in the i-th bottle after all pouring operations are finished.
 *
 * Definition
 *   Class:	KiwiJuiceEasy
 *   Method:	thePouring
 *   Parameters:	int[], int[], int[], int[]
 *   Returns:	int[]
 *   Method signature:	int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId)
 *   (be sure your method is public)
 *
 * Constraints
 * -	capacities will contain between 2 and 50 elements, inclusive.
 * -	Each element of capacities will be between 1 and 1,000,000, inclusive.
 * -	capacities and bottles will contain the same number of elements.
 * -	For each i, bottles[i] will be between 0 and capacities[i], inclusive.
 * -	fromId will contain between 1 and 50 elements, inclusive.
 * -	fromId and toId will contain the same number of elements.
 * -	Each element of fromId and toId will be between 0 and N-1, inclusive, where N is the number of elements in capacities.
 * -	For each i, fromId[i] and toId[i] will be distinct.
 */
public class KiwiJuiceEasy {

  public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
    for (int i=0; i<fromId.length; i++) {
      int f = fromId[i];
      int t = toId[i];

      int capacity = bottles[f] + bottles[t];

      if (capacities[t] > capacity) {
        bottles[f] = 0;
        bottles[t] = capacity;
      } else {
        bottles[t] = capacities[t];
        bottles[f] = capacity - capacities[t];
      }
    }

    return bottles;
  }

}
