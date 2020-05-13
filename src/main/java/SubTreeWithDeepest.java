import java.util.ArrayList;
import java.util.List;

public class SubTreeWithDeepest {
    static int maxDepth=0;
    static List<Integer> commonPath;
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return root;
        preOrder(root,1,new ArrayList<>());
        //System.out.println(commonPath);
        //找到这个节点
        TreeNode t=root;
        for(int i=1;i<commonPath.size();i++){
            if(t.left!=null&&t.left.val==commonPath.get(i)){
                t=t.left;
            }
            else
                t=t.right;
        }
        return t;
    }

    public static void preOrder(TreeNode root, int depth, List<Integer> list){
        list.add(root.val);
        if(root.left!=null)
            preOrder(root.left,depth+1,list);
        if(root.right!=null)
            preOrder(root.right,depth+1,list);
        if(root.left==null&&root.right==null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                commonPath = new ArrayList<>(list);
            }
            if(depth==maxDepth){
                //找到commonPath
                for(int i=0;i<commonPath.size();i++){
                    if(commonPath.get(i)!=list.get(i))
                        commonPath=commonPath.subList(0,i);
                }
            }
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode t=subtreeWithAllDeepest(TreeNode.stringToTreeNode("[0,1,3,null,2]"));
    }
}
