package arrayStringProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class JumpGame {
    int minSum;
int count;
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        if (nums[0] == 0)
            return false;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] > 0) {
                if (nums[start] == end - start)
                    return true;

                else {
                    if (findJumpSpot(nums, start + 1, end - 1)) return true;
                }
            }
            if (nums[start] == 0 && nums[start - 1] == 1)
                return false;
            start++;
        }
        return false;
    }

    public boolean findJumpSpot(int[] nums, int start, int end) {


        for (int i = start; i <= end; i++) {
            if (nums[i] >= (nums.length - 1) - i) {
                return true;
            }
        }
        return false;
    }


    public void sumSubarrayMins(int[] arr) {
        int i = 0;
        int pt = 0;
         ele(arr,pt,1);
    }

    void ele(int[] arr, int start,int end) {
        if(end>arr.length){
            start++;
            end=start+1;
            return;
        }
        List<Integer> lst = new ArrayList();
        for (int j = start; j < end; j++) {
            lst.add(arr[j]);
        }
        minSum += (int) Collections.min(lst);
        System.out.println(">>" + minSum);
        ele(arr,start,++end);
        count++;
    }

    public int rob(int[] nums) {
        int start = 0;
        int curr = start;
        int maxSum = 0;
        int currSum = 0;
        if (nums.length == 0 || nums == null)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2) {
            if (nums[0] >= nums[1])
                return nums[0];
            else
                return nums[1];
        }
        if (nums.length == 3) {
            currSum=nums[start]+nums[start+2];
            if(currSum>nums[1]) return currSum;
            else return nums[1];
        }
        while (start < nums.length) {
            currSum += nums[start];
            if (start==nums.length - 1 || start==nums.length-2) {
                curr++;
                start = curr;
                maxSum=Math.max(currSum,maxSum);
                currSum=0;
            }
            else if(currSum==maxSum && nums.length>2){
                return nums[0]+nums[nums.length-1];
            }
            else{
                start = start + 2;
            }
        }
        return maxSum;

    }



    public static void main(String[] args) {
       int [] nums = {1,2,1,1};
        System.out.println(new JumpGame().rob(nums));
        ;


    }
}
