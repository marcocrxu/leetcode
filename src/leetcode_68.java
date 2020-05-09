import java.util.ArrayList;
import java.util.List;

public class leetcode_68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        if(words.length==0)
            return res;
        //curlen refers to the length of current line
        int curlen=-1;
        //pre refers to last word index
        int pre=0;
        for(int i=0;i<words.length;i++){
            if(curlen+words[i].length()>=maxWidth){
                //insert into more space
                //this line include word[pre] to word[i]
                //do not include word[i] but include word[pre]
                //spaceLen refers to the space you need to insert into words
                int spaceLen=maxWidth-curlen;
                int intervalNum=(i-pre-1)==0?1:i-pre-1;
                int perLen=spaceLen/intervalNum;
                int spareSpace=spaceLen%intervalNum;
                //start to insert space
                StringBuilder str=new StringBuilder();
                StringBuilder space=new StringBuilder();
                for(int k=0;k<perLen+1;k++){
                    space.append(" ");
                }
                System.out.println(spaceLen+" "+intervalNum+" "+perLen);
                str.append(words[pre]);
                for(int j=pre+1;j<i;j++){
                    str.append(space.toString());
                    if(j-pre<=spareSpace){
                        str.append(" ");
                    }
                    str.append(words[j]);
                }
                for(int k=str.length();k<maxWidth;k++){
                    str.append(" ");
                }
                res.add(str.toString());
                str=new StringBuilder();
                pre=i;
                curlen=words[i].length();
            }else{
                curlen+=(1+words[i].length());
            }

        }
        //if the array do not end
        if(pre<words.length){
            StringBuilder sb=new StringBuilder();
            sb.append(words[pre]);
            for(int i=pre+1;i<words.length;i++){
                sb.append(" ");
                sb.append(words[i]);
            }
            for(int k=sb.length();k<maxWidth;k++){
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res=fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
        for(String temp:res){
            System.out.println(temp);
        }
    }
}
