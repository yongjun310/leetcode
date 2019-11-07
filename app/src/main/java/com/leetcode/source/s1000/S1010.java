package com.leetcode.source.s1000;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.


Note:

1 <= time.length <= 60000
1 <= time[i] <= 500*/
public final class S1010 {
  private S1010() {
  }

  private static int numPairsDivisibleBy60(int[] time) {
    int ret = 0;
    @SuppressLint("UseSparseArrays") Map<Integer, Integer> map = new HashMap<>();
    for (int aTime : time) {
      int a = aTime % 60;
      Integer v = map.get(a);
      map.put(a, v != null ? v + 1 : 1);
    }
    Set<Integer> keysets = map.keySet();
    Iterator<Integer> it = keysets.iterator();
    while (it.hasNext()) {
      Integer k = it.next();
      if (k == null) {
        continue;
      }
      Integer vI = map.get(k);
      if (vI == null) {
        continue;
      }
      int v = vI;
      if (k == 30 || k == 0) {
        ret += v * (v - 1) / 2;
        continue;
      }
      Integer pv = map.get(60 - k);
      if (pv == null) {
        continue;
      }
      if (pv > 0) {
        ret += v * pv;
      }
      it.remove();
    }
    return ret;
  }

  public static void main(String[] args) {
    int[] a = {60, 60, 60};

    int b = numPairsDivisibleBy60(a);

    System.out.print(" " + b);
  }
}
