import java.util.*;
public class leetcode_199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=1;
        while(true){
            TreeNode temp=null;
            int NextCount=0;
            for(int i=0;i<count;i++){
                temp=queue.poll();
                if(temp==null)
                    continue;
                if(temp.left!=null) {
                    queue.add(temp.left);
                    NextCount++;
                }
                if(temp.right!=null) {
                    queue.add(temp.right);
                    NextCount++;
                }
            }
            if(temp==null)
                break;
            res.add(temp.val);
            count=NextCount;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res=rightSideView(TreeNode.stringToTreeNode("[1,null,null]"));
        System.out.println(0);
    }
}
