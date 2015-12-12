�н�����

1. java.sql�� JDBC API�� sql���� ���� API �н�
   - java.sql.Statement
         - ����..�ټ��� sql���� ���� ������ ��ü
         - ������ sql���� �ټ� ����� PreparedStatement ��ü���� ó�� �ӵ��� ����
         Statement stmt = con.createStatement();
         stmt.executeUpdate("sql");
         
   - java.sql.PreparedStatement
         - ���� ������ ������ sql���ڸ����� ����, 
           �ϳ��� PreparedStatement��ü�� �ϳ��� sql���常 ���� ����
         - DB���� Framework���� ����ϴ� API
         - Statement ���� ó�� �ӵ��� ����(�ټ� �����)
         - �����Ͱ� ǥ����ġ�� ? �� ǥ��
         - �����Ͱ� ���� sql�� ����� index 1�� ���۵Ǵ� ��ġ ������ setXxx()�� ó��
           PreparedStatement pstmt 
              = con.prepareStatement("insert into dept01 values(?, ?, ?)");
           
           pstmt.setInt(1, 50);
           pstmt.setString(2, 'eee');
           pstmt.setString(3, 'eeeee');
           
           pstmt.executeUpdate();
           
2. JDBC api�� �̿��� Ʈ������ ó��
	*** Ʈ������� ����ڰ� �����Ҽ� �ִ� API ***
	1. Ʈ����� ��ȿȭ �޼ҵ�
		Connection�� setAutoCommit(false);
	2. ���� ���� �� ���� ����
		Connection�� commit();
	3. ������ ����� ����
		Connection rollback();
   - �ǽ� ���� 
      : �����͸� insert �� update�õ�
        - ����� �߻� ������ ����� ��
        1. �� ���� �����ؼ� ����            : ���� ����
        2. insert�� ����, update�� ����   : ����, ����ȭ
        3. insert ����, update����      : ����ȭ        
        ...
        
3. JDBC API Ư¡[Ʈ������ ����]
   1) commit ��ɾ �ʿ��� sql���� : DML[insert/update/delete]
   2) jdbc api�� DML��ɾ� ���� �޼ҵ� : int executeUpdate("dml")�� auotcommit
   3) 2�� ���� ó�� �����۾��� �ϳ��� �۾������� ���� ���ؼ��� autocommit ����� �Ҹ��ؾ� ��
      - Ʈ������� �����ڰ� �ڵ�� ����
   
   4) �ڵ� ����
      driver�ε�
      Connection con = ...
      con.setAutoCommit(false);
      
      Statement stmt = con.createStatement();
      stmt.executeUpdate("DML");
      
      Statement stmt2 = con.createStatement();
      stmt2....
   
      con.commit();
      
      con.rollback();
 