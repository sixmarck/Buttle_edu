package buttle.model.dto;

/**
 * 사진게시판 정보
 * */
public class PhotoBoard extends Board {
	private String imgName;

	public PhotoBoard() {}
	public PhotoBoard(int no, String subject, String writer, String content, String date, String imgName) {
		super(no, subject, writer, content, date);
		this.imgName = imgName;
	}

	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 이미지 이름 = " + imgName);
		builder.append("]");
		return builder.toString();
	}
}
