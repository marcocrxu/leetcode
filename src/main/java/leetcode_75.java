public class leetcode_75 {
    public static void sortColors(int[] nums) {
        if(nums.length<=1)
            return;
        int l=0;
        int r=nums.length-1;
        for(int i=0;i<=r;i++){
            if(nums[i]==0) {
                nums[i]=nums[l];
                nums[l++]=0;
                if(nums[i]!=1&&l<=i)
                    i--;
            }
            else if(nums[i]==1){
                continue;
            }
            else{
                nums[i]=nums[r];
                nums[r--]=2;
                if(nums[i]!=1&&r>=i)
                    i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=ListNode.stringToIntegerArray("[1,2,0,0,0]");
        sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
