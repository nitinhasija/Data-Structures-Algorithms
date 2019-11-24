/*
Given an array of non-negative integers, A, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.


Input Format:
The first and the only argument of input will be an integer array A.

Output Format:
Return an integer, representing the answer as described in the problem statement.
    => 0 : If you cannot reach the last index.
    => 1 : If you can reach the last index.
*/

// Time Complexity - O(N)
// Space Complexity - O(1)

import java.util.ArrayList;

public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {
        int maxIndex = 0 + A.get(0);
        if(A.get(0) == 0 && A.size() > 1)
            return 0;

        for(int i = 1; i < A.size(); i++){
            int temp = i + A.get(i);
            if(maxIndex < temp)
                maxIndex = temp;

            if(maxIndex >= A.size()-1)
                return 1;

            else if(maxIndex == i)
                return 0;
        }
        return 1;
    }
}

