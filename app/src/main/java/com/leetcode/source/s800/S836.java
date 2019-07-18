package com.leetcode.source.s800;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class S836 {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int i1 = rec2[0];
        int i2 = rec2[1];
        int i3 = rec2[2];
        int i4 = rec2[3];

        if (x2 <= i1) return false;
        if (x1 >= i3) return false;
        if (y1 >= i4) return false;
        if (y2 <= i2) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] test = {11,12,13,13};
        int[] testb = {17,1,17,19};
        boolean res = isRectangleOverlap(test, testb);
        System.out.println(" " + res);
    }
}
