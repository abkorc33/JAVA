package phonbook.ver3;

import java.util.Scanner;

// 전화번호 정보
class PhoneInfo {
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo(String name, String num, String birth) {	// 매개변수 있는 생성자
		this.name = name;
		phoneNumber = num;
		this.birth = birth;
	}
	
	public PhoneInfo(String name, String num) {	// 메서드 오버로딩
		this.name = name;
		phoneNumber = num;
		this.birth = null;
	}
	public void showPhoneInfo() {
		System.out.println("이   름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birth != null)	// 생년월일의 값이 있는 경우만 보여준다.
			System.out.println("생년월일 : " + birth);
	}
	
}
// 전화번호 정보관리 : 등록, 수정, 삭제, 조회
class PhoneBookManager {
	final int MAX_CNT =	100;
	
	// PhoneInfo를 담을 수 있는 방이 100개가 생성되는 것이 아니라,
	// PhoneInfo형태의 메모리를 가리키는 참조변수가 100개 만들어지는 것이다.
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	
	// 데이터가 어느 방까지 저장되어 있는지 위치를 저장할 변수
	int curCnt = 0;
	
	// 전화번호 정보 등록하는 메서드
	public void inputData() {
		System.out.println("전화번호 정보 등록을 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth = MenuViewer.keyboard.nextLine();
		
		infoStorage[curCnt++] =  new PhoneInfo(name, phone, birth);
		System.out.println("전화번호 정보 등록이 완료되었습니다.");
	}
	
	// 이름으로 검색하여 전화번호 정보 보여주기
	public void searchData() {
		System.out.println("입력하신 이름에 맞는 전화번호 정보를 보여줍니다.");
		
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("입력하신 이름에 해당하는 자료가 없습니다.");
		} else {
			infoStorage[dataIdx].showPhoneInfo();	// 찾은 방번호에 해당하는 정보를 화면에 보여줌
			System.out.println("데이터 검색이 완료되었습니다.");
		}
	}
	
	// 이름으로 검색하여 전화번호 정보를 수정(삭제)하는 메서드
	public void deleteData() {
		System.out.println("데이터를 삭제합니다.");
		
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("입력하신 이름에 해당하는 자료가 존재하지 않습니다.");
		} else {	// 이름에 해당하는 데이터의 뒷부분을 한칸씩 앞으로 보낸다.
			for(int idx = dataIdx; idx < curCnt; idx++) {
			infoStorage[idx] = infoStorage[idx+1];
			}
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	// 이름에 해당하는 데이터가 배열의 어느 방에 있는지 찾아내는 메서드
	private int search(String name) {
    	System.out.println("현재 위치 ==> " + curCnt);
		for(int idx = 0; idx < curCnt; idx++) {	// 데이터가 있는 곳까지만 검사한다.
			PhoneInfo curInfo = infoStorage[idx];
		//if(name.compareTo(infoStorage[idx].name) == 0)	이렇게 써도 같은 말임
			if(name.compareTo(curInfo.name) == 0) {	// 이름과 같은 값을 배열에서 찾아내면
				return idx;		// 찾은 위치값을 돌려준다.
			}
		}
		// 이름과 같은 값을 찾지 못했다면
		return -1;
	}
	
}
// 작업 메뉴
class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("하시고자 하는 작업에 해당하는 번호를 입력하십시오.");
		System.out.println("1. 전화번호 정보 입력");
		System.out.println("2. 이름으로 전화번호 정보 검색");
		System.out.println("3. 이름으로 전화번호 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
	}
}

public class PhoneBookVer03 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		int choice = 0;;	// 작업 선택을 한 값을 저장할 변수
		
		while(true) {
			
			MenuViewer.showMenu();
			choice = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			
			switch(choice) {
			case 1:	manager.inputData();  // 전화번호 정보 등록
				break;
			case 2:	manager.searchData();// 이름으로 전화번호 정보 검색
				break;
			case 3:	manager.deleteData();// 이름에 해당하는 전화번호 정보 삭제
				break;
			case 0:	// 프로그램 종료
				return;
			}
			
		}

	}

}

