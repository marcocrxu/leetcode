public class leetcode_41 {
    public void swap(int x1,int x2){
        int temp=x1;
        x1=x2;
        x2=temp;
    }


    public static int firstMissingPositive(int[] nums) {
        boolean findOne=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                findOne=true;
                break;
            }
        }
        if(!findOne)
            return 1;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0||nums[i]>n){
                nums[i]=1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==i+1)
                continue;
            while(nums[i]!=1&&nums[i]!=i+1){
                int temp=nums[i];
                if(nums[i]==nums[temp-1]){
                    nums[i]=1;
                }
                else {
                    nums[i] = nums[temp-1];
                    nums[temp-1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
    public static void main(String[] args){
        System.out.println(firstMissingPositive(ListNode.stringToIntegerArray("[10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6]")));
    }
}
