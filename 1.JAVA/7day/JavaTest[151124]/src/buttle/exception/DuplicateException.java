package buttle.exception;

/**
 * 게시물 중복 예외
 * */
public class DuplicateException extends Exception{
	public DuplicateException() {
		super("존재하는 게시물입니다.");
	}
	public DuplicateException(String message) {
		super("글번호 "+message +" 는 존재하는 게시물입니다.");
	}

}
