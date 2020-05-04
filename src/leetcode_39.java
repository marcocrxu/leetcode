import java.lang.reflect.Array;
import java.util.*;
public class leetcode_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        find(candidates,0,target,res,list);
        return res;
    }

    public static void find(int[] candidates,int start,int target,List<List<Integer>> res,List<Integer> list){
        if(target==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target)
                break;
            list.add(candidates[i]);
            find(candidates,i,target-candidates[i],res,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> res=combinationSum(ListNode.stringToIntegerArray("[7,3,9,6]"),6);
        System.out.println(0);
    }
}
