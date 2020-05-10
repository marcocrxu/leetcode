public class leetcode_38 {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String res=countAndSay(n-1);

        StringBuilder sb=new StringBuilder(res);
        sb.append((char)-1);
        res=sb.toString();
        sb=new StringBuilder();
        int count=1;
        for(int i=1;i<res.length();i++){
            if(res.charAt(i)!=res.charAt(i-1)){
                sb.append((char)(count+48));
                sb.append(res.charAt(i-1));
                count=1;
            }
            else{
                count++;
            }
        }
        return sb.toString();
    }
}
