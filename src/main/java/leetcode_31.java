public class leetcode_31 {
    public static void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int pre=nums[nums.length-1];
        boolean find=false;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=pre){
                pre=nums[i];
            }
            else{
                find=true;
                int j=0;
                for(j=i+2;j<nums.length;j++){
                    if(nums[j]<=nums[i])
                        break;
                }
                int temp=nums[j-1];
                nums[j-1]=nums[i];
                nums[i]=temp;
                j=i+1;int k=nums.length-1;
                while(j<k){
                    temp=nums[k];
                    nums[k]=nums[j];
                    nums[j]=temp;
                    j++;k--;
                }
                break;
            }
        }
        if(!find){
            int i=0;int j=nums.length-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
        }
    }

    public static void main(String[] args){
        int[] res=ListNode.stringToIntegerArray("[5,1,1]");
        nextPermutation(res);
        System.out.println(0);
    }
}
