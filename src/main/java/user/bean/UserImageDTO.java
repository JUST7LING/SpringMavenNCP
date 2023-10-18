package user.bean;

public class UserImageDTO {
	private int seq;
	private String imageName, imageContent, imageFileName, imageOriginalName;
				//    상품명       상품 내용		UUID에서 얻은 이름   이미지의 원래 이름
	@Override
	public String toString() {
		return "imageName  = "+imageName+" imageContent = "+imageContent+" imageFileName = "+imageFileName+" imageOriginalName = "+imageOriginalName;
	}
	
	/*
	UUID 란?

	UUID(Universally Unique IDentifier)는 네트워크상에서 고유성을 보장하는 ID를 만들기 위한 표준 규약이다.
	UUID는 다음과 같이 32개의 16진수로 구성되며 5개의 그룹으로 표시되고 각 그룹은 붙임표(-)로 구분한다.

	280a8a4d-a27f-4d01-b031-2a003cc4c039

	적어도 서기 3400년까지는 같은 UUID가 생성될 수 없다고 한다.
	이러한 이유로 UUID를 데이터베이스의 프라이머리 키(primary key)로 종종 사용한다.

	위에서 UUID를 이용하여 이미지 등록할 때 홈런볼.jpg을 업로드 했더니 storage 폴더에
	447e3573-01ca-4a68-be6a-ddce14bc07c8 으로 등록 된 것을 확인 할 수 있다
	
	클라우드에는 UUID name이 올라갈 예정이다.
	*/
	public int getSeq() {
		return seq;
	}
	public String getImageName() {
		return imageName;
	}
	public String getImageContent() {
		return imageContent;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public String getImageOriginalName() {
		return imageOriginalName;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public void setImageOriginalName(String imageOriginalName) {
		this.imageOriginalName = imageOriginalName;
	}
	
}
