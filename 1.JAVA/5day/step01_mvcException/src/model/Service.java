package model;

import exception.IdCheckException;
import model.domain.Person;

public class Service {
	//검색 메소드
	/* 문법 ok
	 * 논리적인 문제 발생
	 * 1. 특정 Person 객체 검색은 부적함
	 *   왜? 이 메소드는 무조건 Person[]의 마지막 객체만 반환
	 * 2. client가 요청하는 조건의 객체로 반환하기 위한 조건
	 *   - client 요청 기준 데이터 필요 : parameter
	 *   - 반환 타입 : 검색된 Person
	 *     - 요청하는 고객이 없을 수도 있음을 고려...
	 */
	public static Person search(String v) {
		Person []  all = Data.getAll();
		Person p = null;
		
		if(v.equals("one")) {
			p = all[0];
		}else if(v.equals("two")) {
			p = all[1];
		}
		return p;
	}
	
	//가입을 위한 로직 단 중복 체크 로직 포함해서 개발하기
	public static void save(Person v) throws IdCheckException {
		Person[] all = Data.getAll();
		String id = null;
		for (int i = 0; i < all.length; i++) {
			id = all[i].getId();
			if (id.equals(v.getId())) {
				throw new IdCheckException("id가 중복되었습니다.");
			}
		}
		Data.newSave(v);	//기존 배열에 새로 저장
	}

	public static Person[] getAll() {
		return Data.getAll();
	}

	public static Person getOne(String v) {
		// TODO Auto-generated method stub
		int idx = 0;
		switch (v) {
		case "one":
			idx = 0;
			break;
		case "two":
			idx = 1;
			break;
		case "three":
			idx = 2;
			break;
		default:
			break;
		}
		return Data.getOne(idx);
	}
}
