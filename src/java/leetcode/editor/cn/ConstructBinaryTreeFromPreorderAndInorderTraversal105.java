import struct.TreeNode;

import java.util.Arrays;

/**
 * <p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" />
 * <pre>
 * <strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <strong>输出:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> preorder = [-1], inorder = [-1]
 * <strong>输出:</strong> [-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
 * <li><code>inorder.length == preorder.length</code></li>
 * <li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
 * <li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li>
 * <li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li>
 * <li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li>
 * <li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 2315</li><li>👎 0</li></div>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal105().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        前序 根左右  3  9  20  15  7
        中序 左根右  9  3  15  20  7
        思路，首先拿到preorder[0]，这里即为根节点，那么根据该节点在中序遍历中查找，可以在inorder中得出
         */
            if (preorder.length == 0) {
                return null;
            }
            //前序遍历 根
            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);

            for (int i = 0; i < inorder.length; i++) {
                // i这时就是划分左右子树的关键下标
                if (rootVal == inorder[i]) {
                    // 中序遍历，左 根 右，因为前序遍历的根 和 中序遍历 inorder[i]相等时，说明 在中路遍历中inorder中 0~i-1是左子树， 右子树同理；i+1~length-1
                    int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                    int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                    //因为中序遍历已经拆分过了，左子树长度为0~i，即前序遍历左子树长度也是这个长度，
                    int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                    int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);


                    root.left = buildTree(preorderLeft, inorderLeft);
                    root.right = buildTree(preorderRight, inorderRight);
                    //这里可以break一下，跳过后面的判断，因为均无重复元素
                    break;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}