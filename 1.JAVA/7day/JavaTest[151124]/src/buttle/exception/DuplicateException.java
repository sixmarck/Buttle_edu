package buttle.exception;

/**
 * �Խù� �ߺ� ����
 * */
public class DuplicateException extends Exception{
	public DuplicateException() {
		super("�����ϴ� �Խù��Դϴ�.");
	}
	public DuplicateException(String message) {
		super("�۹�ȣ "+message +" �� �����ϴ� �Խù��Դϴ�.");
	}

}
