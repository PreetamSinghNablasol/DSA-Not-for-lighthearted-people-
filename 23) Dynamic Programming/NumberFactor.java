import java.util.*;

public class NumberFactor {
    public static void main(String[] args) {
        System.out.println((new Solution()).solutionMemoization(10, 10, new HashMap<Integer, Integer>()));
        System.out.println((new Solution()).solutionTabulation(10));
    }
}

class Solution {
    public int solutionMemoization(int N, int current, HashMap<Integer, Integer> memo) {
        if (current == 0)
            return 1;
        else if (current < 0)
            return 0;
        else {
            if (memo.containsKey(current))
                return memo.get(current);
            int result = 0;
            if (current >= 1)
                result += solutionMemoization(N, current - 1, memo);
            if (current >= 3)
                result += solutionMemoization(N, current - 3, memo);
            if (current >= 4)
                result += solutionMemoization(N, current - 4, memo);
            memo.put(current, result);
            return memo.get(current);
        }
    }

    public int solutionTabulation(int N) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        map.put(1, 1);
        for (int i = 2; i <= N; i++) {
            int ways = 0;
            if (i >= 1)
                ways += map.get(i - 1);
            if (i >= 3)
                ways += map.get(i - 3);
            if (i >= 4)
                ways += map.get(i - 4);
            map.put(i, ways);
        }
        return map.get(N);
    }
}
