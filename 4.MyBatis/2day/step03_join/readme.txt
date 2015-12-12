학습내용

1. 한사람이 여러개의 취미를 보유 할 수 있다.
	- 1: * = 1: 다

2. join의 mybatis 처리 방법 학습

3. Connection 재사용에 대한 확인
	- 설정 파일에 어떻게 설정했느냐에 따른 확인
	
4. 로그기록을 할 수 있는 framework
	1) 이름 : log4j
	2) 용도 : 실행흐름  즉 로그기록용 framework
	3) 사용처 : 다른 framework들이 log4j를 많이 활용함
				필요에 따라 자바 개발자들도 사용 가능
	4) 사용 방법
		1단계 - library 즉 framework 다운로드 셋팅
		2단계 - 로그기록으로 남길 내용이 무엇이냐에 대한 설정
				: log4j.properties라는 파일을 규칙에 맞게 작성
		3단계 - 소스와 같은 경로에 파일 저장
		4단계 - 차후 file로도 자동생성되게 설정예정
	5) 참고
		- 로그기록용 framework 종류들
			: sl4j, logback