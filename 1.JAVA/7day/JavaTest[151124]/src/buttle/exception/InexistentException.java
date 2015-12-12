package buttle.exception;
/**
 * 게시물 
 * */
public class InexistentException extends Exception {
   public InexistentException(){
	   super("존재하지 않는 게시물 입니다.");
   }
   public InexistentException(String message){
	   super("글번호 " + message+"는 존재하지 않는 게시물 입니다.");
   }
}
