package amazonPrep;

import java.util.Stack;

public class BracketMatching {


    public static int calculateScore(String s) {
        int score = 0;
        int n = s.length();
        int j=1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                for (; j < n;) {
                    if (s.charAt(j) == ')') {
                        score += Math.max(score,j - i);
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        String bracketSequence = "()()"; // Replace with your input
        int score = calculateScore(bracketSequence);
        System.out.println("Score: " + score);
    }
}