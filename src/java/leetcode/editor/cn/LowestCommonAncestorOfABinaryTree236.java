import struct.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>
 *
 * <p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。”</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>输出：</strong>3
 * <strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>1 </code></span>的最近公共祖先是节点 <span><code>3 。</code></span>
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>输出：</strong>5
 * <strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>4 </code></span>的最近公共祖先是节点 <span><code>5 。</code></span>因为根据定义最近公共祖先节点可以为节点本身。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2], p = 1, q = 2
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数目在范围 <code>[2, 10<sup>5</sup>]</code> 内。</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li>所有 <code>Node.val</code> <code>互不相同</code> 。</li>
 * <li><code>p != q</code></li>
 * <li><code>p</code> 和 <code>q</code> 均存在于给定的二叉树中。</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 2712</li><li>👎 0</li></div>
 */
public class LowestCommonAncestorOfABinaryTree236 {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree236().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /*
               情况：left，right不为空，说明他们分别在其左右子树，直接返回当前节点。即为最近公共祖先
               如果left=root,则left为最近公共祖先
               如果right=root，则right为最近公共祖先
             */
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //左子树&右子树都有
            if (left != null && right != null) {
                return root;
            } else if (left != null) {//左根
                return left;
            } else //右根
                return right;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}