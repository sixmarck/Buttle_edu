package buttle.view;

import buttle.controller.BoardController;
import buttle.model.dto.ArchiveBoard;
import buttle.model.dto.PhotoBoard;

public class MainView {

	public static void main(String[] args) {
		//1.archive�� photo ��� �Խù� �˻�
		System.out.println("========== 1. ��� �Խù� �˻� ==============");
		BoardController.getAllBoard();
		
		System.out.println("\n");
		
		//2. archive �Ǵ� photo  �Խ��ǿ� �ִ� ��� �Խù� �˻�
		System.out.println("========== 2. �Խ��� ������ ���� �˻� ==============");  
		BoardController.getBoardByKind("archive");
		
		System.out.println("\n");
		
		//3.�۹�ȣ�� �ش��ϴ� �ڷ�ǰ˻�
		/* �����ϴ� �Խù� �˻��� ���� ���� �Խù� �˻� ���� test ��� ����ϱ�
		 */
		System.out.println("==========3.Archive Board���� �۹�ȣ�� �ش��ϴ� �Խù� �˻� ==============");
		System.out.println("-----�Խù��� �����ϴ� ��� �˻� test----- ");
		BoardController.getBoardByno("archive", 10); //�����ϴ� �Խù�
		
		System.out.println();
		
		System.out.println("-----�Խù��� ���� ���  �˻� test-----");
		BoardController.getBoardByno("archive", 30);// ���� �Խù�
		
		System.out.println("\n");
		
		//4. �Խù� ����ϱ�(TreeMap�� ����- �����ϱ� ���� �۹�ȣ �ߺ����� üũ)
		System.out.println("========== 4. �Խù� ��� ==============");
		System.out.println("-----���ο� �Խù� �����  ��� test----- ");
		BoardController.insertBoard("photo", new PhotoBoard(20, "Java", "�̳���", "�ȳ�", "2013-10-20", "a.gif"));//�۹�ȣ ���� �Խù����
		
		System.out.println("-----���ο� �Խù� �����  ��� test----- ");
		BoardController.insertBoard("archive", new ArchiveBoard(12, "Java", "�̳���", "�ȳ�", "2013-10-20", "jdbc.xls", 200));//�۹�ȣ ���� �Խù����
		
		System.out.println();
		System.out.println("-----�̹� �����ϴ� �Խù� ��� �Ϸ��� ��� test----- ");
		BoardController.insertBoard("photo", new PhotoBoard(10, "Java", "�̳���", "�ȳ�", "2013-10-20", "a.gif"));//�۹�ȣ �̹� �ִ� �Խù����

		System.out.println("\n");
		
		//5. �Խù� ����(��������븸 ����������. �۹�ȣ ���翩�� üũ)
		System.out.println("========== 5. �Խù� ���� ==============");
		System.out.println("-----�Խù��� �����ϴ� ��� ���� test----- ");
		BoardController.updateBoard("archive", "myBatis","myBatis�����ڷ�",10);//�۹�ȣ �ִ� �Խù� ����
		
		System.out.println();
		System.out.println("-----�Խù��� �������� �ʴ� ��� ���� test----- ");
		BoardController.updateBoard("archive", "myBatis","myBatis�����ڷ�",20);//�۹�ȣ ���� �Խù� ����
		//BoardController.getAllBoard();
		
		System.out.println("\n");
		
		//6. �Խù� ����
		System.out.println("========== 6. �Խù� ���� ==============");
		System.out.println("-----�Խù��� �����ϴ� ��� ���� test----- ");
		BoardController.deleteBoard("archive", 10);
		
		System.out.println();
		System.out.println("-----�Խù��� �������� �ʴ� ������  test----- ");
		BoardController.deleteBoard("archive", 15);
	}
}
