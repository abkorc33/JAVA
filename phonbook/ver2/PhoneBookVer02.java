package phonbook.ver2;

import java.util.Scanner;

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

public class PhoneBookVer02 {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("==================================");
		System.out.println("작업을 선택하십시오!");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 데이터 입력");
		System.out.print("선택 : ");
	}
	
	public static void inputData() {
		System.out.println("==================================");
		System.out.print("이름 : ");
		String name = keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth = keyboard.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phone, birth);
		info.showPhoneInfo();// 입력한 정보를 보여준다.
	}

	public static void main(String[] args) {
		
		int choice = 0;	// 작업 선택한 값을 저장할 변수
		
		while(true) {
			// 메뉴를 보여준다.
			showMenu();
			// 메뉴에서 작업할 것을 선택한다.
			choice = keyboard.nextInt();
			keyboard.nextLine();	//nextInt쓰고 nextLine같이 써줘야 줄바꿈이 됨
			
			switch(choice) {
			case 1:	inputData();// 전화번호 등록
				break;
			case 0:	// 프로그램 종료
				return;
			}
		}

	}

}
