import struct.TreeNode;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
 * root 。
 * <p>
 * 除了
 * root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子
 * 在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
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
 * 树的节点数在 [1, 10⁴] 范围内
 * 0 <= Node.val <= 10⁴
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1984 👎 0
 */
public class HouseRobberIii337 {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii337().new Solution();
        TreeNode childLeft = new TreeNode(2);
        TreeNode chileRight = new TreeNode(3);
        TreeNode root = new TreeNode(3,
                childLeft, chileRight);
        childLeft.right = new TreeNode(3);
        chileRight.right = new TreeNode(1);
        solution.rob(root);

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

        public int rob(TreeNode root) {
            // 调用辅助函数并只关心抢劫root节点情况下的最大金额
            // dp 保存打劫 和 不打劫的 最大价值
            int[] dp = robHelper(root);
            return Math.max(dp[0], dp[1]);
        }

        // 辅助函数，返回一个大小为2的数组，分别表示不抢劫当前节点和抢劫当前节点时的最大金额
        private int[] robHelper(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0}; // 空节点，两种情况都为0
            }

            // 递归计算左右子树的结果
            int[] left = robHelper(node.left);
            int[] right = robHelper(node.right);

            // 不抢劫当前节点，可抢劫左右子节点，取两者最大值之和
            int notRobCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 抢劫当前节点，不可抢劫左右子节点，加上当前节点的值
            int robCurrent = node.val + left[0] + right[0];

            return new int[]{notRobCurrent, robCurrent};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}