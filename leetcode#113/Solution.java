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
    void findPath(TreeNode root, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null) {
            if(target==root.val) {
                temp.add(root.val);
                ans.add(temp);
            }
            return;
        }
        temp.add(root.val);
        List<Integer> temp2 = new ArrayList<>(temp);
        findPath(root.left, target - root.val, ans, temp);
        findPath(root.right, target - root.val, ans, temp);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findPath(root, targetSum, ans, temp);
        return ans;
    }
}