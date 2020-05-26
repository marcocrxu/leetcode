import java.util.Arrays;
        import java.util.Comparator;

public class leetcode_179 {
    static class node{
        public int num;
        public String str;
        node(int num,String str){
            this.num=num;
            this.str=str;
        }

    }

    public static String largestNumber(int[] nums) {
        node[] nodes=new node[nums.length];
        int max_len=0;
        for(int i=0;i<nums.length;i++){
            nodes[i]= new node(nums[i], String.valueOf(nums[i]));
            max_len=Math.max(nodes[i].str.length(),max_len);
        }
        max_len++;
        for(node temp:nodes){
            if(temp.str.length()<max_len){
                StringBuilder sb=new StringBuilder(temp.str);
                int cnt=0;
                int len=sb.length();
                for(int i=0;i<max_len-temp.str.length();i++){
                    sb.append(temp.str.charAt((cnt++)% len));
                }
                temp.str=sb.toString();
            }
        }
        Arrays.sort(nodes, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return (int)(Long.parseLong(o2.str)-Long.parseLong(o1.str));
            }
        });
        StringBuilder res=new StringBuilder();
        for(node temp:nodes){
            if(temp.num==0&&res.toString().equals("0"))
                continue;
            res.append(String.valueOf(temp.num));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(ListNode.stringToIntegerArray("[999999998,999999997,999999999]")));
    }
}
