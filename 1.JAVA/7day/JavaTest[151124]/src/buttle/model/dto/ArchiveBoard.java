package buttle.model.dto;
/**
 * 자료실 정보
 * */
public class ArchiveBoard  extends Board{
	private String fileName;
	private int fileSize;
	
	public ArchiveBoard(){}
	public ArchiveBoard(int no, String subject, String writer, String content, String date, String fileName, int fileSize) {
		super( no,  subject,  writer,  content,  date);
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( super.toString() );
		builder.append(", 첨부파일 이름 = "+fileName);
		builder.append(", 파일 용량 = "+fileSize);
		builder.append("]");
		return builder.toString();
	}

}
