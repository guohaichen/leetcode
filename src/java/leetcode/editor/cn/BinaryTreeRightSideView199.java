import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1062 👎 0
 */
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView199().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 注意 是顶部到底部的所有的右侧节点，而不是单纯的右侧节点；
         * 1. 层序遍历，也就是广度优先算法，算出每一层所有节点
         * 2. 那么每一层的最后一个节点也就是右节点。
         * 3. 队列中size为1时，那么该节点就是最右节点。
         * @param root
         * @return
         */
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode poll = queue.poll();
                    if (size == 1) {
                        list.add(poll.val);
                    }
                    size--;
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}