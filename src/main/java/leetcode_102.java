import java.util.*;

public class leetcode_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return res;
        queue.add(root);

        //开始遍历
        while(!queue.isEmpty()){
            List<TreeNode> tempQueue=new ArrayList<>();
            List<Integer> curFloor=new ArrayList<>();
            //将queue中所有都poll出来
            while(!queue.isEmpty()){
                TreeNode t=queue.poll();
                if(t.left!=null)
                    tempQueue.add(t.left);
                if(t.right!=null)
                    tempQueue.add(t.right);
                curFloor.add(t.val);
            }
            res.add(curFloor);
            queue.addAll(tempQueue);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
