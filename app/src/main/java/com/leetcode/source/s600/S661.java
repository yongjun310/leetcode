package com.leetcode.source.s600;

public class S661 {
    public static int[][] imageSmoother(int[][] M) {
        int[][] b = new int[M.length][M[0].length];
        int av = 0;
        if(M.length == 1 && M[0].length == 1) {
            b[0][0] = M[0][0];
            return b;
        } else if(M.length == 1) {
            for(int i=0; i<M[0].length; i++) {
                if(i==0) {
                    b[0][i] = (M[0][i] + M[0][i+1])/2;
                } else if(i==M[0].length-1) {
                    b[0][i] = (M[0][i] + M[0][i-1])/2;
                } else {
                    b[0][i] = (M[0][i] + M[0][i-1] + M[0][i+1])/3;
                }
            }
            return b;
        } else if(M[0].length == 1) {
            for(int i=0; i<M.length; i++) {
                if(i==0) {
                    b[i][0] = (M[i][0] +M[i+1][0])/2;
                } else if(i==M.length-1) {
                    b[i][0] = (M[i][0] +M[i-1][0])/2;
                } else {
                    b[i][0] = (M[i][0] +M[i-1][0] + M[i+1][0])/3;
                }
            }
            return b;
        }
        for(int i=0;i<M.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                if(i==0 && j==0) {
                    av = (M[i][j] + M[i+1][j] + M[i+1][j+1] + M[i][j+1])/4;
                } else if(i==0 && j==b[i].length-1) {
                    av = (M[i][j] + M[i+1][j] + M[i+1][j-1] + M[i][j-1])/4;
                } else if(i==M.length-1 && j==0) {
                    av = (M[i][j] + M[i-1][j] + M[i-1][j+1] + M[i][j+1])/4;
                } else if(i==M.length-1 && j==b[i].length-1) {
                    av = (M[i][j] + M[i-1][j] + M[i-1][j-1] + M[i][j-1])/4;
                } else if(i==0) {
                    av = (M[i][j-1] + M[i][j] + M[i][j+1] + M[i+1][j-1] + M[i+1][j] + M[i+1][j+1])/6;
                } else if(i==M.length-1) {
                    av = (M[i][j-1] + M[i][j] + M[i][j+1] + M[i-1][j-1] + M[i-1][j] + M[i-1][j+1])/6;
                } else if(j==b[i].length-1) {
                    av = (M[i-1][j] + M[i][j] + M[i+1][j] + M[i-1][j-1] + M[i][j-1] + M[i+1][j-1])/6;
                } else if(j==0) {
                    av = (M[i-1][j] + M[i][j] + M[i+1][j] + M[i-1][j+1] + M[i][j+1] + M[i+1][j+1])/6;
                } else {
                    av = (M[i][j] + M[i - 1][j] + M[i - 1][j - 1] + M[i][j - 1] + M[i - 1][j + 1]
                            + M[i + 1][j] + M[i + 1][j + 1] + M[i + 1][j - 1] + M[i][j + 1]) / 9;
                }
                b[i][j] = av;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] test = {{3},{2}};
        int[][] b = imageSmoother(test);
        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                System.out.print(" " + b[i][j]);
            }
        }

    }
}
