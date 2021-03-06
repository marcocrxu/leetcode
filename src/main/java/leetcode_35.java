import java.util.*;

public class leetcode_35 {
    public static int searchInsert(int[] nums, int target) {
        int start=0;int end=nums.length;
        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]<target)
                start=mid+1;
            else
                end=mid;
        }
        return start;
    }
    public static void main(String[] args){
        System.out.println(searchInsert(ListNode.stringToIntegerArray("[]"),2));
    }
}
