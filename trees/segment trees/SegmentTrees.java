import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static void buildSegmentTree(int[] tree, int[] arr, int start, int end, int pos) {
        if (start == end)
            tree[pos] = arr[start];

        else {
            int mid = (start + end) / 2;
            buildSegmentTree(tree, arr, start, mid, 2 * pos + 1);
            buildSegmentTree(tree, arr, mid + 1, end, 2 * pos + 2);
            tree[pos] = Math.min(tree[2 * pos + 1], tree[2 * pos + 2]);
        }
    }

    private static int getMinElement(int[] tree, int start, int end, int rangeStart, int rangeEnd, int pos) {
        if (start >= rangeStart && end <= rangeEnd)      //total overlap
            return tree[pos];

        else if (end < rangeStart || start > rangeEnd)   //no overlap
            return Integer.MAX_VALUE;

        else {                                           //partial overlap
            int mid = (start + end) / 2;
            int leftMinValue = getMinElement(tree, start, mid, rangeStart, rangeEnd, 2 * pos + 1);
            int rightMinValue = getMinElement(tree, mid + 1, end, rangeStart, rangeEnd, 2 * pos + 2);

            return Math.min(leftMinValue, rightMinValue);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{-1, 2, 4, 0, -2};

        int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;                  // height of segment tree

        int[] tree = new int[max_size];
        Arrays.fill(tree, Integer.MAX_VALUE);

        buildSegmentTree(tree, arr, 0, arr.length - 1, 0);

        int startIndex = 1, endIndex = 3;
        int minValue = getMinElement(tree, 0, arr.length - 1, startIndex, endIndex, 0);

        System.out.println("Min value from index " + startIndex + " to index " + endIndex + " : " + minValue);
    }
}