import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>给你二叉树的根结点 <code>root</code> ，请你将它展开为一个单链表：</p>
 *
 * <ul>
 * <li>展开后的单链表应该同样使用 <code>TreeNode</code> ，其中 <code>right</code> 子指针指向链表中下一个结点，而左子指针始终为 <code>null</code> 。</li>
 * <li>展开后的单链表应该与二叉树 <a href="https://baike.baidu.com/item/%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86/6442839?fr=aladdin" target="_blank"><strong>先序遍历</strong></a> 顺序相同。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,5,3,4,null,6]
 * <strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [0]
 * <strong>输出：</strong>[0]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中结点数在范围 <code>[0, 2000]</code> 内</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你可以使用原地算法（<code>O(1)</code> 额外空间）展开这棵树吗？</p>
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>链表</li><li>二叉树</li></div></div><br><div><li>👍 1686</li><li>👎 0</li></div>
 */
public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList114().new Solution();
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
        /* 第一种暴力解法
        public void flatten(TreeNode root) {
             //首先得前序遍历出来,暴力破解
             List<TreeNode> list = dfs(root);
             //重新构建二叉树
             TreeNode parent = root;

             for (int i = 1; i < list.size(); i++) {
                 parent.left = null;
                 parent.right = list.get(i);
                 parent = parent.right;

             }
         }
         private List<TreeNode> dfs(TreeNode root) {
             TreeNode cur = root;
             List<TreeNode> list = new ArrayList<>();

             LinkedList<TreeNode> stack = new LinkedList<>();
             while (!stack.isEmpty() || cur != null) {
                 if (cur != null) {
                     stack.push(cur);
                     list.add(cur);
                     cur = cur.left;
                     //根
                 } else {
                     TreeNode pop = stack.pop();
                     cur = pop.right;
                 }
             }
             return list;
         }*/
        TreeNode preNode;
        /*
         O(1)额外空间展开
        【首先】创建两个指针，分别为遍历用的指针node，和指针node的前置指针preNode；
        【其次】当preNode没有被初始化时，则preNode就指向node；
        【第三】每当指针node遍历的下一个节点时，都是将preNode节点的right指向node节点，将preNode节点的left指向null；
        【第四】preNode指针移动到node指针处，然后再重复第三步骤，直至整棵树遍历完毕；
         */

        public void flatten(TreeNode root) {

            if (root == null) {
                return;
            }
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            if (preNode != null) {
                preNode.left = null;
                preNode.right = root;
            }
            preNode = root;

            //正常的前序遍历
            flatten(leftNode);
            flatten(rightNode);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}