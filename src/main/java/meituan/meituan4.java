package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class meituan4 {
    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            int[] num=new int[n];

            for(int i=0;i<n;i++) {
                num[i] = scanner.nextInt();
            }
            if(n==0) {
                System.out.println();
                continue;
            }
            int[] res=new int[n];
            int[][] cacu=new int[n][n];
            for(int i=0;i<n;i++){
                if(res[i]==0){
                    boolean find=false;
                    for(int j=0;j<n;j++){
                        if(cacu[i][j]==0) {
                            if ((num[i] & num[j]) == 0) {
                                res[j] = 1;
                                res[i] = 1;
                                find = true;
                                break;
                            } else {
                                cacu[i][j] = 1;
                                cacu[j][i] = 1;
                            }
                        }
                    }
                    if(!find){
                        res[i]=-1;
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
