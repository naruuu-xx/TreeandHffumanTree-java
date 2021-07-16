package TreeandHuffmanTree;

import java.util.Scanner;

public class testfuc {
	public static void test() {
		TreeNode A = new TreeNode(1, "A");
		tree T = new tree(A);
		T.treecreate(A);
		System.out.println("打印该二叉树：");
		Printree.show(T.node);
		System.out.println("前序遍历：");
		T.node.preOrder();
		System.out.println("中序遍历：");
		T.node.inOrder();
		System.out.println("后序遍历：");
		T.node.postOrder();
		System.out.println("树的高度：" + T.node.height());
		System.out.println("树的结点数：" + T.node.size(T.node));
		System.out.println();
		// int[] arr= {1,2,3,4,5,6};
		// int[] arr = {3,7,8,29,5,11,23,14};
		// int arr[] = {13, 7, 8, 3, 29, 6, 1};*/
		
		System.out.println("输入数组的长度:");
		Scanner reader = new Scanner(System.in);
		int length = reader.nextInt();
		int[] arr = new int[length];
		System.out.println("输入哈夫曼树的权重数组：");
		for (int i = 0; i < length; i++) {
			arr[i] = reader.nextInt();
		}
		HFNode node = HuffmanTree.buildHFtree(arr);
		System.out.println("打印该哈夫曼树：");
		Printree.show(node);
		System.out.println("前序遍历：");
		node.preOrder();
		System.out.println("中序遍历：");
		node.inOrder();
		System.out.println("后序遍历：");
		node.postOrder();
		System.out.println();
		System.out.println("树的高度：" + node.height());
		System.out.println("树的结点数：" + node.size(node));
		}
	}

