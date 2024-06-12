import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>给你一棵二叉树的根节点 <code>root</code> ，请你构造一个下标从 <strong>0</strong> 开始、大小为 <code>m x n</code> 的字符串矩阵 <code>res</code> ，用以表示树的 <strong>格式化布局</strong> 。构造此格式化布局矩阵需要遵循以下规则：</p>
 *
 * <ul>
 * <li>树的 <strong>高度</strong> 为 <code>height</code> ，矩阵的行数 <code>m</code> 应该等于 <code>height + 1</code> 。</li>
 * <li>矩阵的列数 <code>n</code> 应该等于 <code>2<sup>height+1</sup> - 1</code> 。</li>
 * <li><strong>根节点</strong> 需要放置在 <strong>顶行</strong> 的 <strong>正中间</strong> ，对应位置为 <code>res[0][(n-1)/2]</code> 。</li>
 * <li>对于放置在矩阵中的每个节点，设对应位置为 <code>res[r][c]</code> ，将其左子节点放置在 <code>res[r+1][c-2<sup>height-r-1</sup>]</code> ，右子节点放置在 <code>res[r+1][c+2<sup>height-r-1</sup>]</code> 。</li>
 * <li>继续这一过程，直到树中的所有节点都妥善放置。</li>
 * <li>任意空单元格都应该包含空字符串 <code>""</code> 。</li>
 * </ul>
 *
 * <p>返回构造得到的矩阵<em> </em><code>res</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/print1-tree.jpg" style="width: 141px; height: 181px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2]
 * <strong>输出：</strong>
 * [["","1",""],
 * &nbsp;["2","",""]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/print2-tree.jpg" style="width: 207px; height: 302px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3,null,4]
 * <strong>输出：</strong>
 * [["","","","1","","",""],
 * &nbsp;["","2","","","","3",""],
 * &nbsp;["","","4","","","",""]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数在范围 <code>[1, 2<sup>10</sup>]</code> 内</li>
 * <li><code>-99 &lt;= Node.val &lt;= 99</code></li>
 * <li>树的深度在范围 <code>[1, 10]</code> 内</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 217</li><li>👎 0</li></div>
 */
public class PrintBinaryTree655 {
    public static void main(String[] args) {
        Solution solution = new PrintBinaryTree655().new Solution();
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
        // 题目规则以及将大部分放置位置给出来了。
        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            String[][] result = new String[height][(1 << height) - 1];
            List<List<String>> list = new ArrayList<>();
            //先填充""
            for (String[] array : result) {
                Arrays.fill(array, "");
                list.add(Arrays.asList(array));
            }
            dfs(result, root, 0, 0, result[0].length);
            return list;
        }

        private void dfs(String[][] result, TreeNode root, int index, int left, int right) {
            if (root == null) {
                return;
            }
            result[index][(left + right) / 2] = String.valueOf(root.val);
            dfs(result, root.left, index + 1, left, (left + right) / 2);
            dfs(result, root.right, index + 1, (left + right + 1)/2, right);
        }

        //获得二叉树的高度
        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}