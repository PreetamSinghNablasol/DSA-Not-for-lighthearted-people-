import java.lang.Math;

class LongestPlaindromicSubsequenceProblem {
    public static void main(String[] args) {
        System.out.println((new Solution()).solution("praeetamp", 0, 8));
    }
}

class Solution {
    public int solution(String str, int start, int end) {
        if (start > end) {
            return 0;
        } else {
            int case1 = 0;
            if (str.charAt(start) == str.charAt(end))
                case1 = start == end ? 1 + solution(str, start + 1, end - 1) : 2 + solution(str, start + 1, end - 1);
            int case2 = solution(str, start + 1, end);
            int case3 = solution(str, start, end - 1);
            return Math.max(case1, Math.max(case2, case3));
        }
    }
}