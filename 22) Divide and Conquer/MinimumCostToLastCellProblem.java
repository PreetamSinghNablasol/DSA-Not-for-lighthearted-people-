
import java.lang.Math;

public class MinimumCostToLastCellProblem {
    public static void main(String... args) {
        int[][] matrix = new int[][] { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 },
                { 2, 9, 8, 9, 3 } };
        System.out.println((new Solution()).solution(matrix, 4, 4));
    }
}

class Solution {
    public int solution(int[][] matrix, int x, int y) {
        if (x == 0 && y == 0) // this is to check if we have reached adjacent to 0,0
            return -matrix[0][0];
        if (x - 1 < 0 || y - 1 < 0)
            return Integer.MAX_VALUE;
        else {
            int case1 = matrix[x - 1][y] + solution(matrix, x - 1, y);
            int case2 = matrix[x][y - 1] + solution(matrix, x, y - 1);
            return Math.min(case1, case2);
        }
    }
}
