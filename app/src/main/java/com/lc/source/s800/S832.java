package com.lc.source.s800;

public class S832 {
    public static int[][] flipAndInvertImage(int[][] a) {
        int tmp;
        for(int i=0;i<a.length;i++) {
            int raw = a[i].length-1;
            int hraw = raw/2;
            for(int j=0;j<=hraw;j++) {
                if(j == raw - j) {
                    a[i][j] = a[i][j] ^ 1;
                } else {
                    tmp = a[i][j];
                    a[i][j] = a[i][raw - j] ^ 1;
                    a[i][raw - j] = tmp ^ 1;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] test = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] res = flipAndInvertImage(test);
        for(int i=0;i<res.length;i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(" " + res[i][j]);
            }
            System.out.println();
        }
    }
}
