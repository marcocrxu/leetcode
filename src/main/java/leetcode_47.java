import java.util.*;

public class leetcode_47 {
    public static void swap(List<Integer> list,int x,int y){
        int temp=list.get(x);
        list.set(x,list.get(y));
        list.set(y,temp);
    }
    static List<List<Integer>> res=new ArrayList<>();
    public static void permute(List<Integer> origin,int k,int n) {
        if (k==n-1) {
            res.add(new ArrayList<>(origin));
        }
        Map<Integer,Boolean> map=new HashMap<>();
        for (int i = k; i < n; i++) {
            if(map.containsKey(origin.get(i)))
                continue;
            map.put(origin.get(i),true);
            swap(origin,i,k);
            permute(origin,k+1,n);
            swap(origin,i,k);
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ori=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            ori.add(nums[j]);
        }
        Map<Integer,Boolean> map=new HashMap<>();
        permute(ori,0,nums.length);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res=permuteUnique(new int[]{0,1,0,2});
        System.out.println(0);
    }
}
