package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class huaweitest_3 {
    static Map<Character,Integer> map;
    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.next();
            StringBuilder sb=new StringBuilder();
            int res=0;
            for(int i=2;i<str.length();i++){
                res=res*16;
                res+=map.get(str.charAt(i));
            }
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        map=new HashMap<>();
        Character[] charMap=new Character[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        for(int i=0;i<charMap.length;i++){
            map.put(charMap[i],i);
        }
        IO();
    }
}
