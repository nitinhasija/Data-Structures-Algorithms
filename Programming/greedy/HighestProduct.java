/*
Given an array A, of N integers A.

Return the highest product possible by multiplying 3 numbers from the array.

NOTE: Solution will fit in a 32-bit signed integer.

Input Format:
The first and the only argument is an integer array A.

Output Format:
Return the highest possible product.

Constraints:
1 <= N <= 5e5

Example:
Input 1:
A = [1, 2, 3, 4]

Output 1: 24

Explanation 1: 2 * 3 * 4 = 24

Input 2:
A = [0, -1, 3, 100, 70, 50]

Output 2: 350000

Explanation 2:  70 * 50 * 100 = 350000
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);

        int fromLast = A.get(n - 1) * A.get(n - 2) * A.get(n - 3);
        int fromFirst = A.get(0) * A.get(1) * A.get(n - 1);

        return Math.max(fromFirst, fromLast);
    }
}