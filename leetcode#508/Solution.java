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

    private int populateMap(TreeNode root, Map<Integer, Integer> map) {
        if(root==null) {
            return 0;
        }
        int s = root.val + populateMap(root.left, map) + populateMap(root.right, map);
        if(map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        return s;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        populateMap(root, map);
        int m=0;
        for(int i: map.keySet()) {
            m = Math.max(m, map.get(i));
        }
        List<Integer> ans = new ArrayList();
        for(int i: map.keySet()) {
            if(map.get(i)==m){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}