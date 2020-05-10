import java.util.*;

public class leetcode_49 {
    private static final long[] alphabet=new long[]{2,3 ,5 ,7 ,11 ,13 ,17 ,19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public long caculate(String str){
        long res=1;
        for(int i=0;i<str.length();i++){
            res=res*alphabet[str.charAt(i)-'a'];
        }
        return res;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<Long,Integer> map=new HashMap<>();
        for(String str:strs){
            long num=caculate(str);
            if(map.containsKey(num)){
                res.get(map.get(num)).add(str);
            }
            else{
                map.put(num,res.size());
                res.add(new ArrayList<String>(Arrays.asList(str)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(alphabet.length);
    }
}
