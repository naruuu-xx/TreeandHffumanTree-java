package TreeandHuffmanTree;

import java.util.Scanner;

public class testfuc {
	public static void test() {
		TreeNode A = new TreeNode(1, "A");
		tree T = new tree(A);
		T.treecreate(A);
		System.out.println("��ӡ�ö�������");
		Printree.show(T.node);
		System.out.println("ǰ�������");
		T.node.preOrder();
		System.out.println("���������");
		T.node.inOrder();
		System.out.println("���������");
		T.node.postOrder();
		System.out.println("���ĸ߶ȣ�" + T.node.height());
		System.out.println("���Ľ������" + T.node.size(T.node));
		System.out.println();
		// int[] arr= {1,2,3,4,5,6};
		// int[] arr = {3,7,8,29,5,11,23,14};
		// int arr[] = {13, 7, 8, 3, 29, 6, 1};*/
		
		System.out.println("��������ĳ���:");
		Scanner reader = new Scanner(System.in);
		int length = reader.nextInt();
		int[] arr = new int[length];
		System.out.println("�������������Ȩ�����飺");
		for (int i = 0; i < length; i++) {
			arr[i] = reader.nextInt();
		}
		HFNode node = HuffmanTree.buildHFtree(arr);
		System.out.println("��ӡ�ù���������");
		Printree.show(node);
		System.out.println("ǰ�������");
		node.preOrder();
		System.out.println("���������");
		node.inOrder();
		System.out.println("���������");
		node.postOrder();
		System.out.println();
		System.out.println("���ĸ߶ȣ�" + node.height());
		System.out.println("���Ľ������" + node.size(node));
		}
	}

