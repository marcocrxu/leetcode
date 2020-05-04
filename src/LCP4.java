import java.util.*;

public class LCP4 {
    int n;
    int m;
    static boolean[] used;
    static int[] black;
    static Vector<Integer> left;
    static Vector<Integer> right;
    public static int domino(int n, int m, int[][] broken) {
        //和为偶数在左边,和为奇数在右边
        //一共有m*n个，
        int rNum=m*n/2;
        int lNum=m*n-rNum;
        left=new Vector<Integer>();
        right=new Vector<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i+j)%2==0)
                    left.add(i*m+j);
                else
                    right.add(i*m+j);
            }
        }
        if(broken!=null) {
            for (int[] temp : broken) {
                if ((temp[0] + temp[1]) % 2 == 0) {
                    lNum--;
                    left.remove(left.indexOf(temp[0] * m + temp[1]));
                } else {
                    rNum--;
                    right.remove(right.indexOf(temp[0] * m + temp[1]));
                }
            }
        }
        int count=0;
        used=new boolean[n*m];
        black=new int[n*m];
        Arrays.fill(black,-1);
        for(int i=0;i<left.size();i++){
            Arrays.fill(used,false);
            if(find(left.elementAt(i),n,m)){
                count++;
            }
        }
        return count;
    }

    public static boolean find(int x, int n, int m){
        //能不能给x号格子找到一个配对的格子
        Vector<Integer> next=new Vector<Integer>();
        if(x-m>=0&&right.contains(x-m))
            next.add(x-m);
        if(x+m<m*n&&right.contains(x+m))
            next.add(x+m);
        if(x%m!=0&&right.contains(x-1))
            next.add(x-1);
        if(x%m!=m-1&&right.contains(x+1))
            next.add(x+1);
        for(int temp:next){
            if(!used[temp]){
                used[temp]=true;
                if(black[temp]==-1||find(black[temp],n,m)){
                    black[temp]=x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(domino(8,8,new int[][]{new int[]{0,1},new int[]{2,0},new int[]{4,3},new int[]{4,7},new int[]{5,4}}));
    }

}
