import java.util.*;
public class leetcode_466 {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count1=0;
        int count2=0;
        int index1=0;
        int index2=0;
        int len1=s1.length();
        int len2=s2.length();
        List<Integer> perAdd=new ArrayList<>();
        perAdd.add(0);
        while (count1<n1){
            if(s1.charAt(index1)==s2.charAt(index2)){
                index1++;
                index2++;
            }
            else
                index1++;
            if(index2%len2==0&&index1%len1==0)
                break;
            if(index1>=len1) {
                perAdd.add(count2);
                count1++;
                index1=0;
            }
            if(index2>=len2){
                count2++;
                index2=0;
            }
        }
        return ((n1/(count1+1))*(count2+1))/n2+perAdd.get(n1%(count1+1));
    }

    public static void main(String[] args){
        System.out.println(getMaxRepetitions("niconiconi",99981,"nico",81));
    }

}
