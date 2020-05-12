import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode_76 {
    public static boolean containTString(Map<Character,Integer> map){
        for(Integer val:map.values()){
            if(val>0)
                return false;
        }
        return true;
    }


    public static String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        if(s.equals(t))
            return s;
        int start=0;
        int end=s.length();
        int temp_start=0;
        int temp_end=1;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> countMap=new HashMap<>();
        int count=0;
        boolean find=false;
        boolean firstIn=true;
        for(temp_end=1;temp_end<=s.length();temp_end++){
            //如果这个字符出现在t里面
            if(map.containsKey(s.charAt(temp_end-1))) {
                int CurCharSpareNum = map.get(s.charAt(temp_end-1)) - 1;
                if (CurCharSpareNum >= 0) {
                    if(firstIn){
                        temp_start=temp_end-1;
                        firstIn=false;
                    }
                    map.put(s.charAt(temp_end-1), map.get(s.charAt(temp_end-1)) - 1);
                    count++;
                    //如果已经查到了t的所有字母
                    if (containTString(map)) {
                        find=true;
                        if (temp_end - temp_start <= end - start) {
                            end = temp_end;
                            start = temp_start;
                        }
                    }
                } else {
                    /*如果找到的这个字符在前面已经出现过*/
                    if(s.charAt(temp_start)==s.charAt(temp_end-1)){
                        temp_start++;
                        for(;temp_start<temp_end;temp_start++){
                            if(map.containsKey(s.charAt(temp_start))){
                                if(map.get(s.charAt(temp_start))>=0)
                                    break;
                                else
                                    map.put(s.charAt(temp_start),map.get(s.charAt(temp_start))+1);
                                count--;
                            }
                        }
                        if(containTString(map)){
                            if(temp_end-temp_start<end-start){
                                end=temp_end;
                                start=temp_start;
                            }
                        }
                    }else{
                        map.put(s.charAt(temp_end-1), map.get(s.charAt(temp_end-1)) - 1);
                        count++;
                    }
                }
            }
        }
        return !find?"":s.substring(start,end);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd","abcdd"));
    }
}
