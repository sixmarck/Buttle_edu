/*	interface �н�
 * 1. �뵵 : ����ϴ� ������, �����ϴ� ���� ������, ��ǰ �ǸŸ����� �����簣�� �������� ����
 * 2. ����
 * 		1) ����� �߻� �޼ҵ�θ� ����
 * 		2) ����� ���
 * 			[public static final] Ÿ�� ����� = ��;
 * 		3) �߻� �޼ҵ��� ���
 * 			[public abstract] ��ȯ Ÿ�� �޼ҵ��(...) [throws ~ Exception];
 * 
 */

package util;

// alt + shift + R ����ϰ� �ִ� ��� �̸� ����
public interface NameInterface {
	public static final int NO = 3;
	int NO2 = 5;
	
	/*	�ݵ�� ������ �̸� ��ȯ */
	public abstract String getName();
	/* �� ¦�� �̸� ��ȯ */
	String getName2();
}
