import java.util.*;
public class TimeMap {
    /** Initialize your data structure here. */
    public class item{
        String key;
        int time;
        public item(String _val,int _time){
            key=_val;
            time=_time;
        }
        public void setTime(int _time){
            time=_time;
        }
        public void setVal(String _val){
            key=_val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            item item = (item) o;
            return time == item.time &&
                    Objects.equals(key, item.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, time);
        }
    }
    Map<String,List<Integer>> KeyMap;
    Map<item,String> map;
    public TimeMap() {
        map=new HashMap<>();
        KeyMap=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(KeyMap.containsKey(key)){
            KeyMap.get(key).add(timestamp);
        }
        else{
            List<Integer> new_list=new ArrayList<>(Collections.emptyList());
            new_list.add(timestamp);
            KeyMap.put(key,new_list);
        }
        map.put(new item(key,timestamp),value);
    }

    public String get(String key, int timestamp) {
        if(!KeyMap.containsKey(key))
            return "";
        List<Integer> list=KeyMap.get(key);
        int index=getLowerBound(list,timestamp);
        if(index==0)
            return "";
        int x=list.get(index-1);
        item it=new item(key,x);
        return map.get(it);
    }

    public int getLowerBound(List<Integer> list,int target){
        int start=0;
        int end=list.size();
        while(start<end){
            int mid=(start+end)/2;
            if(list.get(mid)>target)
                end= mid;
            else
                start=mid+1;
        }
        return start;
    }

    public static void main(String[] args){
        TimeMap kv=new TimeMap();
        kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
        System.out.println(kv.get("foo", 1));  // 输出 "bar"
        System.out.println(kv.get("foo", 3)); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4)); // 输出 "bar2"
        System.out.println(kv.get("foo", 5)); // 输出 "bar2"
    }

}
