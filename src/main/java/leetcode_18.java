import java.util.*;

public class leetcode_18 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        if(nums==null)
            return result;
        if(nums.length<3)
            return result;
        Arrays.parallelSort(nums);

        for(int i=0;i<nums.length-2;i++) {
            if(nums[i]>0) {
                break;
            }
            if(i>0) {
                if(nums[i]==nums[i-1])
                    continue;
            }
            /*在后面找出两个数和为-nums[i]的*/
            int l=i+1;int r=nums.length-1;
            while(l<r) {
                /*如果相等*/
                if(nums[l]+nums[r]==-nums[i]) {
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1]) {
                        l++;
                        if(l>nums.length-1)
                            break;
                    }
                    r--;
                    while(nums[r]==nums[r+1]) {
                        r--;
                        if(r<0)
                            break;
                    }
                }
                else if(nums[l]+nums[r]<-nums[i]) {
                    l++;
                    while(nums[l]==nums[l-1]) {
                        l++;
                        if(l>nums.length-1)
                            break;
                    }
                }
                else {
                    r--;
                    while(nums[r]==nums[r+1]) {
                        r--;
                        if(r<0)
                            break;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<List<Integer>>(Collections.emptyList());
        /*空的话直接返回，或者元素数量小于4*/
        if(nums==null||nums.length<4)
            return result;
        Arrays.parallelSort(nums);
        if(nums.length==4){
            if(target==nums[0]+nums[1]+nums[2]+nums[3]) {
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        }
        /*nb剪枝*/
        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];
        if (minValue > target || maxValue < target) {
            return result;
        }
        /**/
        for(int i=0;i<nums.length-3;i++){
            if(i>0){
                if(nums[i]==nums[i-1])
                    continue;
            }
            /*剩下的里面找出三个数字之和*/
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[j]==nums[j-1]&&j>i+1)
                    continue;
                int l=j+1;int r=nums.length-1;
                while(l<r){
                    if(nums[i]+nums[j]+nums[l]+nums[r]==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        while(nums[l]==nums[l-1]) {
                            l++;
                            if(l>nums.length-1)
                                break;
                        }
                        r--;
                        while(nums[r]==nums[r+1]) {
                            r--;
                            if(r<0)
                                break;
                        }
                    }
                    else if(nums[i]+nums[j]+nums[l]+nums[r]<target){
                        l++;
                        while(nums[l]==nums[l-1]) {
                            l++;
                            if(l>nums.length-1)
                                break;
                        }
                    }
                    else{
                        r--;
                        while(nums[r]==nums[r+1]) {
                            r--;
                            if(r<0)
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(fourSum(new int[] {-1,0,1,2,-1,-4},-1));
    }
}
