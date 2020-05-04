import java.util.*;
public class leetcode_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res= new ArrayList<Integer>(Collections.emptyList());
        if(s.equals(""))
            return res;
        if(words.length==0)
            return res;
        int len=words[0].length();
        if (s.length() < words.length * len)
            return res;
        Map<String,Integer> temp=new HashMap<String, Integer>();
        for(String word:words){
            temp.put(word,temp.getOrDefault(word,0)+1);
        }
        for(int i=0;i<=s.length()-words.length*len;i++){
            if(temp.get(s.substring(i,i+len))==null){
                continue;
            }
            boolean find=true;
            Map<String,Integer> index=new HashMap<String, Integer>();
            for(int j=0;j<words.length;j++){
                String unit=s.substring(i+j*len,i+(j+1)*len);
                int val=index.getOrDefault(unit,0)+1;
                if(val>temp.getOrDefault(unit,0)){
                    find=false;
                    break;
                }
                else {
                    index.put(unit,val);
                }
            }
            if(find)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args){
        List<Integer> res=findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","good","best"});
        System.out.println(0);
    }

}
