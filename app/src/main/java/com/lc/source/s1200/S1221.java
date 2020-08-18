package com.lc.source.s1200;

/**
 * 1221. Split a String in Balanced Strings Easy
 *
 * 69
 *
 * 39
 *
 * Favorite
 *
 * Share Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL" Output: 4 Explanation: s can be split into "RL", "RRLL", "RL", "RL",
 * each substring contains same number of 'L' and 'R'. Example 2:
 *
 * Input: s = "RLLLLRRRLR" Output: 3 Explanation: s can be split into "RL", "LLLRRR", "LR",
 * each substring contains same number of 'L' and 'R'. Example 3:
 *
 * Input: s = "LLLLRRRR" Output: 1 Explanation: s can be split into "LLLLRRRR".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000 s[i] = 'L' or 'R'
 */
public final class S1221 {
  private S1221() {
  }

  private static int balancedStringSplit(String s) {
    int count = 0;
    int ret = 0;
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.charAt(0) == 'L') {
      count++;
    } else {
      count--;
    }
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == 'L') {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        ret++;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    String test = "RLRRLLRLRL";
    System.out.print(balancedStringSplit(test));
  }
}
