import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    static List<List<Integer>> res;
    public static void dfs(List<Integer> tempResult,int n,int k,int l) {
        //����l+1��������l+1
        //ֻ�е�������㹻����ʱ�ſ��Բ�����k
        if(tempResult.size()==k){
            List<Integer> needToAdd=new ArrayList<Integer>(tempResult);
            res.add(needToAdd);
            return;
        }
        if(l>=n)
            return;
        if (n-l>=k-tempResult.size()){
            dfs(tempResult,n,k,l+1);
        }
        tempResult.add(l+1);
        dfs(tempResult,n,k,l+1);
        tempResult.remove(tempResult.indexOf(l+1));
    }

    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> tempResult=new ArrayList<>();
        dfs(tempResult,n,k,0);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res=combine(4,3);
        System.out.println(res);
    }
}
