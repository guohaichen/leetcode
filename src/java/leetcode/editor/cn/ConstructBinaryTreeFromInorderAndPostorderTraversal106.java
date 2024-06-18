import struct.TreeNode;

import java.util.Arrays;

/**
 * <p>给定两个整数数组 <code>inorder</code> 和 <code>postorder</code> ，其中 <code>inorder</code> 是二叉树的中序遍历， <code>postorder</code> 是同一棵树的后序遍历，请你构造并返回这颗&nbsp;<em>二叉树</em>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
 * <pre>
 * <b>输入：</b>inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * <b>输出：</b>[3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <b>输入：</b>inorder = [-1], postorder = [-1]
 * <b>输出：</b>[-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
 * <li><code>postorder.length == inorder.length</code></li>
 * <li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
 * <li><code>inorder</code>&nbsp;和&nbsp;<code>postorder</code>&nbsp;都由 <strong>不同</strong> 的值组成</li>
 * <li><code>postorder</code>&nbsp;中每一个值都在&nbsp;<code>inorder</code>&nbsp;中</li>
 * <li><code>inorder</code>&nbsp;<strong>保证</strong>是树的中序遍历</li>
 * <li><code>postorder</code>&nbsp;<strong>保证</strong>是树的后序遍历</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1231</li><li>👎 0</li></div>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal106().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            /*
            和105 题很像：从前，中序构建二叉树
            思路：    中序： 左 根 右
                     后序： 左 右 根
                后序遍历取 最后一个元素，即为根，左子树 中序遍历和后序遍历相同，
             */
            if (inorder.length == 0) {
                return null;
            }
            int rootVal = postorder[postorder.length - 1];
            TreeNode root = new TreeNode(rootVal);

            for (int i = 0; i < postorder.length; i++) {
                /*
                if (inorder[i] != postorder[i]) {
                前面都是左子树，当遇到不同时，后序遍历则是 i~length-1为右子树,length-1为根
                我这种对比方式 在一组  21，21测试用例时没用通过，该二叉树没有右节点，所以导致我的if判断没有成功，
                所以还是得用 根节点取判断；
                 */

                if (inorder[i] == rootVal) {

                    int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                    int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                    int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
                    int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);


                    root.left = buildTree(inorderLeft, postorderLeft);
                    root.right = buildTree(inorderRight, postorderRight);
                    break;
                }
            }
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}