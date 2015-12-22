class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
    if (!root)
        return -1;

    stack<TreeNode*> s;

    while (root) {
        s.push(root);
        root = root->left;
    }


    while (k) {
        TreeNode* node;
        do {
            node = s.top();
            s.pop();
            if (--k == 0)
                return node->val;
        } while (!node->right);

        node = node->right;

        while (node) {
            s.push(node);
            node = node->left;
        }
    }

    return -1;
    }
};