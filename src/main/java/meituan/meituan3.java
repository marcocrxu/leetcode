package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class meituan3 {
    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            Map<Integer, Boolean> map=new HashMap<>();
            for(int i=0;i<m;i++){
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                scanner.hasNextLine();
                scanner.nextLine();
                if(x==1){
                    map.put(y,false);
                }else {
                    if (map.containsKey(y)) {
                        if (y >= n)
                            System.out.println(-1);
                        else{
                            boolean find=false;
                            for(int j=y+1;j<=n;j++){
                                if(!map.containsKey(j)){
                                    find=true;
                                    System.out.println(j);
                                    break;
                                }
                            }
                            if(!find)
                                System.out.println(-1);
                        }
                    } else {
                        if(y>n)
                            System.out.println(-1);
                        else
                            System.out.println(y);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        IO();
    }
}
