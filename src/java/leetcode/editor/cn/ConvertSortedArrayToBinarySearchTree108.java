import struct.TreeNode;

/**
 * <p>给你一个整数数组 <code>nums</code> ，其中元素已经按 <strong>升序</strong> 排列，请你将其转换为一棵 <span data-keyword="height-balanced">平衡</span> 二叉搜索树。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>nums = [-10,-3,0,5,9]
 * <strong>输出：</strong>[0,-3,9,-10,null,5]
 * <strong>解释：</strong>[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
 * <pre>
 * <strong>输入：</strong>nums = [1,3]
 * <strong>输出：</strong>[3,1]
 * <strong>解释：</strong>[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>nums</code> 按 <strong>严格递增</strong> 顺序排列</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>数组</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1525</li><li>👎 0</li></div>
 */
public class ConvertSortedArrayToBinarySearchTree108 {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree108().new Solution();
        int[] array = {-10,-3,0,5,7};
        solution.sortedArrayToBST(array);
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums, 0, nums.length - 1);

        }

        private TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            //确定root
            int middle = (left + right) / 2;

            TreeNode root = new TreeNode(nums[middle]);
            // 0 -middle-1 左子树
            root.left = dfs(nums, left, middle - 1);
            // middle+1-nums.length-1 右子树
            root.right = dfs(nums, middle + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}