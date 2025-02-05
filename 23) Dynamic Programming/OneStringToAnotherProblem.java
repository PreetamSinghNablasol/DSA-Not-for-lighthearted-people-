import java.util.*;
import java.lang.Math;

public class OneStringToAnotherProblem {
    public static void main(String... args) {
        System.out.println(
                (new Solution()).solutionMemoization("preetam", "preeltam", 0, 0, new HashMap<Integer[], Integer>()));
    }
}

class Solution {
    public int solutionMemoization(String s1, String s2, int index1, int index2, HashMap<Integer[], Integer> map) {
        if (index1 == s1.length()) {
            return s2.length() - index2;
        } else if (index2 == s2.length()) {
            return s1.length() - index1;
        } else if (s1.charAt(index1) == s2.charAt(index2))
            return solutionMemoization(s1, s2, index1 + 1, index2 + 1, map);
        else {
            if (map.containsKey(new Integer[] { index1, index2 }))
                return map.get(new Integer[] { index1, index2 });
            int case1 = 1 + solutionMemoization(s1, s2, index1 + 1, index2 + 1, map);
            int case2 = 1 + solutionMemoization(s1, s2, index1 + 1, index2, map);
            int case3 = 1 + solutionMemoization(s1, s2, index1, index2 + 1, map);
            map.put(new Integer[] { index1, index2 }, Math.min(case1, Math.min(case2, case3)));
            return Math.min(case1, Math.min(case2, case3));
        }
    }
}
