import java.util.ArrayList;
import java.util.List;

public class leetcode_60 {
    public static String getPermutation(int n, int k) {
        StringBuilder res=new StringBuilder();
        int An=1;
        List<Character> dict=new ArrayList<>();
        dict.add('1');
        for(int i=1;i<n;i++){
            An*=i;
            dict.add((char)('1'+i));
        }
        k--;
        for(int i=0;i<n;i++){
            int temp=k/An;
            res.append(dict.get(temp));
            k-=temp*An;
            An=(i==n-1)?1:An/(n-i-1);
            dict.remove(temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
}
