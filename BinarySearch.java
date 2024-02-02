package arrayStringProblems;

public class BinarySearch {

    public static void main(String[] args) {
        int[] ary = {-1,0,3,5,9,12};
        int key=9;
        System.out.println(new BinarySearch().getIndex(ary,key));
    }

    private int getIndex(int[] ary, int key) {
        if(ary.length==0) return -1;
        int start=0;
        int end=ary.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(ary[mid]==key){
                return mid;
            } else if (ary[mid]<key) {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
}
