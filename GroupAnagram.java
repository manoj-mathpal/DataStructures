package phonePe;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();


        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramss(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        List<Integer> ls = new ArrayList<>();
      //  int[] a = ar;
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            sb.append(ch);
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(),new ArrayList());
            }
            map.get(sb.toString()).add(str);
            sb.replace(0,ch.length, "");
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lst= new GroupAnagram().groupAnagramss(strs);
        for(List l : lst){
            System.out.println(l.toString());
        }

    }
}
