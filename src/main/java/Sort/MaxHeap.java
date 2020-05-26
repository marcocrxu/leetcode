package Sort;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {
    //获取最大的几个
    public static void getMinN(int[] nums,int n){
        int[] heap=new int[n];
        for(int i=0;i<n;i++){
            heap[i]=nums[i];
        }
        for(int i=(n+1)/2-1;i>=0;i--){
            heapify(nums,n,i);
        }
        for(int i=n;i<nums.length;i++){
            if(nums[i]<heap[0]){
                heap[0]=nums[i];
                //最大堆化
                heapify(heap,n,0);
            }
        }
        System.out.println(Arrays.toString(heap));
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void heapify(int[] nums,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&nums[left]>nums[largest]){
            largest=left;
        }
        if(right<n&&nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(nums,i,largest);
            heapify(nums,n,largest);
        }
    }

    public static void heapSort(int[] nums){
        for(int i=(nums.length+1)/2-1;i>=0;i--) {
            heapify(nums, nums.length, i);
        }
        int end=nums.length-1;
        for(int i=0;i<nums.length;i++){
            swap(nums,0,end);
            heapify(nums,end--,0);
        }
    }

    public static void main(String[] args) {
        int[] nums= ListNode.stringToIntegerArray("[9,8,7,4,5,6,1,3,2]");
        //heapSort(nums);
        System.out.println(Arrays.toString(nums));
        getMinN(nums,3);
    }

}
