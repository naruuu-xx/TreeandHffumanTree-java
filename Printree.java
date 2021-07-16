package TreeandHuffmanTree;
/*
 * ��ӡ������
 * ��printree��Ϊ�ӿ�
 * ���а�����̬����writeArray()�Լ�show()
 * ���ȣ���ȷ��������״.
 * �趨�����һ�е�ÿ������֮��ļ��Ϊ3���ո�
 * ����֮�ϵ�ÿһ��ļ����Խ���ϣ������Խ��ģ�
 * ������һ���򵥵��������ӵĹ�ϵ��
 * Ϊ�˻��Ƴ���������״�����ȣ�������Ҫ������Ĳ���
 * ����һ���򵥵ĵݹ鼴�ɵõ������������Ĳ�����ȷ�����ǵĶ�ά����Ĵ�С�����߶ȺͿ�ȡ�
 * ֮������������ķ�ʽ����������ÿ����㣬���������Ӧ��д�������
 */
interface Printree {
	public static void writeArray(TreeNode node, int rowIndex, int colIndex, 
			String[][] res, int Depth) {
		/*
		 * ��ȡ����keyֵ�Լ������ӽ��
		 */
		//int key = node.getkey();
		String data=node.getdata();
		TreeNode leftchild = node.getleftchild();
		TreeNode rightchild = node.getrightchild();
		/*
		 * ������Ϊ��
		 * ֱ�ӷ���
		 */
		if (node == null) {
			return;
		}
		/*
		 * ��keyֵת��Ϊ�ַ�����ֵ��res����
		 */
		//res[rowIndex][colIndex] = String.valueOf(key);
		res[rowIndex][colIndex]=String.valueOf(data);
		/*
		 * ���㵱ǰλ�����ĵڼ���
		 */
		int level = ((rowIndex + 1) / 2);
		if (level == Depth) {
			return;
		}
		/*
		 *  ���㵱ǰ�е���һ�У�ÿ��Ԫ��֮��ļ��
		 * ����һ�е��������뵱ǰԪ�ص�������֮��ļ����
		 */
		int gap = Depth - level - 1;
		/*
		 * �����ӽ������жϣ��������ӽ�㣬���¼��Ӧ��"/"�����ӽ���ֵ
		 * 
		 */
		if (leftchild != null) {
			res[rowIndex + 1][colIndex - gap] = "/";
			writeArray(leftchild, rowIndex + 2, colIndex - gap*2 , res, Depth);
		}
		/*
		 * �����ӽ������жϣ��������ӽ�㣬���¼��Ӧ��"\"�����ӽ���ֵ
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
		 * ����������ȣ��߶ȣ�
		 */
		int Depth = node.height();
		/*
		 * �����ά����ĸ߶ȺͿ��
		 * ���һ�еĿ��Ϊ2�ģ�n - 1���η���3���ټ�1
		 * ������û�������ǰ���£����������͸�����
		 * ����һλ���൱�ڳ���2��1�η�������nλ���൱�ڳ���2��n�η���
		 */
		int arrayHeight = Depth * 2 - 1;
		int arrayWidth = (2 << (Depth - 2)) * 3 + 1;
		/*
		 * �����ά����res��Ĭ��Ԫ�ؾ�Ϊ" "
		 */
		String[][] res = new String[arrayHeight][arrayWidth];
		for (int i = 0; i < arrayHeight; i++) {
			for (int j = 0; j < arrayWidth; j++) {
				res[i][j] = " ";
			}
		}
		writeArray(node, 0, arrayWidth / 2, res, Depth);
		/*
		 * ����StringBuilder���飬�Դ�ӡ�����ַ�������ƴ�ӡ�
		 * ��ʵ������������ʾ��
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
	 * ��writeArray�����Լ�show����������ǰ������ ֻ�ǲ�����Ϊ��HFNode,
	 * ͬʱ�����ж���data��Ϊ��Ȩ�ء�
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
