import java.util.*;
public class leetcode_28 {
    //KMP算法
    public static int strStr(String haystack, String needle) {
        int len=haystack.length();int needle_len=needle.length();
        if(needle_len==0){
            return 0;
        }
        if(len==0)
            return -1;
        if(needle_len>len)
            return -1;
        int[] pmt=new int[needle_len];
        //构造pmt表
        pmt[0]=0;
        int i,j;
        for(i=1;i<pmt.length;i++){
            String sub=needle.substring(0,i+1);
            for(j=i;j>=0;j--){
                if(sub.substring(0,j).equals(sub.substring(i+1-j,i+1))){
                    pmt[i]=j;
                    break;
                }
            }
        }
        //pmt表构造完之后开始遍历
        i=0;j=0;
        for(i=0;i<len-needle_len+1;i++){
            while(j<needle_len){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    j++;
                    if(j==needle_len)
                        return i;
                }
                else{
                    if(j==0)
                        break;
                    i+=j-pmt[j-1]-1;
                    j=pmt[j-1];
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(strStr("aaaaa","bba"));
    }
}
