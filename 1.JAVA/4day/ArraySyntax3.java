/*
	1.basic/ArraySyntax3.java
	�н�����
	1. ������ �迭
	2. �迭�� �޸� ���� �� Ȯ�� �� ������ �׸� �׷�����
*/

public class ArraySyntax3 {
	public static void main(String[] args) {
		int[][] i = new int[5][12];
		System.out.println(i[0].length + " " + i[0][0]);
		i[0][0] = 100;
		System.out.println(i[0].length + " " + i[0][0]);
	}
}