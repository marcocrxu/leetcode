import java.util.ArrayList;
import java.util.List;

public class leetcode_5404 {
    public static List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int count=1;
        for(int i=0;i<target.length;i++){
            if(target[i]==count){
                res.add("Push");
                count++;
            }
            else{
                for(int j=count;j<target[i];j++){
                    res.add("Push");
                    res.add("Pop");
                }
                res.add("Push");
                count=target[i]+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res= buildArray(new int[]{2,3,4},4);
        for(String temp:res){
            System.out.print(temp+" ");
        }
    }
}
