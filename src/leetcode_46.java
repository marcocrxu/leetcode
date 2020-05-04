import java.util.*;

public class leetcode_46 {
    public static void swap(List<Integer> list,int x,int y){
        int temp=list.get(x);
        list.set(x,list.get(y));
        list.set(y,temp);
    }
    static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> ori=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            ori.add(nums[j]);
        }
        permute(ori,0,nums.length);
        return res;
    }

    public static void permute(List<Integer> origin,int k,int n) {
        if (k==n-1) {
            res.add(new ArrayList<>(origin));
        }
        for (int i = k; i < n; i++) {
            swap(origin,i,k);
            permute(origin,k+1,n);
            swap(origin,i,k);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res=permute(new int[]{1,2,3});
        System.out.println(0);
    }
}
