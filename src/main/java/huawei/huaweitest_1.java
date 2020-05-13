package huawei;

import java.util.Scanner;

public class huaweitest_1 {

    public static void IO(){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int n=in.nextInt();
            if(n==0)
                break;
            int count=0;
            while(n>=3){
                count+=n/3;
                n=n%3+n/3;
            }
            if(n==2)
                count++;
            System.out.println(count);
        }
    }



    public static void main(String[] args) {
        IO();
    }
}
