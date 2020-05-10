public class ways {
    static int count;
    public static int numWays(int n, int[][] relation, int k) {
        count=0;
        int now=0;
        dfs(n,relation,now,k);
        return count;
    }

    public static void dfs(int n,int[][] relations,int now,int k){
        if(k==0){
            if(now==n-1) {
                count++;
                return;
            }
            else{
                return;
            }
        }
        for(int i=0;i<relations.length;i++){
            if(relations[i][0]==now){
                k--;
                dfs(n,relations,relations[i][1],k);
                k++;
            }
        }

    }

    public static void main(String[] args){
        System.out.println(numWays(5,new int[][]{new int[]{0,2},new int[]{2,1},new int[]{3,4},new int[]{2,3},new int[]{1,4},new int[]{2,0},new int[]{0,4}},3));
    }

}
