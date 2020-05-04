public class leetcode_53 {
    public static int maxSubArray(int[] nums) {
        /*
        if(nums.length==0)
            return Integer.MIN_VALUE;
        int sum=0;
        int maxSum=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum)
                maxSum=sum;
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
        */
        if(nums.length==0)
            return Integer.MIN_VALUE;
        return maxSubArray(nums,nums.length-1);

    }

    public static int maxSubArray(int[] nums,int k){
        if(k==1)
            return nums[0];
        return Math.max(nums[k],maxSubArray(nums,k-1)+nums[k]);
    }


    public static void main(String[] args) {
        System.out.print(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
