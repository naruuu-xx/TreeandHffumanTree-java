package TreeandHuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ��������
 * �����������������������
 * ������Ϊ��Ϲ�ϵ
 * ������û�н�㣬���Ҳ������������������
 * ���������̳�����
 * ���������̳��������
 */
class HFNode extends TreeNode implements Comparable<HFNode> {
	private int weight;
	private String data;
	private HFNode leftchild;
	private HFNode rightchild;

	/*
	 * ����huffman�������ַ��� 1. ����Ȩ�غ����� 2.Ĭ�Ϲ��취 Ȩ��Ϊ0 ����Ϊ�� 3.������Ȩ�أ�����Ϊ��
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
	 * HFNode�࿪ͷ����Comparable�ӿ� Comparable�ӿ���Ҫ����compareTo���� �Ƚ϶���Ȩ�غͽ���Ȩ��
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
 * huffmanTree��̳���tree�� buildHFtree������Ҫ˼·�� ����һ�����飨arr��ʹ�ø�����ת��Ϊ��������
 * ����ArrayList��̬���� ʵ����ɾ�Ĳ鹦�� Ȼ������arr�е�Ԫ�ذ�����ӽ�ȥ ����������ʵ�ֹ��̱��ǣ���nodesList�����������
 * ������Collections���е�sort���������������� Ȼ���ź���֮��������0��λ��1��λ��Ϊ���ӽ������ӽ�������Ӽ�Ϊ�丸���
 * Ȼ�����ӽ������ӽ���nodesList������ɾ�� �����������nodesList�����������½��������Լ���㽨��
 * ֱ��nodesList������û��Ԫ��Ϊֹ �����������ɹ�������
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