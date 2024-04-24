import java.util.HashMap;

/**
 * 请你设计并实现一个满足
 * LRU (最近最少使用) 缓存 约束的数据结构。
 * <p>
 * <p>
 * <p>
 * 实现
 * LRUCache 类：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
 * value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * <p>
 * <p>
 * <p>
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10⁵
 * 最多调用 2 * 10⁵ 次 get 和 put
 * <p>
 * <p>
 * Related Topics 设计 哈希表 链表 双向链表 👍 3144 👎 0
 */
public class LruCache146 {
    public static void main(String[] args) {
        LRUCache solution = new LruCache146().new LRUCache(10);
    }

    /**
     * 思路：hashMap 用来存访具体的缓存，key为 value为
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class Node {
            Node pre;
            Node next;
            Integer key;
            Integer value;

            public Node(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public Node() {
            }
        }

        private HashMap<Integer, Node> cache = new HashMap<>();
        int size = 0;
        Node tail, head;
        //容量
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.tail.pre = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;

        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node current) {
            //删除该node节点，pre指向他的next
            current.pre.next = current.next;
            current.next.pre = current.pre;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            //如果缓存中有
            if (node == null) {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    Node deleteNode = removeTail();
                    cache.remove(deleteNode.key);
                    size--;
                }
            } else {
                //提到head
                node.value = value;
                moveToHead(node);
            }
        }

        private Node removeTail() {
            //删除尾巴
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}