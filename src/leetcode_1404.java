public class leetcode_1404 {
    public static int numSteps(String s) {
        if(s.equals("1"))
            return 0;
        if(s.charAt(s.length()-1)=='1'){
            /*奇数*/
            StringBuilder sb=new StringBuilder(s);
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)=='1') {
                    sb.replace(i, i + 1, "0");
                    if(i==0)
                        sb.insert(0,"1");
                }
                else{
                    sb.replace(i,i+1,"1");
                    break;
                }
            }
            return 1+numSteps(sb.toString());
        }
        else{
            /*偶数*/
            return 1+numSteps(s.substring(0,s.length()-1));
        }
    }

    public static void main(String[] args){
        System.out.println(numSteps("1101"));
    }

}
