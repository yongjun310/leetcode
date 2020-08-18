package com.lc.source.s1;

public class S88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=nums1.length-1; i>=0; i--) {
            if(m == 0) {
                nums1[i] = nums2[n-1];
                n--;
                continue;
            }
            if(n == 0) {
                break;
            }
            int a = nums1[m-1];
            int b = nums2[n-1];
            if(a > b) {
                nums1[i] = a;
                m--;
            } else {
                nums1[i] = b;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 0};
        int[] b = {1};

        merge(a, 1, b, 1);

        for(int i=0; i<a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }
}
