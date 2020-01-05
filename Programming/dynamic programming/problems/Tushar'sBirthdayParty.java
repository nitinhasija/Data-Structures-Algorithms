/*
As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar’s friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.

Input Format
Friends : List of integers denoting eating capacity of friends separated by space.
Capacity: List of integers denoting filling capacity of each type of dish.
Cost :    List of integers denoting cost of each type of dish.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

import java.util.Arrays;
import java.util.HashMap;

class Node implements Comparable<Node> {
    int fillingCapacity;
    int dishPrice;

    public Node(int fillingCapacity, int dishPrice) {
        this.fillingCapacity = fillingCapacity;
        this.dishPrice = dishPrice;
    }

    public int compareTo(Node n) {
        if (fillingCapacity < n.fillingCapacity)
            return 1;
        else
            return -1;
    }
}

public class Solution {
    private HashMap<String, Integer> memo;

    private int getCost(int friendCapacity, int index, Node[] n) {
        if (index >= n.length)
            return Integer.MAX_VALUE;

        if (friendCapacity <= 0)
            return 0;

        String str = index + "|" + friendCapacity;

        if (!memo.containsKey(str)) {
            int include = Integer.MAX_VALUE, exclude;

            if (friendCapacity >= n[index].fillingCapacity)
                include = getCost(friendCapacity - n[index].fillingCapacity, index, n) + n[index].dishPrice;

            exclude = getCost(friendCapacity, index + 1, n);

            memo.put(str, Math.min(exclude, include));
        }
        return memo.get(str);
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        int sum = 0;
        memo = new HashMap<>();
        Node[] n = new Node[B.length];

        for (int i = 0; i < B.length; i++) {
            n[i] = new Node(B[i], C[i]);
        }

        Arrays.sort(n);

        for (int capacity : A) {
            sum += getCost(capacity, 0, n);
        }
        return sum;
    }
}