package ali;

import java.io.InputStreamReader;
import java.util.*;
public class ali_1 {
    public static int[] avoid(int n){
        if(n==1){
            return new int[]{1};
        }
        else if(n==2)
            return new int[]{1,2};
        List<Integer> res=new ArrayList<>(Collections.emptyList());
        res.add(1);res.add(2);
        boolean fir=true;
        int count=0;
        for(int i=3;i<=n;i++){
            if((count/2)%2==0){
                count++;
                res.add(0,i);
            }
            else{
                count++;
                res.add(i);
            }
        }
        int []result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=res.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(9);
        int[] res=avoid(20);
        for(int i=0;i<20;){
            System.out.print(res[i]+" ");
            i++;
        }
    }

}
