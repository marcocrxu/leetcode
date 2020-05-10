import java.util.Collections;
import java.util.*;
public class LCP2 {
    public static int[] fraction(int[] cont) {
        return fract(cont,0,cont.length);
    }

    public static int[] fract(int[] cont, int start, int end){
        if(start+1==end){
            return new int[]{cont[start],1};
        }
        int[] res=fract(cont,start+1,end);
        int temp=res[0];
        res[0]=res[1];
        res[1]=temp;
        res[0]+=cont[start]*res[1];
        return res;
    }

    public static void main(String[] args){
        int[] res=fraction(new int[]{3,2,0,2});
        System.out.println(000);
    }
}
