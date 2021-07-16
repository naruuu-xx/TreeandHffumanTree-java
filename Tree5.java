package TreeandHuffmanTree;
/*
 * 建立树类
 * 其中包括 结点属性和树的构造方法
 */
class tree  {
	TreeNode node;

	public tree(TreeNode A) {
		node = A;
	}
	public tree() {
		TreeNode node=null;
		this.node=node;
	}
/*
 * 新建一棵树
 *        A 
 *      /   \
 *     B     C
 *   /   \     \
 *  D     E     F
 */
	public  void treecreate(TreeNode A) {
		TreeNode B = new TreeNode(2, "B");
		TreeNode C = new TreeNode(3, "C");
		TreeNode D = new TreeNode(4, "D");
		TreeNode E = new TreeNode(5, "E");
		TreeNode F = new TreeNode(6, "F");
	
		A.setLeftChild(B);
		A.setRightChild(C);
		B.setLeftChild(D);
		B.setRightChild(E);
		C.setRightChild(F);
		
	}

}
/*
 * 结点类包含 键属性,数据属性以及左儿子右儿子属性
 * 键属性主要作用是标记
 */

class TreeNode implements Printree{
	private int key;
	private String data;
	private TreeNode leftchild;
	private TreeNode rightchild;
/*
 * 结点的构造方法分为三种:
 * 1.只输入键值和数据 此时子结点均为空
 * 2.输入键值和数据以及左右结点
 * 3.什么都不输入默认key值为1 数据为空 没有左右子结点
 */
	public TreeNode(int key, String data) {
		this.key = key;
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
	}

	public TreeNode(int key, String data, TreeNode leftchild, TreeNode rightchild) {
		this.key = key;
		this.data = data;
		this.leftchild = leftchild;
		this.rightchild = rightchild;
	}

	public TreeNode() {
		this(1, null);
	}
/*
 * set方法修改结点的左子结点和右子节点
 */
	public void setLeftChild(TreeNode node) {

		this.leftchild = node;

	}

	public void setRightChild(TreeNode node) {
		this.rightchild = node;
	}
	/*
	 * get方法 获取该结点对象的数据，key值以及左右子节点值
	 */
	public String getdata() {
		return this.data;
	}
	public int getkey() {
		return this.key;
	}
	public TreeNode getleftchild() {
		return this.leftchild;
	}
	public TreeNode getrightchild() {
		return this.rightchild;
	}
	
/*
 * show方法输出当前对象的key值和data值
 * 也为之后的递归算法做准备
 */
	public void show() {
		System.out.println("key:" + key + "--data:" + data);
	}
/*
 * 递归算法计算结点的高度（层数）
 * 当左子结点或者右子节点为空时 高度（层数）为1
 * 当左子结点不为空，右子结点不为空时
 * 高度（层数）为较大子结点高度+1
 * 
 */
	public int height() {
		int i = 0;
		int j = 0;
		if(this.leftchild==null&&this.rightchild==null) {
			return 1;
		}
		if (this.leftchild != null) {
			i = this.leftchild.height();
		}
		if (this.rightchild != null) {
			j = this.rightchild.height();
		}
		return (i < j) ? (j + 1) : (i + 1);

	}
/*
 * 递归求解结点的总数
 * 当结点为空时 节点总数为0
 * 当结点非空时，结点总数为左子结点总数+右子结点总数+根结点数（1）
 */
	public int size(TreeNode T) {
		if (T == null) {
			return 0;
		} else {
			return 1 + size(T.leftchild) + size(T.rightchild);
		}
	}
/*
 * 递归算法实现前序遍历
 * 首先输出根结点的数据
 * 其次再遍历左子结点
 * 最后遍历右子结点
 * 中序遍历，后序遍历情况类似
 */
	public void preOrder() {
		this.show();
		if (this.leftchild != null) {
			this.leftchild.preOrder();
		}
		if (this.rightchild != null) {
			this.rightchild.preOrder();

		}

	}

	public void inOrder() {

		if (this.leftchild != null) {
			this.leftchild.inOrder();
		}
		this.show();
		if (this.rightchild != null) {
			this.rightchild.inOrder();

		}

	}

	public void postOrder() {

		if (this.leftchild != null) {
			this.leftchild.postOrder();
		}
		if (this.rightchild != null) {
			this.rightchild.postOrder();

		}
		this.show();
	}

	public void Copy(TreeNode T, TreeNode S) {
		if (T == null) {
			S = null;
		} else {
			S = T;
			Copy(T.leftchild, S.leftchild);

		}
	}

	@Override
	public String toString() {
		return "TreeNode [key=" + key + ", data=" + data + "]";
	}

}
