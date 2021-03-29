package com.lc.sword.offer

import java.util.*
import kotlin.collections.ArrayList

/*
We have a lot of IP segments, but some of the entries can be merged together because their ranges are overlapped:
1.1.1.1      - 1.1.1.255
3.1.1.1      - 4.2.3.4
1.1.2.0      - 1.1.2.200
1.1.2.100  - 1.1.2.255

The list above can be merged into:
1.1.1.1 - 1.1.2.255
3.1.1.1 - 4.2.3.4

Write a function to merge this list.
 */

class Microsoft_loop_1 {
    fun mergeDNS(ipsegs: Array<Array<Array<Int>>>): Array<Array<Array<Int>>> {
        var ret = ArrayList<Array<Array<Int>>>()
        ipsegs.sortWith(Comparator { o1: Array<Array<Int>>, o2: Array<Array<Int>> ->
            bigThan(o1[0], o2[0])
        })
        var startIpAddress = ipsegs[0][0]
        var endIpAddress = ipsegs[0][1]
        for (i in 1 until ipsegs.size) {
            //1.1.1.1      - 1.1.1.255
            if (bigThan(endIpAddress,ipsegs[i][0])>0 || nextWith(ipsegs[i][0], endIpAddress)) {
                if (bigThan(ipsegs[i][1], endIpAddress) > 0) {
                    endIpAddress = ipsegs[i][1]
                }
            } else {
                ret.add(arrayOf(startIpAddress,endIpAddress))
                startIpAddress = ipsegs[i][0]
                endIpAddress = ipsegs[i][1]
            }
        }
        ret.add(arrayOf(startIpAddress, endIpAddress))
        return ret.toArray() as Array<Array<Array<Int>>>
    }

    fun nextWith(sourceIp: Array<Int>, aimIp: Array<Int>): Boolean {
        var hasplus = false
        var checked = false
        for (i in 0..3) {
            if (sourceIp[i] != aimIp[i]) {
                if (!checked) {
                    if (sourceIp[i]>aimIp[i]) {
                        if (sourceIp[i] - aimIp[i] == 1) {
                            if (hasplus) {
                                return false
                            }
                            hasplus = true
                        } else {
                            return false
                        }
                    }
                    if (sourceIp[i] == 0 && aimIp[i] == 255 && hasplus) {
                        checked = true
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }

    //1.1.2.100 < 1.1.2.100?
    fun bigThan(sourceIp: Array<Int>, aimIp: Array<Int>): Int {
        for (i in 0..3) {
            if (sourceIp[i] < aimIp[i]) {
                return -1
            } else if(sourceIp[i] > aimIp[i]) {
                return 1
            }
        }
        return 0
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            /**
             * 1.1.1.1      - 1.1.1.255
            3.1.1.1      - 4.2.3.4
            1.1.2.0      - 1.1.2.200
            1.1.2.100  - 1.1.2.255
             */
            print(Microsoft_loop_1().mergeDNS(arrayOf(arrayOf(arrayOf(1,1,1,1), arrayOf(1,1,1,255)),
                    arrayOf(arrayOf(3,1,1,1), arrayOf(4,2,3,4)),
                    arrayOf(arrayOf(1,1,2,0), arrayOf(1,1,2,200)),
                    arrayOf(arrayOf(1,1,2,100), arrayOf(1,1,2,255)))))
        }
    }
}