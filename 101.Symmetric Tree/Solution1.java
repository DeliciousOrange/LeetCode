public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        // 下面这段代码更加简洁，这表明在写函数时，若返回值是布尔值，则可以考虑
        // 将多个分支的返回值用与或非连接起来
        // return root==null || isSymmetricHelp(root.left, root.right);
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }


    // 下面的代码更加简洁，仔细体会left == right
    // private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    // if(left==null || right==null)
    //     return left==right;
    // if(left.val!=right.val)
    //     return false;
    // return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    // }

    private boolean helper(TreeNode left, TreeNode right){
        if (left==null || right==null) {
            if (left == null && right !=null) {
                return false;
            }
            else if (left!=null) {
                return false;
            }
            return true;
        }
        if (left.val == right.val) {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
        return false;
    }
}
