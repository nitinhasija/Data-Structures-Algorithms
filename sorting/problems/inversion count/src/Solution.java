/*
Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j
*/

import java.util.*;

class GFG {
    private static long inversionCount = 0;

    static void merge_sort(int p, int r, int arr[]) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(p, q, arr);
            merge_sort(q + 1, r, arr);
            merge(p, q, r, arr);
        }
    }

    static void merge(int p, int q, int r, int arr[]) {
        int n1 = q - p + 1, n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        int x = p, i = 0;
        while (x <= q) {
            left[i] = arr[x];
            i++;
            x++;
        }

        x = q + 1;
        i = 0;
        while (x <= r) {
            right[i] = arr[x];
            i++;
            x++;
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        i = 0;
        int j = 0, k = p;
        while (k <= r) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                if (i < n1)
                    inversionCount += (long)(n1 - i);// as left and right arrays are sorted so
                                                     // so, rest all elements of left array are greater than current element of right array
                arr[k] = right[j];
                j++;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- > 0){
            inversionCount = 0;

            int length = sc.nextInt();
            int ar[] = new int[length];

            for(int i = 0;i<length;i++)
                ar[i] = sc.nextInt();

            merge_sort(0, ar.length - 1, ar);
            System.out.println(inversionCount);
        }
    }
}