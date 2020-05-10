import java.util.ArrayList;
import java.util.List;

public class leetcode_71 {
    public static String simplifyPath(String path) {
        String[] split=path.split("\\/");
        List<String> res=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<split.length;i++){
            if(split[i].length()==0)
                continue;
            if(split[i].equals("..")) {
                if(!res.isEmpty()){
                    res.remove(res.size()-1);
                }
            }
            else if(split[i].equals(".")){
                continue;
            }
            else{
                res.add(split[i]);
            }
        }
        if(res.isEmpty()){
            return "/";
        }
        for(String temp:res){
            stringBuilder.append("/");
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
