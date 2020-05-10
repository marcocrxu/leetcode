import java.util.*;
public class leetcode_43 {
    public static String multi(String x,int n){
        StringBuilder sb=new StringBuilder();
        int c=0;//进位
        for(int i= x.length()-1;i>=0;i--){
            int temp=x.charAt(i)-'0';
            if(temp==0) {
                sb.insert(0, c);
                c=0;
            }
            else{
                int temp_c=(temp*n+c)/10;
                sb.insert(0,(temp*n+c)%10);
                c=temp_c;
            }
        }
        if(c!=0)
            sb.insert(0,c);
        return sb.toString();
    }

    public static String add2String(String x,String y){
        StringBuilder sb=new StringBuilder();
        int c=0;//进位
        int len1=x.length();
        int len2=y.length();
        for(int i=1;i<=len1;i++){
            if(len2-i>=0){
                int temp=x.charAt(len1-i)-'0'+y.charAt(len2-i)-'0'+c;
                sb.insert(0,temp%10);
                c=temp/10;
            }
            else{
                sb.insert(0,((x.charAt(len1-i)-'0')+c)%10);
                c=(x.charAt(len1-i)-'0'+c)/10;
            }
        }
        if(len2>len1){
            sb.insert(0,y.substring(0,len2-len1));
        }
        if(c!=0)
            sb.insert(0,c);
        return sb.toString();
    }

    public static String multiply(String num1, String num2) {
        String res="";
        int len1=num1.length();
        int len2=num2.length();
        String[] dp=new String[9];
        boolean[] ready=new boolean[9];
        Arrays.fill(ready,false);
        for(int i=0;i<len2;i++){
            int temp=num2.charAt(i)-'0';
            if(temp!=0){
                //为0跳过
                if(ready[temp-1]){
                    if(!res.equals("0"))
                        res=res+'0';
                    res=add2String(res,dp[temp-1]);
                }
                else{
                    ready[temp-1]=true;
                    dp[temp-1]=multi(num1,temp);
                    if(!res.equals("0"))
                        res=res+'0';
                    res=add2String(res,dp[temp-1]);
                }
            }
            else{
                if(!res.equals("0"))
                    res=res+'0';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiply("721","140"));
    }
}
