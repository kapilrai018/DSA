/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        private static final int OFFSET = 3000;

    private int[] preorder;
    private int[] position = new int[6001];
    private int next;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.next = 0;

        for (int i = 0; i < inorder.length; i++) {
            position[inorder[i] + OFFSET] = i;
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int rootValue = preorder[next++];
        TreeNode root = new TreeNode(rootValue);
        int mid = position[rootValue + OFFSET];

        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);

        return root;
        
    }
}