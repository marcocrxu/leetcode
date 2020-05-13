package huawei;

import java.util.*;

public class huaweitest_2 {

    public static void IO(){
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            List<Integer> list=new ArrayList<>();
            Map<Integer, Boolean> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int x=scanner.nextInt();
                if(!map.containsKey(x)){
                    map.put(x,true);
                    list.add(x);
                }
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
