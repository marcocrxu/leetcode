public class ConcatenationMaxSum {
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int max=maxSubArray(arr);
        if(k==1)
            return max;
        //从头开始的最大的
        int max_from_begin=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max_from_begin)
                max_from_begin=sum;
        }
        int max_to_end=0;
        sum=0;
        for(int i=arr.length-1;i>=0;i--){
            sum+=arr[i];
            if(sum>max_to_end){
                max_to_end=sum;
            }
        }
        int all_sum=sum;
        if(all_sum<0){
            return Math.max(max_from_begin+max_to_end,max);
        }
        all_sum= (int) (all_sum%(1e9+7));
        long temp=(long)(k-2)*(long)all_sum;
        temp= (long) (temp%(1e9+7));
        return Math.max((max_from_begin+max_to_end+(int)temp)%((int)(1e9+7)),max);
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length==0)
            return Integer.MIN_VALUE;
        int sum=0;
        int maxSum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum)
                maxSum=sum;
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[]{1,2},36263));
    }
}
