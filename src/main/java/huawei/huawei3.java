package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class huawei3 {

    public static int[] StringToIntegerArray(String str){
        String[] split=str.split(" ");
        int[] res=new int[split.length];
        for(int i=0;i<split.length;i++){
            res[i]=Integer.parseInt(split[i]);
        }
        return res;
    }

    public static boolean find(int[] num,int target){
        for(int temp:num) {
            if (temp == target) {
                return true;
            }
        }
        return false;
    }

    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=Integer.parseInt(scanner.nextLine());
            int b=Integer.parseInt(scanner.nextLine());
            //贪心
            //用来保存每本书的读的次数
            Map<Integer,Integer> map=new HashMap<>();
            int[] bookCount=new int[n];
            int[][] bookRecord=new int[b][];
            for(int i=0;i<b;i++){
                String str=scanner.nextLine();
                String[] split=str.split(" ");
                bookRecord[i]=new int[split.length];
                for(int j=0;j<split.length;j++){
                    bookRecord[i][j]=Integer.parseInt(split[j]);
                    map.put(bookRecord[i][j],map.getOrDefault(bookRecord[i][j],0)+1);
                }
            }
            //从最大的找起
            int count=0;
            int book=0;
            while(count<b) {
                Map.Entry<Integer,Integer> maxEntry=null;
                int max=0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue()>max){
                        max=entry.getValue();
                        maxEntry=entry;
                    }
                }
                if(maxEntry==null)
                    return;
                book++;
                map.remove(maxEntry.getKey());
                count+=max;
                for(int i=0;i<b;i++){
                    if(find(bookRecord[i],maxEntry.getKey())){
                        for(int j=0;j<bookRecord[i].length;j++){
                            if(bookRecord[i][j]!=maxEntry.getKey()&&map.containsKey(bookRecord[i][j]))
                                map.put(bookRecord[i][j],map.getOrDefault(bookRecord[i][j],0)-1);
                        }
                    }
                }
            }
            System.out.println(book);
        }

    }

    public static void main(String[] args) {
        IO();
    }
}
