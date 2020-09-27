import com.lc.source.s1100.S1160

/*
1175. Prime Arrangements
Easy

125

226

Add to List

Share
Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: n = 5
Output: 12
Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
Example 2:

Input: n = 100
Output: 682289015


Constraints:

1 <= n <= 100
Accepted
12,655
Submissions
24,626
*/
class S1175{
    fun isPrime(n: Int) : Boolean {
        var prime = true
        if(n == 1) {
            return false
        }
        var top = Math.round(Math.sqrt(n.toDouble())).toInt()
        for(i in 2..top) {
            if(n % i == 0) {
                prime = false
            }
        }
        return prime
    }

    fun numPrimeArrangements(n: Int): Long {
        var pc = 0
        for(i in 1..n) {
            if(isPrime(i)) {
                pc++
            }
        }
        var ret = 1L
        for(i in 2..pc) {
            ret = (ret*i)%1000000007
        }
        for(i in 2..(n-pc)) {
            ret = (ret*i)%1000000007
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1175().numPrimeArrangements(100))
        }
    }
}
