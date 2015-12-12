/*
	1.basic/ArraySyntax3.java
	학습내용
	1. 이차원 배열
	2. 배열의 메모리 구조 재 확인 및 스스로 그림 그려보기
*/

public class ArraySyntax3 {
	public static void main(String[] args) {
		int[][] i = new int[5][12];
		System.out.println(i[0].length + " " + i[0][0]);
		i[0][0] = 100;
		System.out.println(i[0].length + " " + i[0][0]);
	}
}