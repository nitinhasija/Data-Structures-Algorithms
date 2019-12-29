import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        ArrayList<String> al = new ArrayList();
        Set<String> set = new HashSet(B);

        byRecursion(A, "", al, set);
        return al;
    }

    private void byRecursion(String a, String temp, ArrayList<String> al, Set<String> hs) {
        if (a.isEmpty()) {
            al.add(temp);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            if (hs.contains(sb.toString())) {
                String item = temp.isEmpty() ? sb.toString() : temp + " " + sb.toString();
                byRecursion(a.substring(i + 1), item, al, hs);
            }
        }
    }

    private ArrayList<String> topDown(String A, Set<String> hs, HashMap<String, ArrayList<String>> hm) {
        if (hm.containsKey(A))
            return hm.get(A);

        if (A.isEmpty())
            return new ArrayList();

        ArrayList<String> al = new ArrayList<>();
        String str = "";

        for (int i = 0; i < A.length(); i++) {
            str += A.charAt(i);
            if (hs.contains(str)) {
                if (i < A.length() - 1) {
                    ArrayList<String> x = topDown(A.substring(i + 1), hs, hm);
                    for (String s : x) {
                        String string = str + " " + s;
                        al.add(string);
                    }
                } else
                    al.add(str);
            }
        }
        hm.put(A, al);
        return al;
    }
}
