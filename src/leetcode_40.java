import java.util.*;
public class leetcode_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        find(candidates,0,target,res,list);
        return res;
    }

    public static void find(int[] candidates,int start,int target,List<List<Integer>> res,List<Integer> list){
        if(target==0) {
            if(!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[start])
                continue;
            if(candidates[i]>target)
                break;
            list.add(candidates[i]);
            find(candidates,i+1,target-candidates[i],res,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> res=combinationSum2(ListNode.stringToIntegerArray("[10,1,2,7,6,1,5]"),8);
        System.out.println(0);
    }
}
