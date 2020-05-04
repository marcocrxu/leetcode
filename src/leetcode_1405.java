public class leetcode_1405 {
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();
        int x,y;
        x=0;y=0;
        while(a>0||b>0||c>0){
            if(a>b&&a>c){
                /*a is max*/
                if(x==1&&y==1){
                    if(b>c){
                        if(b>0) {
                            b--;
                            y = x;
                            x = 2;
                            sb.append('b');
                        }
                        else{
                            break;
                        }
                    }
                    else {
                        if(c<=0)
                            break;
                        c--;
                        y=x;x=3;
                        sb.append('c');
                    }
                }
                else{
                    if(a<=0)
                        break;
                    a--;
                    sb.append('a');
                    y=x;x=1;
                }
            }
            else if(b>c){
                /*b is max*/
                if(x==2&&y==2){
                    if(a>c){
                        if(a<=0)
                            break;
                        a--;
                        y=x;
                        x=1;
                        sb.append('a');
                    }
                    else {
                        if(c<=0)
                            break;
                        c--;
                        y=x;
                        x=3;
                        sb.append('c');
                    }
                }
                else{
                    if(b<=0)
                        break;
                    b--;
                    sb.append('b');
                    y=x;
                    x=2;
                }
            }
            else{
                /*c is max*/
                if(x==3&&y==3){
                    if(b>a){
                        if(b<=0)
                            break;
                        b--;
                        y=x;x=2;
                        sb.append('b');
                    }
                    else {
                        if(a<=0)
                            break;
                        a--;
                        y=x;x=1;
                        sb.append('a');
                    }
                }
                else{
                    if(c<=0)
                        break;
                    c--;
                    sb.append('c');
                    y=x;x=3;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(longestDiverseString(1,1,7));
    }

}
