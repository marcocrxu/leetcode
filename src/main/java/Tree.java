import java.util.*;

public class Tree {
    static int[] frontOrder;
    static int[] midOrder;
    static Map<Integer,Integer> frontMap;
    static Map<Integer,Integer> midMap;
    static Queue<Integer> queue;
    static int[] fatherPoint;

    public static int[] getPerFloor(int n){
        int[] res=new int[n];
        queue.add(frontOrder[0]);
        int count=0;
        while(!queue.isEmpty()){
            res[count]=queue.poll();
            //找出res[count]的两个子节点并且添加到queue里面
            int x=frontMap.get(res[count])+1;
            if(x>=n) {
                count++;
                continue;
            }
            if(midMap.get(frontOrder[x])<midMap.get(frontOrder[x-1])){
                queue.add(frontOrder[x]);
                fatherPoint[x]=midMap.get(res[count]);
            }
            //找到右节点
            //在frontMap.get(res[count])])后找到一个frontOrder在其之后并且midOrder也在其之后的，搜索范围不能超过其父亲节点
            //用二分搜索
            int start=x;
            int end=fatherPoint[frontMap.get(res[count])];
            while(start<end){
                int mid=(start+end)/2;
                if(midMap.get(frontOrder[mid])<midMap.get(res[count])){
                    start=mid+1;
                }
                else
                    end=mid-1;
            }
            System.out.println(start+" "+end);
            if(start>x&&start<=fatherPoint[frontMap.get(res[count])])
                queue.add(frontOrder[start]);
            fatherPoint[end]=fatherPoint[frontMap.get(res[count])];
            count++;
        }
        return res;
    }

    public static void IO(){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNextInt()){
            int n=cin.nextInt();
            frontOrder=new int[n];
            midOrder=new int[n];
            frontMap=new HashMap<>();
            midMap=new HashMap<>();
            fatherPoint=new int[n];
            for(int i=0;i<n;i++){
                frontOrder[i]=cin.nextInt();
                frontMap.put(frontOrder[i],i);
            }
            for(int i=0;i<n;i++){
                midOrder[i]=cin.nextInt();
                midMap.put(midOrder[i],i);
            }
            queue=new LinkedList<>();
            fatherPoint[0]=n;
            System.out.println(Arrays.toString(getPerFloor(n)));
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
