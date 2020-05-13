import java.util.Arrays;

public class OneToNine {

    public static void swap(int[] num, int i, int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public static boolean Equal(int[] num){
        if(num[0]*(num[1]*10+num[2])==(num[3]*100+num[4]*10+num[5])&&(num[3]*100+num[4]*10+num[5])==num[8]*(num[6]*10+num[7]))
            return true;
        return false;
    }

    public static void dfs(int[] num, int n, int k){
        if(k==9) {
            if (Equal(num))
                System.out.println(Arrays.toString(num));
            return;
        }
        for(int i=k;i<n;i++){
            swap(num,i,k);
            dfs(num,n,k+1);
            swap(num,i,k);
        }
    }

    public static void main(String[] args) {
        int[] num=new int[9];
        for(int i=0;i<9;i++)
            num[i]=i+1;
        dfs(num,9,0);
    }
}
