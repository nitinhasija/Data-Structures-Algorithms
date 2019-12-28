/*
Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.

Input Format:
The first argument is a string, A.
The second argument is an array of strings, B.

Output Format:
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        Set<String> hs = new HashSet(B);

        return wordBreak(A, hs, 0, new Boolean[A.length() + 1]);
    }

    private int wordBreak(String s, Set<String> set, int start, Boolean[] dp) {
        if (start == s.length()) {
            return 1;
        }

        if (dp[start] != null) return dp[start] ? 1 : 0;

        int ans = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && wordBreak(s, set, end, dp) == 1) {
                ans = 1;
                break;
            }
        }

        dp[start] = (ans == 1);
        return ans;
    }
}