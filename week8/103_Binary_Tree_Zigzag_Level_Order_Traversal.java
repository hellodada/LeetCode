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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        Stack<TreeNode> sLeft = new Stack<TreeNode>();
        Stack<TreeNode> sRight = new Stack<TreeNode>();
        sLeft.add(root);
        while(!sLeft.empty()){
            List<Integer> row = new ArrayList<Integer>();
            while(!sLeft.empty()){
                TreeNode temp = sLeft.pop();
                if(temp != null){
                    row.add(temp.val);
                    if(temp.left != null)
                        sRight.push(temp.left);
                    if(temp.right != null)
                        sRight.push(temp.right);

                }
            }
            ans.add(row);
            if(!sRight.empty()){
                List<Integer> row1 = new ArrayList<Integer>();
                while(!sRight.empty()){
                    TreeNode temp = sRight.pop();
                    if(temp != null){
                        row1.add(temp.val);
                        if(temp.right != null)
                            sLeft.push(temp.right);
                        if(temp.left != null)
                            sLeft.push(temp.left);
                    }
                }
                ans.add(row1);
            }
        }
        return ans;
        
        
    }
}