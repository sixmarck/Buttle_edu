package iotest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class IO3 {
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(new FileReader("message.properties"));
			
			// �켱 properties�� key�鸸 ��ȯ
			Set keys = p.stringPropertyNames();
			
			/* Iterator�� Key �ϳ��� ��ȯ, �ش� key�� value �� ȹ�� */
			Iterator it = keys.iterator();
			String keyName = null;
			
			/*	��µǴ� ������
			 * name�� xxx�Դϴ�. �� �������ֱ�
			 */
			String[] value = null;
			while(it.hasNext()) {
				keyName = (String)it.next();
				value = p.getProperty(keyName).split(",");
				System.out.println(value[0] + "�� " + value[1] + "�Դϴ�.");
			}

			/*String[] a = "a,b,c".split(",");
			System.out.println(a.length + " " + a[0]);*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
