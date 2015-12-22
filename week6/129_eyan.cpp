class Solution {
public:
    int sumNumbers(TreeNode *root) {
        int sum = 0;
        if(root == NULL)
            return 0;
        helper(root, root->val, sum);
        return sum;
    }

    void helper(TreeNode* root, int num, int& sum) {
        if(root->left == NULL && root->right == NULL) {
          sum += num;
          return;
        }
        if(root->left != NULL)
           helper(root->left, 10 * num + root->left->val, sum);
        if(root->right != NULL)
           helper(root->right, 10 * num + root->right->val, sum);
        return;
    }
};