package amazonPrep;

import java.util.Arrays;
import java.util.stream.Stream;

public class ShipmentCount {

    int max;
    int j;
    public static void main(String[] args) {
        int[] arr={4,3,3,2,1};    // 1 1 2 3 3 4 6 7    0 0 1 2 2 3 5 6  0 0 0 1 1 2 4 5  0 0 0 0 0 1 3 4  0 0 0 0 0 0 2 3  0 0 0 0 0 0 0 1  0 0 0 0 0 0 0 1
        ShipmentCount obj = new ShipmentCount();
        obj.getShipmentCount(arr);
        System.out.println(obj.getMax());
    }
//     0 1 1 1 2   0 0 0 0 1
    private void getShipmentCount(int[] arr) {
        int min=findMinNumber(arr);
        if(arr[arr.length-1]==0) return;
        for (int j=0;j<arr.length;j++){
            if(arr[j]==0) continue;
            arr[j]-= min;
        }

        getShipmentCount(arr);
        max++;
    }

    private int getMax(){
        return max;
    }

    int findMinNumber(int[] ary){
        if(ary.length==0) return -1;
        Arrays.sort(ary);
        for(int i=0;i<ary.length;i++){
            if(ary[i]!=0){
                return ary[i];
            }
        }
        return ary[0];
    }
}