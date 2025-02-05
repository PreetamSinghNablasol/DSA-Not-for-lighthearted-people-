import java.lang.Math;

class LongestCommonSubsequenceProblem {
    public static void main(String[] args) {
        System.out.println((new Solution()).solution("pr", "prm", 0, 0));
    }
}

class Solution {
    public int solution(String s1, String s2, int index1, int index2) {
        if (index1 == s1.length() || index2 == s2.length()) {
            return 0;
        } else {
            int option1 = 0;
            if (s1.charAt(index1) == s2.charAt(index2)) {
                option1 = 1 + this.solution(s1, s2, index1 + 1, index2 + 1);
            }
            int option2 = this.solution(s1, s2, index1 + 1, index2);
            int option3 = this.solution(s1, s2, index1, index2 + 1);
            return Math.max(option1, Math.max(option2, option3));
        }
    }
}
