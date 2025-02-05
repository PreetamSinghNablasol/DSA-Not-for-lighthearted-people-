import java.lang.Math;

class ConvertOneStringToAnotherProblem {
    public static void main(String[] args) {
        String s1 = "preetam";
        String s2 = "kreetamsingh";
        System.out.println((new Convertion()).solution(s1, s2, 0, 0));
    }
}

class Convertion {
    public int solution(String s1, String s2, int index1, int index2) {
        if (index1 == s1.length()) { // since we have reached the end
            return s2.length() - index2;
        }
        if (index2 == s2.length()) {
            return s1.length() - index1;
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return solution(s1, s2, index1 + 1, index2 + 1);
        } else {
            int deleteOp = 1 + solution(s1, s2, index1, index2 + 1);
            int insertOp = 1 + solution(s1, s2, index1 + 1, index2);
            int replaceOp = 1 + solution(s1, s2, index1 + 1, index2 + 1);
            return Math.min(Math.max(deleteOp, insertOp), replaceOp);
        }
    }
}

/*
 * s1= "preetam"
 * s2 = "preetamsingh"
 */