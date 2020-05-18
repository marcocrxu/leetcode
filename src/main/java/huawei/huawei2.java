package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class huawei2 {

    public static int[] StringToIntegerArray(String str){
        String[] split=str.split(",");
        int[] res=new int[split.length];
        for(int i=0;i<split.length;i++){
            res[i]=Integer.parseInt(split[i]);
        }
        return res;
    }

    public static void IO(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String busString=scanner.nextLine();
            String lightString=scanner.nextLine();
            int[] bus=StringToIntegerArray(busString);
            int[] light=StringToIntegerArray(lightString);
            Arrays.sort(bus);
            Arrays.sort(light);
            int[] newLight=new int[light.length+2];
            newLight[0]=Integer.MIN_VALUE;
            newLight[newLight.length-1]=Integer.MAX_VALUE;
            for(int i=1;i<newLight.length-1;i++){
                newLight[i]=light[i-1];
            }
            int min=Integer.MIN_VALUE;
            for(int temp:bus){
                int index=lowerBound(newLight,0,newLight.length,temp);
                int x=Math.min(Math.abs(temp-newLight[index-1]),Math.abs(newLight[index]-temp));
                if(x>min)
                    min=x;
            }
            System.out.println(min);
        }
    }

    public static int lowerBound(int []nums,int l,int r,int target){
        while(l<r){
            int m = (l+r)/2;
            if(nums[m]>=target) r= m;
            else    l = m +1;
        }
        return l;

    }
    public static void main(String[] args) {
        IO();
    }
}
