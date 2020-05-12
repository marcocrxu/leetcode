package meituan;

import java.util.Scanner;

public class Meituan2 {

    public static int cacu(int x,int y){
        int z=x^y;
        int temp=1;
        int count=0;
        for(;z>0;z=z>>1){
            if(z%2==1)
                count++;
        }
        return count;
    }


    public static int MaxHaiMing(int n,int[] num){
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++) {
                int x=cacu(num[i], num[j]);
                if (x>max)
                    max=x;
            }
        }
        return max;
    }

    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            int[] num=new int[n];
            for(int i=0;i<n;i++) {
                num[i] = scanner.nextInt();
            }
            if(n==1)
                System.out.println(0);
            else{
                System.out.println(MaxHaiMing(n,num));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(cacu(10000,7));
        IO();

    }
}
