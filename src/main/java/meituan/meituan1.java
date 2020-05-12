package meituan;

import java.util.*;

public class meituan1 {

    public static int GoodScoreNum(int n,int m,int[][] score){
        Map<Integer,Boolean> map=new HashMap<>();
        int count=0;
        for(int i=0;i<m;i++){
            int max=0;
            List<Integer> Student=new ArrayList<>();
            for(int j=0;j<m;j++){
                if(score[j][i]>score[max][i]){
                    max=j;
                    Student.clear();
                    Student.add(j);
                }
                else if(score[j][i]==score[max][i]){
                    Student.add(j);
                }
            }
            for(Integer temp:Student) {
                if (!map.containsKey(temp)) {
                    map.put(temp, true);
                    count++;
                }
            }
        }
        return count;
    }


    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[][] score=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    score[i][j]=scanner.nextInt();
                }
            }
            System.out.println(GoodScoreNum(n,m,score));
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
