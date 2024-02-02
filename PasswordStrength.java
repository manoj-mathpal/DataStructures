package amazonPrep;

import java.util.*;

public class PasswordStrength {
    static int max=0;
    public static int  findPasswordStrength(String input) {
        Set<String> substrings = new HashSet<>();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(input.substring(i, j));
            }
        }
        System.out.println(substrings.toString());

        List<String> list = new ArrayList<String>(substrings);
        for(int i=0;i<list.size();i++) {
            max += list.get(i).length();
            System.out.println(list.get(i) + ">" + list.get(i).length() + " totalSum= " + max);
        }
        return max;
    }


    public static int  topAppeal(String input) {
        List<String> substrings = new ArrayList<>();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(input.substring(i, j));
            }
        }
        Set<String> substr = new HashSet<>();
        int count=0;
        for (int i = 0; i < substrings.size(); i++) {
            char[] ch = substrings.get(i).toCharArray();
            int k;
            for (k = 0; k < ch.length; k++) {
                substr.add(String.valueOf(ch[k]));
                System.out.println(substr.toString() + " > " + substr.size());
                count = substr.size();
                max =Math.max(max,count) ;
                count = 0;
            }
            substr.remove(String.valueOf(ch[i]));
        }
        return max;
    }
    public static void main(String[] args) {

        int max = topAppeal("abbca");
        System.out.println(max);
    }
}
