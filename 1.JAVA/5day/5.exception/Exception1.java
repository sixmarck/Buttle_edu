/*
	1.java/5.exception/Exception1.java
	�н�����
	* ����[exception] - ó�� ������ ����� ����

	1. ���� �߻� �� ����, ó�� ���� �� �ʿ伺 �н�
	2. ���� �߻� ������ ���� ���� �����ϱ�
	  1) ������ ���� �߻�
		- ���� ������ ������ �Ϻ��ϰ� �ڵ��ߴ� �ϴ��� ������ ���� �߻��ÿ��� �ݵ�� try~catch �ʼ�
	  2) ��Ÿ�� ���� �߻�
	    - �������� ����, ����� �߻��Ǵ� ���ܴ� try~catch ó�� �ɼ�
		�ֳ��ϸ� �� ���������� ���� ���� ����
	3. ���� ó�� ����
	  1) �߻������� �������� �ٷ� ó���ϴ� ����
	  try{
		���� �ʼ����� ���� ��, ���ܰ� �߻� ������ ������ ����
	  } catch(�߻������ѿ���Ÿ�� ����) {
		���ܹ߻��� ó�� ���
		����.printStackTrace(); // ���� �߻��� ���� ��� ���� Ȯ��
		����.getMessage(); // �߻��� ���� ��ü�� ������ ���� �޽����� String Ÿ������ ��ȯ
	  }
	  2) ȣ���� ������ ó�� �����ϴ� ����
		throws �ش� Exception
	
*/
class A {
	static{
		System.out.println("�� A ��");
	}
}

public class Exception1 {
	// �߻� ������ exeception�� �ش� �������� ó������ �ʰ� ȣ���� ������ ó�� �����ϴ� �ڵ�
	public static void m() throws ClassNotFoundException{
		Class.forName("A");
	}

	public static void main(String[] args) {
		int[] i = {1, 2};
		System.out.println(i[1]);

		// java.lang.Class�� forName(String name) - parameter�� ������ Ŭ������ byte code �޸𸮿� �ε������ �޼ҵ�
		try{
			//Class.forName("A");
			m();
		} catch (ClassNotFoundException e){
			System.out.println("�������ϴ� Ŭ������");
		}
		System.out.println("������ ���� ����");		
	}
}