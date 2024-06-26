package Trees;
import java.util.Stack;
/*
 * LeetCode: 98. Validate Binary Search Tree
 * TC=O(n) and SC=O(h) where h is the height of the tree
 * Approach: Inorder traversal of BST is always sorted
 * Iterative inorder traversal
 * S30 Prob 42
 * 
 */

public class isValidBst {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev=root;
            System.out.println(root.val);
            root = root.right;
        }
        return true;
    }
    
}
/*
 * Recursive approach
 * TC=O(n) and SC=O(h) where h is the height of the tree
 * class Solution {
    boolean isValid;
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        isValid = true;
        inOrder(root);
        return isValid;

    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev=root;
        inOrder(root.right);
    }
}
 */