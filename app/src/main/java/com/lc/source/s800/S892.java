package com.lc.source.s800;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 *
 *
 *
 * Example 1:
 *
 * Input: [[2]]
 * Output: 10
 * Example 2:
 *
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 *
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 *
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 *
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *  17*6-8*2-8*4-4*2 = 102-48-8=46
 *
 * Note:
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class S892 {
    public static int surfaceArea(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if(grid[i][j]>0) {
                    sum += grid[i][j] * 6 - grid[i][j] * 2 + 2;
                }
                if(i!=0) {
                    sum -= 2*Math.min(grid[i-1][j], grid[i][j]);
                }
            }
        }
        for(int j=1;j<grid[0].length;j++) {
            for(int i=0;i<grid.length;i++) {
                sum -= 2*Math.min(grid[i][j], grid[i][j-1]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] test = {{2,2,2},{2,1,2},{2,2,2}};
        int res = surfaceArea(test);
        System.out.println(" " + res);
    }
}
