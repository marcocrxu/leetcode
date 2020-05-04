import java.util.BitSet;

public class Maxtree {
    public static class Item{
        boolean BST;
        int max;
        int sum;
        public Item(boolean _BST,int _max,int _sum){
            BST=_BST;
            max=_max;
            sum=_sum;
        }

    }

    public static int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        Item it=isBST(root);
        return Math.max(it.max, 0);
    }

    public static Item isBST(TreeNode root){
        if(root==null){
            return new Item(true,0,0);
        }
        if(root.left==null&&root.right==null){
            return new Item(true,root.val,root.val);
        }
        if(root.left==null) {
            Item item = isBST(root.right);
            if (!item.BST)
                return item;
            else {
                int rightMin = 0;
                TreeNode temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                if (temp.val <= root.val) {
                    return new Item(false, item.max,item.max);
                } else {
                    item.sum += root.val;
                    if(item.sum>item.max)
                        item.max=item.sum;
                    return item;
                }
            }
        }
        if(root.right==null) {
            Item item = isBST(root.left);
            if (!item.BST)
                return item;
            else {
                TreeNode temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                if (temp.val >= root.val)
                    return new Item(false, item.max,item.max);
                else {
                    item.sum += root.val;
                    if(item.sum>item.max)
                        item.max=item.sum;
                    return item;
                }
            }
        }
        TreeNode left,right;
        left=root.left;right=root.right;
        while(left.right!=null)
            left=left.right;
        while(right.left!=null)
            right=right.left;
        if(left.val>=root.val||right.val<=root.val){
            Item l=isBST(root.left);
            Item r=isBST(root.right);
            return new Item(false,Math.max(l.max,r.max),Math.max(l.max,r.max));
        }
        else{
            Item l=isBST(root.left);
            Item r=isBST(root.right);
            int max= Math.max(l.max, r.max);
            if(l.BST&&r.BST)
                if(max<l.sum+r.sum+root.val)
                    return new Item(true,l.sum+r.sum+root.val,l.sum+r.sum+root.val);
                else
                    return new Item(true, max, l.sum + r.sum + root.val);
            else
                return new Item(false, max,max);
        }
    }
    public static void main(String[] args){
        System.out.println(maxSumBST(TreeNode.stringToTreeNode("[-2,8,8,0,null,10,-1,-4,2,null,null,3,null,null,-2,1,5,2,3,null,null,null,null,null,null,null,null,null,4]")));
    }
}
