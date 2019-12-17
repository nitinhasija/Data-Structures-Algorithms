/*
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

Return the answer modulo 109 + 7.

Input Format:
The first and the only argument contains the integer A.

Output Format:
Return an integer answering the query as described in the problem statement.
*/

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

// Perfect Example of Catalan Numbers

public class Solution {
    private long topDownDp(int A, long catalon[]) {
        if (A <= 1)
            return 1;

        if (catalon[A] == 0) {

            long sum = 0;
            int mod = 1000000007;

            for (int i = 0; i < A; i++) {
                sum += (topDownDp(i, catalon) * topDownDp(A - i - 1, catalon)) % mod;
                sum %= mod;
            }

            catalon[A] = sum;
        }

        return catalon[A];
    }

    private long bottomUp(int A) {
        long[] catalon = new long[A + 1];
        catalon[0] = catalon[1] = 1;

        int mod = 1000000007;

        for (int i = 2; i <= A; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += (catalon[j] * catalon[i - j - 1]) % mod;
            }
            catalon[i] = sum % mod;
        }
        return catalon[A];
    }

    public int chordCnt(int A) {
        return (int) bottomUp(A);
//        return (int) topDownDp(A, new long[A + 1]);
    }
}
