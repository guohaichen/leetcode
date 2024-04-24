import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics 树 广度优先搜索 二叉树 👍 1950 👎 0
 */
public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal102().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            //难点在于从左往右遍历时 得先找个容器放入下一层的数据，和内层的数组是如何计算大小的，也就是每层的树节点的个数
            Queue<TreeNode> queue = new LinkedList<>();
            //调用的也是 LinkedList.add();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                List<Integer> LevelList = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = queue.poll();
                    LevelList.add(current.val);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

                result.add(LevelList);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}