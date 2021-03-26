package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
146. LRU Cache
Medium

8082

331

Add to List

Share
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.
Accepted
730,064
Submissions
2,022,012
 */

class S146(capacity: Int) {
    var mCapacity = capacity
    var linkedHashMap = LinkedHashMap<Int, Int>(capacity)

    fun get(key: Int): Int {
        var v = linkedHashMap.get(key)
        if (v != null) {
            linkedHashMap.remove(key)
            linkedHashMap[key] = v
            return v
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        var v = linkedHashMap.get(key)
        if (v == null) {
            if (linkedHashMap.size == mCapacity) {
                var iterator = linkedHashMap.iterator()
                var cur = iterator.next().key
                linkedHashMap.remove(cur)
            }
        } else {
            linkedHashMap.remove(key)
        }
        linkedHashMap[key] = value
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}