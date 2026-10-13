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

    private int[] postorder;
    private int[] position = new int[6001];
    private int next;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.next = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            position[inorder[i] + OFFSET] = i;
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int rootValue = postorder[next--];
        TreeNode root = new TreeNode(rootValue);
        int mid = position[rootValue + OFFSET];

        root.right = build(mid + 1, hi);
        root.left = build(lo, mid - 1);

        return root;
        
    }
}