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
			
			// 우선 properties의 key들만 반환
			Set keys = p.stringPropertyNames();
			
			/* Iterator로 Key 하나씩 반환, 해당 key로 value 값 획득 */
			Iterator it = keys.iterator();
			String keyName = null;
			
			/*	출력되는 형식이
			 * name은 xxx입니다. 로 적용해주기
			 */
			String[] value = null;
			while(it.hasNext()) {
				keyName = (String)it.next();
				value = p.getProperty(keyName).split(",");
				System.out.println(value[0] + "은 " + value[1] + "입니다.");
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
