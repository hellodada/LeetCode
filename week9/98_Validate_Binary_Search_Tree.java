/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    public boolean isValid(TreeNode root, long min, long max){
        //System.out.println("root = " +root.val+" min = "+min+" max = "+max);
        if(root == null)
            return true;
        //System.out.println("root = " +root.val+" min = "+min+" max = "+max);
        if( (root.val < max) &&
            ( root.val > min))
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        return false;
            
    }
}