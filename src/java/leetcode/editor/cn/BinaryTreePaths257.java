import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1140 👎 0
 */
public class BinaryTreePaths257 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths257().new Solution();
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
        List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, "");
            return result;
        }

        private void dfs(TreeNode node, String path) {
            if (node == null) {
                return;
            }
            //当没有左右节点时，说明是一条路径了。进行添加
            if (node.left == null && node.right == null) {
                result.add(path + node.val);
                return;
            }
            //有子节点
            String temp = path + node.val + "->";
            dfs(node.left, temp);
            dfs(node.right, temp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}