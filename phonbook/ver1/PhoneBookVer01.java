package phonbook.ver1;

class PhoneInfo {
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {	// 생일 입력 안하는 경우
		this.name = name;
		phoneNumber = num;
		this.birth = null;
	}
	
	// 전화번호 정보를 보여주는 메서드
	public void showPhoneInfo() {
		System.out.println("==================================");
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birth != null)
			System.out.println("생년월일 : " + birth);
	}
}

public class PhoneBookVer01 {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("방자", "010-1111-2222", "92년 09월 12일");
		PhoneInfo pInfo2 = new PhoneInfo("향단", "010-3333-4444");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();

	}

}
