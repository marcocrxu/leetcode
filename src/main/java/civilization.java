import java.util.*;
public class civilization {
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res=new int[requirements.length];
        Arrays.fill(res,-1);
        int c,r,h;
        c=0;r=0;h=0;
        for(int j=0;j<requirements.length;j++) {
            if (c >= requirements[j][0] && r >= requirements[j][1] && h >= requirements[j][2]) {
                res[j] = 0;
            }
        }
        Arrays.sort(requirements,(o1, o2) -> o1[0]-o2[0]);
        System.out.println(Arrays.deepToString(requirements));
        for(int i=0;i<increase.length;i++){
            c+=increase[i][0];
            r+=increase[i][1];
            h+=increase[i][2];
            for(int j=0;j<requirements.length;j++){
                if(requirements[j][0]>c)
                    break;
                if(res[j]==-1){
                    if(c>=requirements[j][0]&&r>=requirements[j][1]&&h>=requirements[j][2]){
                        res[j]=i+1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTriggerTime(ListNode.stringToInt2dArray("[[2,8,4],[2,5,0],[10,9,8]]"), ListNode.stringToInt2dArray("[[2,11,3],[15,10,7],[9,17,12],[8,1,14]]"))));
    }
}
