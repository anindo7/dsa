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

    private int calculateProfit(TreeNode root, Map<TreeNode, Integer> dp, boolean taken) {
        if(root == null) {
            return 0;
        }
        if(dp.containsKey(root)) {
            return dp.get(root);
        }
        int profit = 0;
        int take = root.val + calculateProfit(root.left, dp, true) + calculateProfit(root.right, dp, true);
        int untake = calculateProfit(root.left, dp, false) + calculateProfit(root.right, dp, false);
        profit = taken? untake : Math.max(take, untake);
        dp.put(root, Math.max(take, untake));
        return profit;
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap();
        return calculateProfit(root, dp, false);
    }
}