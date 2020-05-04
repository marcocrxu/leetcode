import java.util.*;

public class leetcode_22 {
    static List<String> result;
    public static List<String> generateParenthesis(int n) {
        if(n==0)
            return null;
        result= Collections.emptyList();
        result = new ArrayList(result);
        StringBuilder sb=new StringBuilder();
        int count=0;
        generate(sb,n,0);
        Collections.reverse(result);
        return result;
    }
    public static void generate(StringBuilder sb,int n,int count){
        if(sb.length()==2*n)
            result.add(sb.toString());
        else{
            if(count*2>sb.length()){
                sb.append(")");
                generate(sb,n,count);
                sb.delete(sb.length()-1,sb.length());
            }
            if(count<n) {
                sb.append("(");
                count++;
                generate(sb, n, count);
                sb.delete(sb.length()-1,sb.length());
            }
        }
    }

    public static void main(String[] args){
        List<String> res=generateParenthesis(3);
        System.out.println(000);
    }
}
