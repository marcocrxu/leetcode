package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void sort(int[] nums,int lo,int hi){
        if(lo==hi||hi==lo+1)
            return;
        int mid=lo;
        int tar=nums[mid];
        int tempLo=lo;
        int tempHi=hi;
        for(int i=lo;i<tempHi;i++){
            if(nums[i]<tar){
                swap(nums,i,tempLo++);
            }
            else if(nums[i]>tar){
                swap(nums,i,--tempHi);
                i--;
            }
        }
        sort(nums,lo,tempHi);
        sort(nums,tempHi,hi);
    }

    public static void main(String[] args) {
        int[] arr= ListNode.stringToIntegerArray("[9,8,7,4,5,6,3,2,1]");
        sort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }
}
