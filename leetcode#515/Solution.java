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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int ma=Integer.MIN_VALUE;
            Queue<TreeNode> q2 = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode curr = q.poll();
                ma = Math.max(ma, curr.val);
                if(curr.left!=null) {
                    q2.add(curr.left);
                }
                if(curr.right!=null) {
                    q2.add(curr.right);
                }
            }
            ans.add(ma);
            q = q2;
        }
        return ans;
    }
}