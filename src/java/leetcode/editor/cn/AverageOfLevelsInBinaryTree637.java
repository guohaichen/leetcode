import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点
 * root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 树中节点数量在 [1, 10⁴] 范围内
 * -2³¹ <= Node.val <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 485 👎 0
 */
public class AverageOfLevelsInBinaryTree637 {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree637().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            //同二叉树的广度遍历
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<Double> list = new ArrayList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int levelNumber = queue.size();
                double levelSum = 0;
                while (size > 0) {
                    TreeNode poll = queue.poll();
                    levelSum += poll.val;

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    size--;
                }
                list.add(levelSum / levelNumber);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}