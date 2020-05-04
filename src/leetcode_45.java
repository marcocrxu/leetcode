public class leetcode_45 {
    public int jump(int[] nums) {
        if(nums[0]+1>=nums.length)
            return 1;
        if(nums[nums[0]+1]+nums[0]+1>=nums.length)
            return 2;
        int[] can=new int[nums.length];
        nums[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            int min=Integer.MAX_VALUE/2;
            for(int j=nums[i];j>0;j--){
                if(i+j>=nums.length){
                    min=1;
                    break;
                }
                if(1+can[i+j]<min){
                    min=1+can[i+j];
                }
            }
            can[i]=min;
        }
        return can[0];
    }
}
