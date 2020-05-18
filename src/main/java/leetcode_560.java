import java.util.HashMap;
import java.util.Map;

public class leetcode_560 {
    public static int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        map.put(0,map.getOrDefault(0,0)+1);
        map.put(dp[0],map.getOrDefault(dp[0],0)+1);
        for(int i=1;i<nums.length;i++){
            dp[i]=dp[i-1]+nums[i];
            map.put(dp[i],map.getOrDefault(dp[i],0)+1);
        }
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(map.containsKey(dp[i]-k)) {
                count += map.get(dp[i] - k);
                if(k==0)
                    count--;
            }
            map.put(dp[i],map.getOrDefault(dp[i],1)-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(ListNode.stringToIntegerArray("[1,2,3,4,5]"),0));
    }
}
