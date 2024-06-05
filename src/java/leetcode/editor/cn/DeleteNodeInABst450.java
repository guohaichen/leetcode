import struct.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节
 * 点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 节点数的范围 [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10⁵ <= key <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * Related Topics 树 二叉搜索树 二叉树 👍 1333 👎 0
 */
public class DeleteNodeInABst450 {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst450().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return root;
            }
            //根据二叉搜索树的特点，找到该节点
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                /*找到了 key == root.val
                找到了 分4种情况：1.该节点没有左、右节点
                2. 该节点没有左节点
                3. 该节点没有右节点
                4. 该节点有左、右节点
                当遇到第四种情况时，因为是二叉搜索树，该删除节点的左子树比该节点的右子树的左孩子都小，所以需要遍历来操作
                注意，题目返回的试二叉搜索树有可能被更新的根节点的引用
                 */
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    //左、右节点都不为空的情况，
                    TreeNode cur = root.right;
                    while (cur.left != null) {
                        cur = cur.left;
                    }
                    //将左子树 连接到右子树的最左节点
                    cur.left = root.left;
                    root = root.right;
                    return root;
                }
            }
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}