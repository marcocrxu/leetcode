import java.util.Arrays;

public class leetcode_44 {
    public static boolean judge(char x,char y){
        return x==y||y=='?'||y=='*';
    }

    public static boolean isMatch(String s, String p) {
        if(p.equals("")) {
            return s.equals("");
        }
        int x=p.length();
        if(s.equals("")) {
            for(int i=0;i<x;i++) {
                if(p.charAt(i)!='*')
                    return false;
            }
            return true;
        }
        if (p.equals("*") || s.equals(p)) {
            return true;
        }
        /*存储字母*/
        char[] a=new char[x];
        int y=s.length();
        boolean[][] sheet=new boolean[x][y];
        //初始化数组
        sheet[0][0]=judge(s.charAt(0),p.charAt(0));
        if(p.charAt(0)=='*'){
            for(int i=0;i<y;i++){
                sheet[0][i]=true;
            }
        }
        else {
            for(int i=1;i<y;i++){
                sheet[0][i]=false;
            }
        }
        boolean allOk=p.charAt(0)=='*';
        for(int i=1;i<x;i++){
            if(allOk&&judge(s.charAt(0),p.charAt(i)))
                sheet[i][0] = true;
            else if(sheet[i-1][0]&&p.charAt(i)=='*')
                sheet[i][0]=true;
            else
                sheet[i][0]=false;
            allOk&=p.charAt(i)=='*';
        }

        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(sheet[i-1][j-1]&&judge(s.charAt(j),p.charAt(i)))
                    sheet[i][j]=true;
                else if(sheet[i-1][j]&&p.charAt(i)=='*')
                    sheet[i][j]=true;
                else if(sheet[i][j-1]&&p.charAt(i)=='*')
                    sheet[i][j]=true;
                else
                    sheet[i][j]=false;
            }
        }
        return sheet[x-1][y-1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","a*"));
    }
}
