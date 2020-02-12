/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

import java.util.HashMap;
import java.util.List;

public class Solution {
    public int majorityElement(final List<Integer> A) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i : A) {
            if (hm.containsKey(i))
                hm.put(i, hm.get(i) + 1);
            else
                hm.put(i, 1);
        }

        int max = Integer.MIN_VALUE, result = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) > max) {
                max = hm.get(key);
                result = key;
            }
        }
        return result;
    }
}
