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
    public int maxDepth(TreeNode root) {
        // 빈 트리면 깊이는 0
        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> q = new LinkedList<>();

        // 루트 노드를 큐에 삽입
        q.add(root);

        // 큐가 빌떄까지 현재 높이에 있는 자식 노드를 큐에 추가
        while (!q.isEmpty()){
            depth += 1;
            int len = q.size();
            // 현재 노드의
            for(int i=0; i<len; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }

        return depth;
    }
}