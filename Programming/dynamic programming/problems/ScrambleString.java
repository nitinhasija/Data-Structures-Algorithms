/*
Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings A and B of the same length, determine if B is a scrambled string of S.

Input Format:
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format:
Return an integer, 0 or 1:
    => 0 : False
    => 1 : True
*/

import java.util.HashMap;

public class Solution {
    private int checkScramble(String s1, String s2, HashMap<String, Integer> hm) {
        if (s1.equals(s2))
            return 1;

        if (isAnagrams(s1, s2) == false)
            return 0;

        String s = s1 + "|" + s2;

        if (!hm.containsKey(s)) {
            for (int i = 1; i < s1.length(); i++) {
                if (checkScramble(s1.substring(0, i), s2.substring(0, i), hm) == 1 && checkScramble(s1.substring(i), s2.substring(i), hm) == 1)
                    hm.put(s, 1);
                else if (checkScramble(s1.substring(0, i), s2.substring(s2.length() - i), hm) == 1 && checkScramble(s1.substring(i), s2.substring(0, s2.length() - i), hm) == 1)
                    hm.put(s, 1);
            }
            if (!hm.containsKey(s))
                hm.put(s, 0);
        }
        return hm.get(s);
    }

    public int isScramble(final String s1, final String s2) {
        HashMap<String, Integer> hm = new HashMap();
        return checkScramble(s1, s2, hm);
    }

    private boolean isAnagrams(String a, String b) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            if (hm1.containsKey(a.charAt(i)))
                hm1.put(a.charAt(i), hm1.get(a.charAt(i)) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            if (hm2.containsKey(b.charAt(i)))
                hm1.put(b.charAt(i), hm1.get(b.charAt(i)) + 1);
        }

        if (hm1.size() != hm2.size())
            return false;

        for (char ch : hm1.keySet()) {
            if (hm1.get(ch) != hm2.get(ch))
                return false;
        }

        return true;
    }
}