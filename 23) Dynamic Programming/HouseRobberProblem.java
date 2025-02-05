import java.util.*;
import java.lang.Math;

public class HouseRobberProblem {
    public static void main(String[] args) {
        System.out.println((new Solution()).solutionMemoization(new int[] { 6, 7, 1, 30, 8, 2, 4 }, 0,
                new HashMap<Integer, Integer>()));
        System.out.println((new Solution()).solutionTabulation(new int[] { 6, 7, 1, 30, 8, 2, 4 }));
    }
}

class Solution {
    public int solutionMemoization(int[] houses, int current, HashMap<Integer, Integer> map) {
        if (current == houses.length - 1)
            return houses[houses.length - 1];
        if (current == houses.length)
            return 0;
        else {
            if (map.containsKey(current))
                return map.get(current);
            int case1 = houses[current] + solutionMemoization(houses, current + 2, map);
            int case2 = solutionMemoization(houses, current + 1, map);
            map.put(current, Math.max(case1, case2));
            return Math.max(case1, case2);
        }
    }

    public int solutionTabulation(int[] houses) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(houses.length - 1, houses[houses.length - 1]);
        map.put(houses.length, 0);
        for (int i = houses.length - 2; i >= 0; i--) {
            int case1 = houses[i] + map.get(i + 2);
            int case2 = map.get(i + 1);
            map.put(i, Math.max(case1, case2));
        }
        return map.get(0);
    }
}
