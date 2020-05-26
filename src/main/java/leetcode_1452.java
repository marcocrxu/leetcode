import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res=new ArrayList<>();
        List<Map<String,Boolean>> list=new ArrayList<>();
        for(List<String> curUser:favoriteCompanies){
            Map<String,Boolean> map=new HashMap<>();
            for(String str:curUser){
                map.put(str,true);
            }
            list.add(map);
        }

        for(int i=0;i<favoriteCompanies.size();i++){
            boolean findFather=false;
            for(int j=0;j<favoriteCompanies.size();j++){
                if(favoriteCompanies.get(i).size()>favoriteCompanies.get(j).size())
                    continue;
                else if(i==j)
                    continue;
                boolean find=false;
                for(String temp:favoriteCompanies.get(i)){
                    if(!list.get(j).containsKey(temp)) {
                        find = true;
                        break;
                    }
                }
                if(!find){
                    findFather=true;
                    break;
                }
            }
            if(!findFather)
                res.add(i);
        }
        return res;
    }
}
