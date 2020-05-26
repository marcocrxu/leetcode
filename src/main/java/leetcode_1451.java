import java.util.Arrays;
import java.util.Comparator;

public class leetcode_1451 {
    public static String arrangeWords(String text) {
        String[] split=text.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuilder sb=new StringBuilder();
        for(String temp:split){

            sb.append(temp);
            if(temp.charAt(0)>='A'&&temp.charAt(0)<='Z')
                sb.setCharAt(sb.length()-temp.length(),(char) (temp.charAt(0)+32));
            sb.append(" ");
        }
        sb.replace(sb.length()-1,sb.length(),"");
        sb.setCharAt(0,(char)(sb.charAt(0)-32));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool"));
    }
}
