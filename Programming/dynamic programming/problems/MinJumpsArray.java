/*
Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Return the minimum number of jumps required to reach the last index.
If it is not possible to reach the last index, return -1.

Input Format:
The first and the only argument contains an integer array, A.

Output Format:
Return an integer, representing the answer as described in the problem statement.

Constraints:
1 <= N <= 1e6
0 <= A[i] <= 50000

Examples:

Input 1: A = [2, 1, 1]

Output 1: 1

Explanation 1:
    The shortest way to reach index 2 is
        Index 0 -> Index 2
    that requires only 1 jump.

Input 2: A = [2,3,1,1,4]

Output 2: 2

Explanation 2:
    The shortest way to reach index 4 is
        Index 0 -> Index 1 -> Index 4
    that requires 2 jumps.
*/

public class Solution {
    //  Time Complexity - O(N^2)
    //  Space Complexity - O(N)
    public int jump(int[] A) {
        if (A[0] == 0 && A.length > 1)
            return -1;

        if (A.length == 0 || (A[0] == 0 && A.length == 1))
            return 0;

        int[] arr = new int[A.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (A[i] == 0)
                arr[i] = Integer.MAX_VALUE;

            else if (A[i] + i >= A.length - 1)
                arr[i] = 1;

            else {
                int minJumps = Integer.MAX_VALUE;
                for (int j = i + 1; j <= A[i] + i; j++)
                    minJumps = Math.min(minJumps, arr[j]);

                if (minJumps != Integer.MAX_VALUE)
                    arr[i] = minJumps + 1;
                else
                    arr[i] = minJumps;
            }
        }
        if (arr[0] == Integer.MAX_VALUE)
            return -1;

        else
            return arr[0];
    }
}
