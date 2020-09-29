import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.HashMap

/*
1232. Check If It Is a Straight Line
Easy

410

67

Add to List

Share
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false


Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
Accepted
83,198
Submissions
186,122
*/
class S1232{
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        var f = (coordinates[0][0] - coordinates[1][0]).toFloat() / (coordinates[0][1]-coordinates[1][1])
        var d = coordinates[0][1]==coordinates[1][1]
        for(i in 2..coordinates.size-1) {
            if(d) {
                if(coordinates[0][1]!=coordinates[i][1]) {
                    return false
                }
            } else if(Math.abs((coordinates[0][0] - coordinates[i][0]).toFloat()/(coordinates[0][1]-coordinates[i][1]) - f) > 0.000001) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1232().checkStraightLine(arrayOf(intArrayOf(4,8),intArrayOf(-2,8),intArrayOf(1,8),intArrayOf(8,8),intArrayOf(-5,8),intArrayOf(0,8),intArrayOf(7,8),intArrayOf(5,8))))
        }
    }
}
