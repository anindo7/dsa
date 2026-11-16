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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans=0;
        while (!q.isEmpty()) {
            ans = q.peek().val;
            Queue<TreeNode> q2 = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q2.add(curr.left);
                }
                if (curr.right != null) {
                    q2.add(curr.right);
                }
            }
            q = q2;
        }
        return ans;
    }
}