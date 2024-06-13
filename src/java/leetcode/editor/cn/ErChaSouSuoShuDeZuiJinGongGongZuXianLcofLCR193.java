import struct.TreeNode;

/**
 * <p>给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。</p>
 *
 * <p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。”</p>
 *
 * <p>例如，给定如下二叉搜索树:&nbsp; root =&nbsp;[6,2,8,0,4,7,9,null,null,3,5]</p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png" /></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <strong>输出:</strong> 6
 * <strong>解释: </strong>节点 <span><code>2 </code></span>和节点 <span><code>8 </code></span>的最近公共祖先是 <span><code>6。</code></span>
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <strong>输出:</strong> 2
 * <strong>解释: </strong>节点 <span><code>2</code></span> 和节点 <span><code>4</code></span> 的最近公共祖先是 <span><code>2</code></span>, 因为根据定义最近公共祖先节点可以为节点本身。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>所有节点的值都是唯一的。</li>
 * <li>p、q 为不同节点且均存在于给定的二叉搜索树中。</li>
 * </ul>
 *
 * <p>注意：本题与主站 235 题相同：<a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/</a></p>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 344</li><li>👎 0</li></div>
 */
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcofLCR193 {

    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcofLCR193().new Solution();
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
            对比p,q与当前节点的值，如果两个值都小于当前节点，则进入左子树对比
            如果两个值都大于当前节点，则进入右子树对比
            如果两个值在分别在节点的两侧，说明当前节点是它两个最近的公共祖先
             */
            TreeNode cur = root;
            //先判断两个值与当前节点的值是否满足在同一侧，如果是同一侧，在进行判断是进入左子树还是右子树
            while (p.val < cur.val && q.val < cur.val || p.val > cur.val && q.val > cur.val) {
                //比较一个就行了，while循环满足过 p&q.val<cur.val
                if (p.val < cur.val) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}