import struct.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
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
 * Related Topics 树 广度优先搜索 二叉树 👍 792 👎 0
 */
public class BinaryTreeLevelOrderTraversalIi107 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi107().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root==null){
                return new ArrayList<>();
            }
            //利用辅助结构 队列，存进去最后再反转一下数组
            List<List<Integer>> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                while (size > 0) {
                    TreeNode pop = queue.poll();
                    levelList.add(pop.val);
                    size--;
                    if (pop.left != null) {
                        queue.offer(pop.left);
                    }
                    if (pop.right != null) {
                        queue.offer(pop.right);
                    }
                }
                list.add(levelList);
            }

            //交换头尾
            List<List<Integer>> result = new ArrayList<>();
            for (int i = list.size()-1; i >= 0; i--) {
                result.add(list.get(i));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}