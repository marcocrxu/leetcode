import javax.print.DocFlavor;
import java.util.*;

public class leetcode_5406 {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int appleNum=0;
        List<Integer> apple=new ArrayList<>();
        for(int i=0;i<hasApple.size();i++){
            if(hasApple.get(i)) {
                apple.add(i);
                appleNum++;
            }
        }
        if(appleNum==0)
            return 0;
        int[] father=new int[n];
        Arrays.fill(father,-1);
        for(int i=0;i<edges.length;i++){
            father[edges[i][1]]=edges[i][0];
        }
        int count=0;
        Map<Integer,Boolean> onceGet=new HashMap<>();
        for(Integer temp:apple){
            if(temp!=0)
                onceGet.put(temp,true);
        }
        while(true) {
            List<Integer> curFarther=new ArrayList<>();
            for (Integer temp : apple) {
                if(temp==0) {
                    if(!curFarther.contains(temp))
                        curFarther.add(temp);
                    continue;
                }
                count+=2;
                if(onceGet.containsKey(father[temp]))
                    continue;
                if(!curFarther.contains(father[temp])){
                    curFarther.add(father[temp]);
                }

            }
            for(Integer temp:curFarther)
                if(temp!=0&&!onceGet.containsKey(temp))
                    onceGet.put(temp,true);
            apple=curFarther;

            if(curFarther.size()==1&&curFarther.get(0)==0)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minTime(6,new int[][]{new int[]{0,1},new int[]{0,2},new int[]{1,3},new int[]{3,4},new int[]{4,5}},new ArrayList<Boolean>(Arrays.asList(new Boolean[]{false,true,false,false,true,true}))));
    }
}
