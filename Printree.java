package TreeandHuffmanTree;
/*
 * 打印二叉树
 * 将printree视为接口
 * 其中包含静态方法writeArray()以及show()
 * 首先，先确定树的形状.
 * 设定在最后一行的每个数字之间的间隔为3个空格，
 * 而在之上的每一层的间隔，越往上，间隔是越大的，
 * 而且是一个简单的线性增加的关系。
 * 为了绘制出这样的形状，首先，我们需要获得树的层数
 * （用一个简单的递归即可得到），根据树的层数，确定我们的二维数组的大小，即高度和宽度。
 * 之后，用先序遍历的方式，遍历树的每个结点，并进行相对应的写入操作。
 */
interface Printree {
	public static void writeArray(TreeNode node, int rowIndex, int colIndex, 
			String[][] res, int Depth) {
		/*
		 * 获取结点的key值以及左右子结点
		 */
		//int key = node.getkey();
		String data=node.getdata();
		TreeNode leftchild = node.getleftchild();
		TreeNode rightchild = node.getrightchild();
		/*
		 * 如果结点为空
		 * 直接返回
		 */
		if (node == null) {
			return;
		}
		/*
		 * 将key值转换为字符串赋值给res数组
		 */
		//res[rowIndex][colIndex] = String.valueOf(key);
		res[rowIndex][colIndex]=String.valueOf(data);
		/*
		 * 计算当前位于树的第几层
		 */
		int level = ((rowIndex + 1) / 2);
		if (level == Depth) {
			return;
		}
		/*
		 *  计算当前行到下一行，每个元素之间的间隔
		 * （下一行的列索引与当前元素的列索引之间的间隔）
		 */
		int gap = Depth - level - 1;
		/*
		 * 对左子结点进行判断，若有左子结点，则记录相应的"/"与左子结点的值
		 * 
		 */
		if (leftchild != null) {
			res[rowIndex + 1][colIndex - gap] = "/";
			writeArray(leftchild, rowIndex + 2, colIndex - gap*2 , res, Depth);
		}
		/*
		 * 对右子结点进行判断，若有右子结点，则记录相应的"\"与右子结点的值
		 */
		if (rightchild != null) {
			res[rowIndex + 1][colIndex + gap] = "\\";
			writeArray(rightchild, rowIndex + 2, colIndex + gap*2, res, Depth);
		}
	}

	public static void show(TreeNode node) {
		if (node == null)
			System.out.println("EMPTY!");
		/*
		 * 计算树的深度（高度）
		 */
		int Depth = node.height();
		/*
		 * 计算二维数组的高度和宽度
		 * 最后一行的宽度为2的（n - 1）次方乘3，再加1
		 * 在数字没有溢出的前提下，对于正数和负数，
		 * 左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
		 */
		int arrayHeight = Depth * 2 - 1;
		int arrayWidth = (2 << (Depth - 2)) * 3 + 1;
		/*
		 * 引入二维数组res，默认元素均为" "
		 */
		String[][] res = new String[arrayHeight][arrayWidth];
		for (int i = 0; i < arrayHeight; i++) {
			for (int j = 0; j < arrayWidth; j++) {
				res[i][j] = " ";
			}
		}
		writeArray(node, 0, arrayWidth / 2, res, Depth);
		/*
		 * 引入StringBuilder数组，对打印出的字符串进行拼接。
		 * 以实现整体树的显示。
		 */
		for (String[] line : res) {
			StringBuilder test = new StringBuilder();
			for (int i = 0; i < line.length; i++) {
				test.append(line[i]);
				if (line[i].length() > 1 && i <= line.length - 1) {
					i += line[i].length() > 4 ? 2 : line[i].length() - 1;
				}
			}
			System.out.println(test.toString());
		}
	}
	/*
	 * 该writeArray方法以及show方法类似于前面两个 只是参数变为了HFNode,
	 * 同时数组判定从data变为了权重。
	 */
	public static void writeArray(HFNode node, int rowIndex, int colIndex, String[][] res, int Depth) {
		int weight = node.Getweight();
		HFNode leftchild = node.getleftchild();
		HFNode rightchild = node.getrightchild();
		if (node == null) {
			return;
		}
		res[rowIndex][colIndex] = String.valueOf(weight);
		int level = ((rowIndex + 1) / 2);
		if (level == Depth) {
			return;
		}
		int gap = Depth - level - 1;
		if (leftchild!=null) {
			res[rowIndex + 1][colIndex - gap] = "/";
			writeArray(leftchild, rowIndex + 2, colIndex - gap*2 , res, Depth);
		}
		if (rightchild!=null) {
			res[rowIndex + 1][colIndex + gap] = "\\";
			writeArray(rightchild, rowIndex + 2, colIndex + gap*2 , res, Depth);
		}
	}


	public static void show(HFNode node) {
		if (node == null)
			System.out.println("EMPTY!");
		int Depth = node.height();
		int arrayHeight = Depth * 2 - 1;
		int arrayWidth = (2 << (Depth - 2)) * 3 + 1;
		String[][] res = new String[arrayHeight][arrayWidth];
		for (int i = 0; i < arrayHeight; i++) {
			for (int j = 0; j < arrayWidth; j++) {
				res[i][j] = " ";
			}
		}
		writeArray(node, 0, arrayWidth / 2, res, Depth);
		for (String[] line : res) {
			StringBuilder test = new StringBuilder();
			for (int i = 0; i < line.length; i++) {
				test.append(line[i]);
				if (line[i].length() > 1 && i <= line.length - 1) {
					i += line[i].length() > 4 ? 2 : line[i].length() - 1;
				}
			}
			System.out.println(test.toString());
		}
	}
}
