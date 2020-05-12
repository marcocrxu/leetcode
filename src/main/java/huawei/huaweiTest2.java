package huawei;

import java.util.*;

public class huaweiTest2 {
    public static void IO() {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map=new HashMap<>();
        int outputLen=8;

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] split=s.split("\\\\");
            String str=split[split.length-1];
            int x=map.getOrDefault(str,0)+1;
            map.put(str,x);
        }
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()-o2.getValue())==0?o1.getValue()-o2.getValue():o2.getValue()-o1.getValue();
            }
        });
        int count=0;
        for(Map.Entry<String,Integer> temp:list){
            count++;
            if(count<=8)
                break;
            System.out.println(temp.getKey()+" "+temp.getValue());
        }

    }

    public static void main(String[] args) {
        IO();
    }
}
