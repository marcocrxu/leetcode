import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class NnumberFindHalf {

    public static int Solution(int[] nums){
        if(nums==null)
            return -1;
        Map<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int count=map.getOrDefault(nums[i],0)+1;
            if(count>=n/2)
                return nums[i];
            else
                map.put(nums[i],count);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution(ListNode.stringToIntegerArray("[1,1,1,2,3]")));
    }
}
