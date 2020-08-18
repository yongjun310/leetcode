package com.lc.source.s1000;

import java.util.Arrays;

/*Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students not standing in the right positions.
(This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)



Example 1:

Input: [1,1,4,2,1,3]
Output: 3
Explanation:
Students with heights 4, 3 and the last 1 are not standing in the right positions.


Note:

1 <= heights.length <= 100
1 <= heights[i] <= 100*/
public class S1051 {
    public static int heightChecker(int[] heights) {
        int ret = 0;
        int[] clone = Arrays.copyOf(heights, heights.length);
        Arrays.sort(clone);
        for(int i=0;i<heights.length; i++) {
            if(clone[i] != heights[i]) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {1,1,4,2,1,3};

        int b = heightChecker(a);

        System.out.print(" " + b);
    }
}
