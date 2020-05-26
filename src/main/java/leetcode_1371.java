import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_1371 {
    public static boolean isYuanYin(Character c){
        return c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u');
    }

    public static int findTheLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        Map<Character,Integer> bitsMap=new HashMap<>();
        //a i e u o
        for(int i=0;i<26;i++){
            bitsMap.put((char)('a'+i),0);
        }
        bitsMap.put('a', 1);
        bitsMap.put('i',1<<1);
        bitsMap.put('e',1<<2);
        bitsMap.put('u',1<<3);
        bitsMap.put('o',1<<4);
        int[] bits=new int[s.length()+1];
        bits[0]= 0;
        for(int i=1;i<s.length()+1;i++){
            bits[i]=bits[i-1]^ bitsMap.get(s.charAt(i-1));
        }
        System.out.println(Arrays.toString(bits));
        if(bits[s.length()]==0)
            return s.length();
        for(int i=s.length();i>=0;i--){
            for(int j=0;j<s.length()-i+1;j++){
                if((bits[j]^bits[j+i])==0)
                    return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }
}
