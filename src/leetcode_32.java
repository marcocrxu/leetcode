import java.lang.reflect.Array;
        import java.util.Arrays;

public class leetcode_32 {
    public static int longestValidParentheses(String s) {
        int len=s.length();
        if(len<=1)
            return 0;
        int max=0;
        int leftNum=0;
        int count=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                leftNum++;
                count++;
            }
            else{
                if(leftNum<=0){
                    if(count>max)
                        max=count;
                    leftNum=0;
                    count=0;
                }
                else{
                    count++;
                    leftNum--;
                    if(leftNum==0&&max<count){
                        max=count;
                    }
                }
            }
        }
        leftNum=0;
        count=0;
        int max2=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==')'){
                leftNum++;
                count++;
            }
            else{
                if(leftNum<=0){
                    if(count>max2)
                        max2=count;
                    leftNum=0;
                    count=0;
                }
                else{
                    count++;
                    leftNum--;
                    if(leftNum==0&&max2<count){
                        max2=count;
                    }
                }
            }
        }
        return Math.max(max,max2);
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("(()))())("));
    }
}
