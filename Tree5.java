package TreeandHuffmanTree;
/*
 * ��������
 * ���а��� ������Ժ����Ĺ��췽��
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
 * �½�һ����
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
 * �������� ������,���������Լ�������Ҷ�������
 * ��������Ҫ�����Ǳ��
 */

class TreeNode implements Printree{
	private int key;
	private String data;
	private TreeNode leftchild;
	private TreeNode rightchild;
/*
 * ���Ĺ��췽����Ϊ����:
 * 1.ֻ�����ֵ������ ��ʱ�ӽ���Ϊ��
 * 2.�����ֵ�������Լ����ҽ��
 * 3.ʲô��������Ĭ��keyֵΪ1 ����Ϊ�� û�������ӽ��
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
 * set�����޸Ľ������ӽ������ӽڵ�
 */
	public void setLeftChild(TreeNode node) {

		this.leftchild = node;

	}

	public void setRightChild(TreeNode node) {
		this.rightchild = node;
	}
	/*
	 * get���� ��ȡ�ý���������ݣ�keyֵ�Լ������ӽڵ�ֵ
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
 * show���������ǰ�����keyֵ��dataֵ
 * ҲΪ֮��ĵݹ��㷨��׼��
 */
	public void show() {
		System.out.println("key:" + key + "--data:" + data);
	}
/*
 * �ݹ��㷨������ĸ߶ȣ�������
 * �����ӽ��������ӽڵ�Ϊ��ʱ �߶ȣ�������Ϊ1
 * �����ӽ�㲻Ϊ�գ����ӽ�㲻Ϊ��ʱ
 * �߶ȣ�������Ϊ�ϴ��ӽ��߶�+1
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
 * �ݹ�����������
 * �����Ϊ��ʱ �ڵ�����Ϊ0
 * �����ǿ�ʱ���������Ϊ���ӽ������+���ӽ������+���������1��
 */
	public int size(TreeNode T) {
		if (T == null) {
			return 0;
		} else {
			return 1 + size(T.leftchild) + size(T.rightchild);
		}
	}
/*
 * �ݹ��㷨ʵ��ǰ�����
 * �����������������
 * ����ٱ������ӽ��
 * ���������ӽ��
 * �����������������������
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
