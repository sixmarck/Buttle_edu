/*
	1.java/5.exception/Exception2.java
	�н�����
	1. java.lang.RuntimeException ���� Ŭ�������� ����ó�� ���� ���ʿ�
	2. ����� ���� ���� Ŭ���� ���� �� Ȱ�� ���
	  1) test ���� : id�� master�� �ƴ� ��� ������� "��ȿ�� id�Դϴ�"��� �޼��� �߻���Ű�� ����� ���� ���� Ŭ���� ���� ó���ϱ�
	  2) ����
	    (1) java.lang.Exception ���
		(2) parameter�� �ִ� ������ ����

*/ 
public class Exception2 {
	//id üũ�ϴ� �޼ҵ�
	public static void idCheck(String id) throws UserIDCheckException{
		if(id.equals("master")) {
			System.out.println("�ȳ��ϼ���~");
		}else{
			throw new UserIDCheckException("��ȿ�� id�Դϴ�.");
		}
	}

	public static void main(String[] args) {
		try{
			idCheck("kk");
		}catch(UserIDCheckException e) {
			System.out.println(e.getMessage());
		}
		
		//java.lang.Thread�� sleep()
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace(); // ���� �߻��� ����� ��� �ҽ��� line ������ ����
		}
		System.out.println(1);
	}
}