import java.util.*;

public class MeituanTest {
    static int n;
    static int m;
    static int[][] graph;

    public static int OldPeopleNum(){
        Map<Integer, Boolean> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        boolean new_add=true;
        queue.add(0);
        int count=0;
        map.put(0,true);
        while(new_add&&!queue.isEmpty()){
            new_add=false;
            int x=queue.poll();
            for(int j=0;j<n;j++){
                if(graph[x][j]==1&&!map.containsKey(j)){
                    map.put(j,true);
                    queue.add(j);
                    new_add=true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void IO(){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNextInt()){
            n=cin.nextInt();
            m=cin.nextInt();
            graph=new int[n][n];
            for(int i=0;i<m;i++){
                int a=cin.nextInt();
                int b=cin.nextInt();
                int c=cin.nextInt();
                graph[a-1][b-1]=c;
                graph[b-1][a-1]=c;
            }
            System.out.println(OldPeopleNum());
        }
    }


    public static void main(String[] args) {
        IO();
    }
}
