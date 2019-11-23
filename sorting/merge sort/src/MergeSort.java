public class MergeSort {

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
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
    }

    static void display(int ar[]) {
        for (int x = 0; x < ar.length; x++) {
            System.out.print(ar[x] + " ");
        }
    }

    public static void main(String[] args) {
        int ar[] = {80, 70, 60, -1, 50, 40, 30, 20, 10};
        merge_sort(0, 8, ar);
        display(ar);

    }

}
