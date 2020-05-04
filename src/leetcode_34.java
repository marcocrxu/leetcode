public class leetcode_34 {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        int start=0;int end=nums.length;
        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]<target)
                start=mid+1;
            else
                end=mid;
        }
        int s=start;
        end=nums.length;
        if(start>=nums.length||nums[start]!=target)
            return new int[]{-1,-1};
        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]<=target)
                start=mid+1;
            else
                end=mid;
        }
        return new int[]{s,end-1};
    }
    public static void main(String[] args){
        int[] res=searchRange(ListNode.stringToIntegerArray("[2,2,3]"),4);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
