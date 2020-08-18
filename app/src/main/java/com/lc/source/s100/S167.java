package com.lc.source.s100;

public class S167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int begin = 0, end = numbers.length-1;
        while(true) {
            int sum = numbers[begin] + numbers[end];
            if(sum > target) {
                end--;
            } else if(sum < target) {
                begin++;
            } else {
                indices[0] = begin+1;
                indices[1] = end+1;
                return indices;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        int[] b = twoSum(test, 9);
        for(int i=0; i<b.length; i++) {
            System.out.print(" " + b[i]);
        }
    }
}
