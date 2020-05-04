import java.util.*;
public class civilization {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res=new int[requirements.length];
        Arrays.fill(res,-1);
        int c,r,h;
        c=0;r=0;h=0;
        for(int j=0;j<requirements.length;j++) {
            if (c >= requirements[j][0] && r >= requirements[j][1] && h >= requirements[j][2]) {
                res[j] = 0;
            }
        }
        for(int i=0;i<increase.length;i++){
            c+=increase[i][0];
            r+=increase[i][1];
            h+=increase[i][2];
            for(int j=0;j<requirements.length;j++){
                if(res[j]==-1){
                    if(c>=requirements[j][0]&&r>=requirements[j][1]&&h>=requirements[j][2]){
                        res[j]=i+1;
                    }
                }
            }
        }
        return res;
    }
}
