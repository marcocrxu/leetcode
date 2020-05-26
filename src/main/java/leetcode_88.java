import java.util.Arrays;

public class leetcode_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end=m+n-1;
        int end1=m-1;
        int end2=n-1;
        while(end1>=0&&end2>=0){
            if(nums1[end1]>nums2[end2]){
                nums1[end--]=nums1[end1--];
            }else{
                nums1[end--]=nums2[end2--];
            }
        }
        if(end1>=0){
            //end1>=0
            return;
        }else{
            //end2>=0
            while(end2>=0){
                nums1[end--]=nums2[end2--];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums1=ListNode.stringToIntegerArray("[0,0,0,0,0]");
        int[] nums2=ListNode.stringToIntegerArray("[1,2,3,4,5]");
        merge(nums1,0,nums2,5);
        System.out.println(Arrays.toString(nums1));
    }
}
