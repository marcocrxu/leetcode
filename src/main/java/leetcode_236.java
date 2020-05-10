import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class leetcode_236 {
    static boolean p_find;
    static boolean q_find;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;
        p_find = false;
        q_find = false;
        return backOrder(root, p, q);
    }

    public static TreeNode backOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            //遍历左子树,如果找到两个就直接返回
            TreeNode left = backOrder(root.left, p, q);
            if (left != null) {
                return left;
            }
            boolean temp_p_find=p_find;
            boolean temp_q_find=q_find;
            p_find=false;
            q_find=false;
            TreeNode right = backOrder(root.right, p, q);
            p_find=p_find|temp_p_find;
            q_find=q_find|temp_q_find;
            if (right != null)
                return right;
            if (root.val == p.val)
                p_find = true;
            if (root.val == q.val)
                q_find = true;
            if (p_find && q_find)
                return root;
            return null;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(lowestCommonAncestor(Objects.requireNonNull(TreeNode.stringToTreeNode("[]")),new TreeNode(5),new TreeNode(0)).val);
    }
}
