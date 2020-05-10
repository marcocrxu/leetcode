import java.util.Arrays;

public class leetcode_55 {
    /*
    public boolean canJump(int[] nums) {
        boolean[] can=new boolean[nums.length];
        Arrays.fill(can,false);
        can[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums[i];j>0;j--){
                if(can[i+j]){
                    can[i]=true;
                    break;
                }
            }
        }
        return can[0];
    }
    */
    //Ì°ÐÄ
    public boolean canJump(int[] nums) {
        int max=1;
        int i=0;
        while(i<max) {
            if(nums[i]+i+1>max){
                max=nums[i]+i+1;
            }
            if(max>=nums.length)
                return true;
            i++;
        }
        return max>=nums.length;
    }
}
