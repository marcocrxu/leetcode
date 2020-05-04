import java.util.*;
public class PalindromicSubsequences {
    public static final int MAX=1000000007;
    public static int countPalindromicSubsequences(String S) {
        if(S.length()<=2)
            return S.length();
        int len=S.length();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],0);
        }
        //任意一个字符永远都是1个回文串
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        //任意两个字符永远都是2个回文串
        for(int i=0;i<len-1;i++){
            dp[i][i+1]=2;
        }
        //记录某一个字符第一次出现的位置
        Map<Character,Integer> map=new HashMap<>();
        map.put(S.charAt(0),0);
        if(S.charAt(0)!=S.charAt(1)){
            map.put(S.charAt(1),1);
        }
        for(int i=2;i<len;i++){
            for(int j=0;j<len-i;j++){
                /*
                *判断这个字符有没有在之前出现过
                *没出现过就+1
                * 出现过找出第一次出现的位置
                * */
                if(S.charAt(j+i)==S.charAt(j+i-1)){
                    dp[j][j+i]=dp[j][j+i-1]+1;
                    continue;
                }

                boolean find=false;
                int k=j;
                for(k=j;k<j+i;k++){
                    if(S.charAt(k)==S.charAt(i+j)) {
                        find=true;
                        break;
                    }
                }
                if(find){
                    if(k+1==j+i){
                        dp[j][j+i]=(dp[j][j+i-1]+1)%MAX;
                    }
                    else{
                        int l=0;
                        for(l=j+i-1;l>j;l--){
                            if(S.charAt(l)==S.charAt(j+i)) {
                                break;
                            }
                        }
                        int count=0;
                        if(l!=0){
                            count=dp[j+1][l];
                            if(S.substring(j+1,l+1).length()>0&&isPalindromic(S.substring(j+1,l+1))){
                                count--;
                            }
                        }
                        dp[j][j+i]=(dp[j][j+i-1]+1+dp[k+1][j+i-1]-count)%MAX;
                    }
                }
                else{
                    dp[j][j+i]=(dp[j][j+i-1]+1)%MAX;
                }
            }
        }
        return dp[0][len-1];
    }

    public static boolean isPalindromic(String s){
        int i=0;int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(countPalindromicSubsequences("aaba"));
    }
}
