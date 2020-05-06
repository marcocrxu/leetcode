import java.awt.event.InputEvent;
import java.io.*;

public class leetcode_65 {
    //×´Ì¬»ú
    public static boolean isNumber(String s) {
        int state=1;
        for(char c:s.toCharArray()){
            switch(state){
                case 1:{
                    if(c==' ')
                        break;
                    else if(c>='0'&&c<='9'){
                        state=2;
                        break;
                    }
                    else if(c=='+'||c=='-'){
                        state=9;
                        break;
                    }
                    else if(c=='.') {
                        state = 7;
                        break;
                    }
                    else
                        return false;
                }
                case 2:{
                    if(c=='.')
                        state=6;
                    else if(c>='0'&&c<='9') {
                        break;
                    }
                    else if(c=='e')
                        state=4;
                    else if(c==' ')
                        state=8;
                    else {
                        return false;
                    }
                    break;
                }
                case 3:{
                    if(c>='0'&&c<='9'){
                        break;
                    }
                    else if(c=='e'){
                        state=4;
                        break;
                    }
                    else if(c==' ') {
                        state = 8;
                        break;
                    }
                    else
                        return false;
                }
                case 4:{
                    if(c>='0'&&c<='9') {
                        state=5;
                        break;
                    }
                    else if(c=='+'||c=='-')
                        break;
                    else
                        return false;
                }
                case 5:{
                    if(c>='0'&&c<='9')
                        break;
                    else if(c==' ') {
                        state = 8;
                        break;
                    }
                    else
                        return false;
                }
                case 6: {
                    if (c >= '0' && c <= '9') {
                        state = 3;
                        break;
                    } else if (c == ' ') {
                        state = 8;
                        break;
                    }else if(c=='e') {
                        state = 4;
                        break;
                    }
                    else return false;
                }
                case 7:{
                    if(c>='0'&&c<='9') {
                        state = 3;
                        break;
                    }
                    else return false;
                }
                case 8:{
                    if(c==' ')
                        break;
                    else
                        return false;
                }
                case 9: {
                    if (c >= '0' && c <= '9') {
                        state = 2;
                        break;
                    }else if(c=='.'){
                        state=10;
                        break;
                    }
                    else return false;
                }
                case 10:{
                    if(c>='0'&&c<='9'){
                        state=3;
                        break;
                    }
                    else if(c=='e'){
                        state=4;
                        break;
                    }
                    else if(c==' ') {
                        state = 8;
                        break;
                    }
                    else
                        return false;
                }
            }
        }
        return state != 7 && state != 4 && state != 1 && state != 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            boolean ret = isNumber(line);
            System.out.println(ret);
        }

    }
}
