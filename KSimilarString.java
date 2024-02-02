package amazonPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarString {

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> vis= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(A);
        vis.add(A);
        int res=0;
        while(!q.isEmpty()){
            res++;
            for (int sz=q.size(); sz>0; sz--){
                String s= q.poll();
                int i=0;
                while (s.charAt(i)==B.charAt(i)) i++;
                for (int j=i+1; j<s.length(); j++){
                    if (s.charAt(j)==B.charAt(j) || s.charAt(j)!=B.charAt(i) ) continue;
                    String temp= swap(s, i, j);
                    if (temp.equals(B)) return res;
                    if (vis.add(temp)) q.add(temp);
                }
            }
        }
        return res;
    }
    public String swap(String s, int i, int j){
        char[] ca=s.toCharArray();
        char temp=ca[i];
        ca[i]=ca[j];
        ca[j]=temp;
        return new String(ca);
    }

    public static void main(String[] args) {
        System.out.println( new KSimilarString().kSimilarity("cabd","adcb"));
    }
}
