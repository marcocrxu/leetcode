public class splitList {
    public static int splitArray(int[] nums, int m) {

        return 0;
    }

    //±©Á¦dfs
    public static int dfs(int[] nums,int m,int start,int pre_max){
        if(start==nums.length-m+1){
            return Math.max(dfs(nums,m-1,start+1,Math.max(pre_max,nums[start])),pre_max);
        }
        if(m==1){
            int sum=0;
            for(int i=start;i<nums.length;i++)
                sum+=nums[i];
            return Math.max(pre_max,sum);
        }
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=start;i<nums.length-m+1;i++){
            sum+=nums[i];
            int temp=dfs(nums,m-1,i+1,Math.max(sum,pre_max));
            if(min>temp)
                min=temp;
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(splitArray(ListNode.stringToIntegerArray("[7,6,5,4,3,2,1]"),2));
    }

}
