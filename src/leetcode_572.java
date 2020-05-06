import com.sun.source.tree.Tree;

public class leetcode_572 {
    public static boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        return s.val==t.val&&isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
    }


    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null&&s==null)
            return true;
        if(s==null||t==null)
            return false;
        if(s.val==t.val){
            return isSameTree(s,t)||(isSubtree(s.left,t))||(isSubtree(s.right,t));
        }
        else{
            return isSubtree(s.left,t)||isSubtree(s.right,t);
        }
    }

    public static void main(String[] args) {
        TreeNode s=TreeNode.stringToTreeNode("[3,4,5,1,null,2]");
        TreeNode t=TreeNode.stringToTreeNode("[3,1,2]");
        System.out.println(isSubtree(s,t));
    }
}
