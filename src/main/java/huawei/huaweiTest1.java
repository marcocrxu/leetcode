package huawei;

import java.util.Scanner;

public class huaweiTest1 {
    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] score=new int[n];
            for(int i=0;i<n;i++){
                score[i]=scanner.nextInt();
            }
            for(int i=0;i<m;i++){
                char c=scanner.next().charAt(0);
                if(c=='U'){
                    int stu=scanner.nextInt();
                    int newScore=scanner.nextInt();
                    if(stu<=n)
                        score[stu-1]=newScore;
                }else{
                    int start=scanner.nextInt();
                    int end=scanner.nextInt();
                    if(end<start){
                        int temp=start;
                        start=end;
                        end=temp;
                    }
                    int max=Integer.MIN_VALUE;
                    for(int j=start-1;j<end;j++){
                        if(j<n&&score[j]>max)
                            max=score[j];
                    }
                    System.out.println(max);
                }
            }
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
