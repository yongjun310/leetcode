package com.lc.sword.offer

import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList

/*
剑指 Offer 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3


限制：

2 <= n <= 100000

通过次数211,032提交次数312,381
 */

class S3 {
    fun findRepeatNumber(nums: IntArray): Int {
        var cur = 0
        while (true) {
            if (nums[cur] == cur) {
                cur++
                if (cur>=nums.size) {
                    cur = 0
                }
                continue
            }
            if (nums[cur] != nums[nums[cur]]) {
                var temp = nums[cur]
                nums[cur] = nums[temp]
                nums[temp] = temp
            } else {
                return nums[cur]
            }
        }
        return 0
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(S3().findRepeatNumber(intArrayOf(2, 3, 1, 0, 2, 5, 3)))
            println(S3().findRepeatNumber(intArrayOf(0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)))
            print(S3().findRepeatNumber(intArrayOf(3, 1, 2, 3)))
        }
    }
}