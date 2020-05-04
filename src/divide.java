import java.lang.reflect.Array;
import java.util.Arrays;

public class divide {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length<=1)
            return nums;
        if(nums.length==2){
            int temp=nums[1];
            nums[1]=nums[0];
            nums[0]=temp;
            return nums;
        }
        int[] res=new int[nums.length];
        Arrays.fill(res,0);
        int[] left_to_right=new int[nums.length];
        int[] right_to_left=new int[nums.length];
        Arrays.fill(left_to_right,1);
        Arrays.fill(right_to_left,1);
        left_to_right[0]=nums[0];right_to_left[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            left_to_right[i]=left_to_right[i-1]*nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            right_to_left[i]=right_to_left[i+1]*nums[i];
        }
        res[0]=right_to_left[1];res[nums.length-1]=left_to_right[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            res[i]=left_to_right[i-1]*right_to_left[i+1];
        }
        return res;
    }
}
