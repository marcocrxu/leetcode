public class leetcode_67 {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (c == 0)
                    res.insert(0, '0');
                else
                    res.insert(0, '1');
                c = 1;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                res.insert(0, c);
                c = 0;
            } else {
                if (c == 0) {
                    res.insert(0, 1);
                } else {
                    res.insert(0, 0);
                }
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while(i>=0){
                if(c==1&&a.charAt(i)=='1'){
                    res.insert(0,0);
                }else if(c==0&&a.charAt(i)=='0'){
                    res.insert(0,0);
                }else{
                    res.insert(0,1);
                    c=0;
                }
                i--;
            }
        } else if (j >= 0) {
            while(j>=0){
                if(c==1&&b.charAt(j)=='1'){
                    res.insert(0,0);
                }else if(c==0&&b.charAt(j)=='0'){
                    res.insert(0,0);
                }else{
                    res.insert(0,1);
                    c=0;
                }
                j--;
            }
        }
        if(c==1)
            res.insert(0,1);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
