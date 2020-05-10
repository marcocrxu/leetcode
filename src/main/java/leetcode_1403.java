import java.util.*;
public class leetcode_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int part_sum=0;
        for(int i=nums.length-1;i>=0;i--){
            if(part_sum*2>sum){
                break;
            }
            part_sum+=nums[i];
            res.add(nums[i]);
        }
        return res;
    }
}
