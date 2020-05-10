public class check_Record {
    public static boolean checkRecord(String s) {
        //上一次迟到为真
        int l_count=0;
        boolean l_no_award=false;
        boolean late_no_award=false;
        int ACount=0;
        for(char c:s.toCharArray()){
            if(c=='A') {
                late_no_award = true;
                ACount++;
                l_count=0;
                if(ACount>=2)
                    return false;
            }
            else if(c=='L'){
                l_count++;
                if(l_count>=3)
                    return false;
                else if(l_count==3){
                    l_no_award=true;
                }
            }
            else{
                l_count=0;
            }
        }
        return !(l_no_award&late_no_award);
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALL"));
    }
}
