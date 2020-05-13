import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.Comparator;

public class twoCity {
    int min=Integer.MAX_VALUE;
    public void dfs(int[][] costs,int n,int k,int cost,int ACount){
        if(k==2*n){
            if(cost<min)
                min=cost;
        }
        else{
            if(n-ACount<2*n-k){
                dfs(costs,n,k+1,cost+costs[k][1],ACount);
            }
            if(ACount<n) {
                dfs(costs, n, k + 1, cost + costs[k][0], ACount + 1);
            }
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]-o1[1])-(o2[0]-o2[1]);
            }
        });
        int count=0;
        for(int i=0;i<costs.length/2;i++){
            count+=costs[i][0];
        }
        for(int i=costs.length/2;i<costs.length;i++){
            count+=costs[i][1];
        }
        return count;
    }
}
