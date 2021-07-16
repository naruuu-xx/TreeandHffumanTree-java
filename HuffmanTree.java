package TreeandHuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 哈夫曼树
 * 哈夫曼树类包括结点类和树类
 * 结点和树为组合关系
 * 树不能没有结点，结点也不能脱离树单独存在
 * 哈夫曼树继承于树
 * 哈夫曼结点继承于树结点
 */
class HFNode extends TreeNode implements Comparable<HFNode> {
	private int weight;
	private String data;
	private HFNode leftchild;
	private HFNode rightchild;

	/*
	 * 构造huffman树的三种方法 1. 输入权重和数据 2.默认构造法 权重为0 数据为空 3.仅输入权重，数据为空
	 */
	public HFNode(int weight, String data) {
		this.data = data;
		this.weight = weight;
	}

	public HFNode() {
		this(0, " ");
	}

	public HFNode(int weight, String data, HFNode leftchild, HFNode rightchild) {
		this.weight = weight;
		this.data = data;
		this.leftchild = leftchild;
		this.rightchild = rightchild;
	}

	public HFNode(int weight) {
		this(weight, " ");
	}

	public int Getweight() {
		return this.weight;
	}

	@Override
	public HFNode getleftchild() {
		// TODO Auto-generated method stub
		return this.leftchild;
	}

	@Override
	public HFNode getrightchild() {
		// TODO Auto-generated method stub
		return this.rightchild;
	}

	@Override
	public String toString() {
		return "HFNode [weight=" + weight + "data" + data + "]";
	}

	/*
	 * HFNode类开头接入Comparable接口 Comparable接口主要引入compareTo方法 比较对象权重和结点的权重
	 */
	@Override
	public int compareTo(HFNode node) {
		// TODO Auto-generated method stub
		return this.weight - node.weight;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("weight:" + weight);
	}

}

/*
 * huffmanTree类继承自tree类 buildHFtree方法主要思路： 输入一串数组（arr）使得该数组转化为哈夫曼树
 * 引入ArrayList动态数组 实现增删改查功能 然后将数组arr中的元素挨个添加进去 哈夫曼树的实现过程便是，对nodesList数组进行排序
 * （利用Collections类中的sort方法进行升序排序） 然后将排好序之后的数组的0号位和1号位视为左子结点和右子结点二者相加即为其父结点
 * 然后将左子结点和右子结点从nodesList数组中删除 将父结点添入nodesList数组中再重新进行排序以及结点建立
 * 直到nodesList数组中没有元素为止 哈夫曼树即成功建立。
 * 
 */
class HuffmanTree extends tree {
	HFNode node;

	static HFNode buildHFtree(int[] arr)  {
		ArrayList<HFNode> nodesList = new ArrayList<HFNode>();
		for (int x : arr) {
			nodesList.add(new HFNode(x, "A"));
		}
		while (nodesList.size() > 1) {
			Collections.sort(nodesList);
			HFNode leftNode = nodesList.get(0);
			HFNode rightNode = nodesList.get(1);
			HFNode parent = new HFNode(leftNode.Getweight() + rightNode.Getweight(), " ", leftNode, rightNode);
			parent.setLeftChild(leftNode);
			parent.setRightChild(rightNode);
			nodesList.remove(leftNode);
			nodesList.remove(rightNode);
			nodesList.add(parent);
		}

		return nodesList.get(0);
	}
}