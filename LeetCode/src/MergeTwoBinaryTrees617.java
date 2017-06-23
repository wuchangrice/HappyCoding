/**
 * Created by oukinsei on 17/6/15.
 */
public class MergeTwoBinaryTrees617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(null == t1 && null == t2){
            return null;
        }
        TreeNode t = new TreeNode(0);
        if(null == t1){
            t.val = t2.val;
            t.left = mergeTrees(null, t2.left);
            t.right = mergeTrees(null, t2.right);
            return t;
        }
        if(null == t2){
            t.val = t1.val;
            t.left = mergeTrees(null, t1.left);
            t.right = mergeTrees(null, t1.right);
            return t;
        }
        t.val = t1.val + t2.val;
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
}
