import java.util.*;
/*


Obstacle Game
Given a n*n Array matrix (A) with A[0][0] element as the starting point and any one element as the destination.

Problem Description
Given a n*n Array matrix (A) with A[0][0] element as the starting point and any one element as the destination. Find the destination and print the route map.
Rules:
1. Array Matrix with n*n elements such that n >=2 and n<=10.
2. Starting point A[0][0] value will be 'A'.
3. Destination value will be 'D'
4. There will be always 1 continuous route which can be straight or diagonal.
5. There are 4 types of hurdles and corresponding values :
a. Stone denoted by 'S'
b. Wall denoted by 'L'
c. Water denoted by 'W'
d. Thorn denoted by 'T'
6. Music provides mind peace. Which will be denoted by 'M'. It is not a hurdle.
6. The value of route will be 'R'.

Input
First Line contains dimension N of Matrix A.

Next N Lines, each contains N values delimited by space

Output
At every Step print the surrounded hurdles in ascending order of values. i.e. for every 'R' print the surrounding hurdles.

If there are no hurdled around step in the route, print 'NO HURDLES' for that step.

On reaching destination print 'DESTINATION'

Music 'M' is not a hurdle. It should not be included in output.

Constraints
2 <= N <= 20

Difficulty Level
Simple

Time Limit (secs)
1
Examples
Example 1
Input
4
A S L D
T R W R
R M S R
W R R M


Output:

L S S T W

T W

S W

S

S W

L S W

DESTINATION

Example 2

Input:

5

A S L W M

R S L D T

M R T R M

T L R M S

S L S W T

Output:

S S

L L S T T

L L S T W

L S T T

DESTINATION

A S L D
T R W R
R M S R
W R R M

 */

public class CodeVita {
    public static void main(String[] args) {
        char[][] arr = new char[][] { { 'A', 'S', 'L', 'D' }, { 'T', 'R', 'W', 'R' }, { 'R', 'M', 'S', 'R' },
                { 'W', 'R', 'R', 'M' } };
        solution(arr, 4);
    }

    public static void solution(char[][] arr, int n) {
        HashSet<Character> obs = new HashSet<>();
        obs.add('S');
        obs.add('L');
        obs.add('W');
        obs.add('T');
        int i = 0;
        int j = 0;
        int nextI = 0;
        int nextJ = 0;
        if (arr[0][1] == 'R') {
            j = 1;
        } else if (arr[1][1] == 'R') {
            i = 1;
            j = 1;
        } else {
            i = 1;
        }
        int flag = 0;
        while (true) {
            flag = 0;
            if (i - 1 >= 0 && (arr[i - 1][j] == 'R' || obs.contains(arr[i - 1][j]))) {
                if (arr[i - 1][j] == 'R' && flag == 0) {
                    flag = 1;
                    nextI = i - 1;
                } else
                    System.out.print(arr[i - 1][j] + " ");
            }
            if ((i - 1 >= 0 && j + 1 < n) && (arr[i - 1][j + 1] == 'R' || obs.contains(arr[i - 1][j + 1]))) {
                if (arr[i - 1][j + 1] == 'R' && flag == 0) {
                    flag = 1;

                    nextI = i - 1;
                    nextJ = j + 1;
                } else
                    System.out.print(arr[i - 1][j + 1] + " ");
            }
            if ((j + 1 < n) && (arr[i][j + 1] == 'R' || obs.contains(arr[i][j + 1]))) {
                if (arr[i][j + 1] == 'R' && flag == 0) {
                    flag = 1;

                    nextJ = j + 1;
                } else
                    System.out.print(arr[i][j + 1] + " ");
            }
            if ((i + 1 < n && j + 1 < n) && (arr[i + 1][j + 1] == 'R' || obs.contains(arr[i + 1][j + 1]))) {
                if (arr[i + 1][j + 1] == 'R' && flag == 0) {
                    flag = 1;

                    nextI = i + 1;
                    nextJ = j + 1;
                } else
                    System.out.print(arr[i + 1][j + 1] + " ");
            }
            if ((i + 1 < n) && (arr[i + 1][j] == 'R' || obs.contains(arr[i + 1][j]))) {
                if (arr[i + 1][j] == 'R' && flag == 0) {
                    flag = 1;

                    nextI = i + 1;
                } else
                    System.out.print(arr[i + 1][j] + " ");
            }
            if ((i + 1 < n && j - 1 >= 0) && (arr[i + 1][j - 1] == 'R' || obs.contains(arr[i + 1][j - 1]))) {
                if (arr[i + 1][j - 1] == 'R' && flag == 0) {
                    flag = 1;
                    nextI = i + 1;
                    nextJ = j - 1;
                } else
                    System.out.print(arr[i + 1][j - 1] + " ");
            }
            if ((j - 1 >= 0) && (arr[i][j - 1] == 'R' || obs.contains(arr[i][j - 1]))) {
                if (arr[i][j - 1] == 'R' && flag == 0) {
                    flag = 1;

                    nextJ = j - 1;
                } else
                    System.out.print(arr[i][j - 1] + " ");
            }
            if ((i - 1 >= 0 && j - 1 >= 0) && (arr[i - 1][j - 1] == 'R' || obs.contains(arr[i - 1][j - 1]))) {
                if (arr[i - 1][j - 1] == 'R' && flag == 0) {
                    flag = 1;
                    nextI = i - 1;
                    nextJ = j - 1;
                } else
                    System.out.print(arr[i - 1][j - 1] + " ");
            }
            if (flag == 0) {
                break;
            }
            System.out.println();
            arr[i][j] = 'A';
            i = nextI;
            j = nextJ;
        }

    }
}
