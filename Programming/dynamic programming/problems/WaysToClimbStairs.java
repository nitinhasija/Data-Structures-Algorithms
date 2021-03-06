/*
You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Input Format:
The first and the only argument contains an integer A, the number of steps.

Output Format:
Return an integer, representing the number of ways to reach the top.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

public class WaysToClimbStairs {
    public int climbStairs(int A) {
        int[] lookUp = new int[A + 1];
        lookUp[0] = 1;
        lookUp[1] = 2;

        for (int i = 2; i <= A; i++)
            lookUp[i] = lookUp[i - 1] + lookUp[i - 2];

        return lookUp[A - 1];
    }
}
