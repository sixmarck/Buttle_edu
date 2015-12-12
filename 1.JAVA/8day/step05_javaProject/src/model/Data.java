package model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import model.dto.Member;
import model.dto.Transport;
import util.Utils;

public class Data {
	private Map<String, Member> memberList = new HashMap<String, Member>();
	private Map<String, Transport> transportList = new HashMap<String, Transport>();
	private Date now = new Date();

	private static Data instance = new Data();

	public static Data getInstance() {
		return instance;
	}

	private Data() {
		String[] dataValue = null;
		String key = null;
		Iterator<String> allKey = null;

		try {
			Properties memberInfo = new Properties();
			memberInfo.load(new FileReader("member.properties"));

			allKey = memberInfo.stringPropertyNames().iterator();

			while (allKey.hasNext()) {
				key = allKey.next();
				dataValue = memberInfo.getProperty(key).split(",");
				memberList.put(key, new Member(dataValue[0], dataValue[1],
						dataValue[2], dataValue[3], dataValue[4]));
			}

			Properties transportInfo = new Properties();
			transportInfo.load(new FileReader("transport.properties"));

			allKey = transportInfo.stringPropertyNames().iterator();

			while (allKey.hasNext()) {
				key = allKey.next();
				dataValue = transportInfo.getProperty(key).split(",");
				transportList.put(key, new Transport(dataValue[0],
						dataValue[1], dataValue[2], dataValue[3], dataValue[4],
						dataValue[5], dataValue[6], dataValue[7], dataValue[8],
						dataValue[9], dataValue[10]));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<String, Transport> allSearch() {
		return transportList;
	}

	public boolean login(String id, String pw) {
		boolean result = false;
		Iterator<String> it = memberList.keySet().iterator();
		String key = null;
		while (it.hasNext()) {
			key = it.next();
			if (memberList.get(key).getId().equals(id)
					&& memberList.get(key).getPw().equals(pw)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public Map<String, Member> allMemberList() {
		return memberList;
	}

	public Map<String, Transport> allTransportList() {
		return transportList;
	}

	public boolean changeState(String no, int value) {
		boolean result = false;

		Iterator<String> it = transportList.keySet().iterator();
		String key = null;
		Transport t = null;

		while (it.hasNext()) {
			key = it.next();
			t = transportList.get(key);
			if (t.getNo().equals(no) && t.getEndDate().equals("null")) {
				t.setState(Utils.STATE[value - 1]);
				if (value == 3) {
					t.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(now));
				}
				result = true;
				break;
			}
		}

		if (result) {
			BufferedWriter out = null;
			String trans = null;

			try {
				out = new BufferedWriter(new FileWriter("transport.properties",
						true));

				trans = no + "=" + t.getNo() + "," + t.getId() + ","
						+ t.getSender() + "," + t.getSenderAddr() + ","
						+ t.getSenderPh() + "," + t.getReceiver() + ","
						+ t.getReceiverAddr() + "," + t.getReceiverPh() + ","
						+ t.getState() + "," + t.getStartDate() + ","
						+ t.getEndDate();
				out.newLine();
				out.write(trans);
				out.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public void oneDayParcelStatistics() {
		Map map = new HashMap<String, Integer>();

		// transport의 key값 받아와 다른 HashMap에 삽입
		Iterator<String> it = transportList.keySet().iterator();

		String key = null;
		String key2 = null;

		while (it.hasNext()) {
			key = it.next();
			map.put(transportList.get(key).getStartDate(), Utils.ZERO);
		}
		int count = 0;

		it = transportList.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			count = ((int) map.get(transportList.get(key).getStartDate()));
			map.put(transportList.get(key).getStartDate(), ++count);
		}

		Iterator<String> it2 = map.keySet().iterator();

		while (it2.hasNext()) {
			key2 = it2.next();
			System.out.print(key2 + "의 배송현황은 ");
			System.out.println(map.get(key2) + "건 입니다.");
		}

	}

	public static boolean checkTransport(String no) {
		boolean result = false;
		Map map = instance.allTransportList();
		if (map.containsKey(no))
			result = true;
		else
			result = false;
		return result;
	}

	public boolean productRegistr(String id, String lines) {
		boolean flag = false;
		Member sender = memberList.get(id);
		Member receiver = memberList.get(lines);

		Iterator<String> it = memberList.keySet().iterator();
		String key = null;

		Iterator<String> transIt = transportList.keySet().iterator();
		String tanskey = null;
		Transport t = null;

		while (it.hasNext()) {
			key = it.next();
			if (memberList.get(key).getId().equals(lines) && !memberList.get(key).getId().equals(memberList.get(key).getId())) {
				flag = true;
				transportList.put(
						Integer.toString(transportList.size() + 1),
						new Transport(
								Integer.toString(transportList.size() + 1), id,
								sender.getName(), sender.getAddr(), sender
										.getPh(), receiver.getName(), receiver
										.getAddr(), receiver.getPh(),
								Utils.STATE[0], new SimpleDateFormat(
										"yyyy-MM-dd").format(now), "null"));
				break;
			}
		}
		if (flag) {
			BufferedWriter out = null;
			String trans = null;

			t = transportList.get(Integer.toString(transportList.size()));
			try {
				out = new BufferedWriter(new FileWriter("transport.properties", true));

				trans = t.getNo() + "=" + t.getNo() + "," + t.getId() + ","
						+ t.getSender() + "," + t.getSenderAddr() + ","
						+ t.getSenderPh() + "," + t.getReceiver() + ","
						+ t.getReceiverAddr() + "," + t.getReceiverPh() + ","
						+ t.getState() + "," + t.getStartDate() + ","
						+ t.getEndDate();
				out.newLine();
				out.write(trans);
				out.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public boolean registerForm(Member m) {
		Iterator<String> it = memberList.keySet().iterator();
		String key = null;
		boolean b = false;
		while (it.hasNext()) {
			key = it.next();
			if (memberList.get(key).getId().equals(m.getId())) {

				b = true;
				break;
			}
		}
		if (!b) {
			memberList.put(m.getId(), m);
			
			BufferedWriter out = null;
			String trans = null;
			
			try {
				out = new BufferedWriter(new FileWriter("member.properties", true));

				trans = m.getId() + "=" + m.getId() + "," + m.getPw() + ","
						+ m.getName() + "," + m.getAddr() + ","
						+ m.getPh();
				out.newLine();
				out.write(trans);
				out.flush();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return b;

	}
	
	public Boolean deleteBoard(String no) {
		Boolean flag = false;
		if(transportList.get(no).getState().equals(Utils.STATE[0]) || transportList.get(no).getState() == "null") {
			transportList.remove(no);
			flag = true;
		}
		return flag;
	}
}
