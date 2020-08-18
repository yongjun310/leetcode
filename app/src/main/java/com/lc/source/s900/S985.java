package com.lc.source.s900;

public class S985 {
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] ret = new int[queries.length];
        A[queries[0][1]] += queries[0][0];
        for(int i=0; i<A.length; i++) {
            if(A[i]%2 == 0) {
                sum += A[i];
            }
        }
        ret[0] = sum;
        for(int i=1; i<queries.length; i++) {
            int tmp = A[queries[i][1]] + queries[i][0];
            if(tmp%2 == 0) {
                if(A[queries[i][1]] % 2 == 0) {
                    ret[i] = sum+queries[i][0];
                } else {
                    ret[i] = sum+tmp;
                }
            } else {
                if(A[queries[i][1]] % 2 == 0) {
                    ret[i] = sum - A[queries[i][1]];
                } else {
                    ret[i] = sum;
                }
            }
            sum = ret[i];
            A[queries[i][1]] += queries[i][0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        int[][] q = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] res = sumEvenAfterQueries(test,q);
        for(int i=0; i<res.length;i++) {
            System.out.print(" " + res[i]);
        }
    }
}
