import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    private static int quick_partition(List<Integer> al, int beg, int end) {
        int pivot = beg, left = beg, right = end;
        while (left < right) {
            while (al.get(left) <= al.get(pivot)) {
                left++;
            }
            while (al.get(right) > al.get(pivot)) {
                right--;
            }
            if (left < right)
                Collections.swap(al, left, right);
        }
        Collections.swap(al, pivot, right);
        return right;
    }

    private static void quick_procedure(List<Integer> al, int beg, int end) {
        if (beg < end) {
            int loc = quick_partition(al, beg, end);
            quick_procedure(al, beg, loc - 1);
            quick_procedure(al, loc + 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Numbers and press enter:");
        String str[] = br.readLine().split(" ");

        List<Integer> al = new ArrayList<>();
        al = Arrays.stream(str).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        al.add(Integer.MAX_VALUE);

        quick_procedure(al, 0, al.size() - 1);
        al.remove(al.size() - 1);

        al.stream().forEach(value -> System.out.print(value + " "));
    }
}
