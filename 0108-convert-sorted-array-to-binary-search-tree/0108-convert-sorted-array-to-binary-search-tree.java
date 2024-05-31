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
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return null;
        }

        int mid = len / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);        
        int[] right = Arrays.copyOfRange(nums, mid + 1, len);
        

        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(left);
        node.right = sortedArrayToBST(right);
        
        return node;
    }
}