package amazonPrep;

import java.util.*;

public class AmazonReview {
    private TreeMap<Integer,String> map= new TreeMap<>(Collections.reverseOrder());
    private int maxLength;
    private List<String> list = new ArrayList<>();

//    String str="GoodProductButscrapAfterWash";
//    List<String> words = new ArrayList<>();
//        words.add("crap");
//        words.add("odpro");


    public void breakString(String review, List<String> prohibitedWords){
        String probSubString;
        review = review.toLowerCase();
        int j = 0;
        for (; j < prohibitedWords.size(); ) {
            probSubString = prohibitedWords.get(j);
            if (review.contains(prohibitedWords.get(j))) {
                int startIndex = review.indexOf(probSubString);
                int endIndex = review.lastIndexOf(probSubString) + probSubString.length();
                list.add(review.substring(0, endIndex - 1));
                list.add(review.substring(startIndex + 1, review.length()));
                for(int i=0;i<list.size();i++) {
                    String str = list.get(i);
                    list.remove(i);
                    findReviewScore(str,prohibitedWords);
                }
            } else {
                int count=0;
                for(int k=0;k<prohibitedWords.size();k++)  if(!review.contains(prohibitedWords.get(k))) count++;
                if(count==prohibitedWords.size())  map.put(review.length(),review);
            }
            j++;
        }
    }
    public int findReviewScore(String review, List<String> prohibitedWords) {
        breakString(review,prohibitedWords);
       for(Map.Entry<Integer,String> entry : map.entrySet()){
           maxLength=Math.max(maxLength,entry.getKey());
       }
       return maxLength;
    }



    public static void main(String[] args) {
        String str="ExtremeValueForMoney";
        List<String> words = new ArrayList<>();
        words.add("tuper");
        words.add("douche");
        AmazonReview obj = new AmazonReview();
        System.out.println( obj.findReviewScore(str,words));

    }

}