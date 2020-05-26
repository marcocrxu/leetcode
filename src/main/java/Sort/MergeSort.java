package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums,int start,int end){
        if(start==end-1){
            //只有一个或者两个
            return;
        }
        if(start==end-2){
            if(nums[start]>nums[start+1]){
                int temp=nums[start];
                nums[start]=nums[start+1];
                nums[start+1]=temp;
            }
            return;
        }
        int mid=(start+end)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid,end);
        merge(nums,start,mid,end);
    }

    public static void merge(int[] nums,int start,int mid,int endp) {
        int[] temp=new int[endp-mid];
        for(int i=0;i<endp-mid;i++) {
            temp[i] = nums[mid + i];
        }
        int end=endp-1;
        int end1=mid-1;
        int end2=endp-mid-1;
        while(end1>=0&&end2>=0){
            if(nums[end1]>temp[end2]){
                nums[end--]=nums[end1--];
            }else{
                nums[end--]=temp[end2--];
            }
        }
        if(end1>=0){
            //end1>=0
            return;
        }else{
            //end2>=0
            while(end2>=0){
                nums[end--]=temp[end2--];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums=ListNode.stringToIntegerArray("[9,8,7,6,1,2,5,4,3]");
        mergeSort(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
