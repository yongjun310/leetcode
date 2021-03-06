package com.lc.source.s1000;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 *
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 * Example 3:
 *
 * GLGLGLGL
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 *
 * Note:
 *
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 */
public class S1041 {
    public static boolean isRobotBounded(String instructions) {
        int[] cur = {0,0};
        int dir = 0;
        int[][] steps = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i = 0; i < instructions.length(); ++i) {
            char ch = instructions.charAt(i);
            if(ch == 'G') {
                cur = new int[]{cur[0] + steps[dir][0], cur[1] + steps[dir][1]};
            }
            else if(ch == 'R') {
                dir = (dir+1)%4;
            }
            else { // L
                dir = (dir-1+4)%4;
            }
        }
        return (cur[0] == 0 && cur[1] == 0) || dir != 0;
    }

    public static void main(String[] args) {
        boolean b = isRobotBounded("GL");
        System.out.print(" " + b);
    }
}
