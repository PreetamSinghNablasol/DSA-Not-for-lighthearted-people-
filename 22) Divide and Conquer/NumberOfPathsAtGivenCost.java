public class NumberOfPathsAtGivenCost {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 4, 7, 1, 6 },
                { 5, 7, 3, 9 },
                { 3, 2, 1, 2 },
                { 7, 1, 6, 3 } };
        System.out.println((new Solution()).solution(matrix, 2, matrix.length - 1, matrix.length - 1, 0));
    }
}

class Solution { // weight of the destination included
    public int solution(int[][] matrix, int limit, int x, int y, int current) {
        if (x == 0 && y == 0 && current <= limit) {
            return 1;
        } else if (limit < current || x < 0 || y < 0)
            return 0;
        else {
            return solution(matrix, limit, x - 1, y, current + matrix[x][y])
                    + solution(matrix, limit, x, y - 1, current + matrix[x][y]);
        }
    }
}