/*
N light bulbs are connected by a wire.

Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.

Input Format:
The first and the only argument contains an integer array A, of size N.

Output Format:
Return an integer representing the minimum number of switches required.
*/

// Time Complexity - O(N)
// Space Complexity - O(1)

import java.util.ArrayList;

public class Solution {
    public int bulbs(ArrayList<Integer> A) {
        int count = 0;
        for (int value : A) {
            if (count % 2 != 0 && value == 1) {
                count++;
            } else if (value == 0 && count % 2 == 0)
                count++;
        }
        return count;
    }
}