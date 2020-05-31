# 学习笔记 Week02

## 1. Hash Table (HashMap, HashSet)： ##

  - Map：key不重复  key - value对                  
  - Set：不重复元素的集合。  HashSet底层实现是基于HashMap的, 只不过只存放key，不存放value。


### HashMap的源码分析: ###

* 在JDK1.6，JDK1.7中，HashMap采用位桶+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。但是当位于一个桶中元素较多，即hash值相等的值过多时，通过key值依次查找的效率较低。而在JDK 1.8中，HashMap采用位桶+链表+红黑树实现，当链表长度超过阀值（8）时，将链表转换为红黑树，这样大大减少了查询时间。

* get(Object key)、getNode(int hash,Object key)：获取key的hash值，计算hash & (n-1)得到在链表数组中的位置first=tab[hash&(n-1)]，先判断first的key是否与参数key相等，不等就遍历后面的链表/红黑树找到相同的key值返回对应的Value值即可。

* 允许NULL值，NULL键;

* 不要轻易改变负载因子，负载因子过高会导致链表过长，查找键值对时间复杂度就会增高，负载因子过低会导致hash桶的 数量过多，空间复杂度会增高;

* Hash表每次会扩容长度为以前的2倍'

* HashMap是多线程不安全的;

* 尽量设置HashMap的初始容量，尤其在数据量大的时候，防止多次resize.



## 2.树、二叉树、二叉搜索树的实现和特性： ##

  - 树的结构用于满足人类需求，例如递归树，状态树，决策树.
  - 二叉树的遍历，前序，中序，后序，-- 相对于根的位置
  - 树的循环比较麻烦，**递归**是更好的实现。
  - LinkedList是特殊化的Tree

  定义:

```java
public class TreeNode{                    
	public int val;
    public TreeNode left,right;
    public TreeNode(int val){
    	this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

### 二叉树遍历：Pre-order/In-order/Post-order ###

  - 前序（Pre-Order）:根 - 左 - 右

  - 中序（In-Order）: 左- 根 - 右	

  - 后序（Post-Order）: 左 - 右 - 根

  
### 二叉搜索树: ###

* 空树也是二叉搜索树
* 左子树的所有节点都小于根
* 右子树的所有节点都大于根
* 依次类推，也就是重复性来源
二叉搜索树 Demo，https://visualgo.net/zh/bst 

常见操作

* 查询: O(log n)
* 插入: O(log n)
* 删除: O(log n): 如果是叶子节点，直接删除，如果不是，则找第一个大于待删除节点来替换掉要删除的节点。



## 3.堆（Heap）、二叉堆(Binary Heap)和图(Graph)： ##

 - Heap:可以迅速找到一堆数中的最大或者最小值的数据结构。根节点最大的堆叫大顶堆或大根堆、根节点最小 - 小根堆、小顶堆。常见的有二叉堆、斐波那契堆。  
 - 大顶堆：find-max: O(1)  delete-max : O(logn)  insert: O(logn) or O(1)
 - 二叉堆：通过完全二叉树实现（注意：不是二叉搜索树）

​二叉堆实现细节：     
  - 二叉堆一般都通过“数组”来实现     
  - 假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：     
    - 索引为i的左孩子的索引是（2*i+1）; 
    - 索引为i的右孩子的索引是（2*i+2）;
    - 索引为i的父节点的索引是  floor（（i-1）/2）;