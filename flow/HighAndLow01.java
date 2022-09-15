package flow;

import java.util.Scanner;

public class HighAndLow01 {

	public static void main(String[] args) {
		// 1 ~ 100 사이의 임의의 정수값을 추출해서 answer에 저장한다.
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0;	//사용자가 입력한 값을 저장할 변수
		int count = 0;	//사용자가 정답을 맞추기 위해 시도한 횟수를 저장할 변수
		int startYN = 0;
		//화면으로부터 사용자가 입력한 값을 받기 위해서 Scanner클래스를 사용한다.
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			System.out.println("============");
			System.out.println("숫자 맞추기 게임");
			System.out.println("0. 종료");
			System.out.println("1. 시작");
			System.out.println("============");
			
			startYN = s.nextInt();
			if(startYN == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			}else if(startYN != 1) {
				System.out.println("잘못된 번호를 입력하셨습니다. \n다시 선택하십시오.");
				continue;
			}
			do {
				count++; //게임이 시작되었으므로 게임 횟수 1증가
				System.out.println("1과 100사이의 정수를 입력하십시오. : ");
				input = s.nextInt();
				System.out.println("내가 입력한 수는 " + input + "입니다.");
				if(answer > input) {
					System.out.println("더 큰 수를 입력하세요.");
				} else if (answer < input) {
					System.out.println("더 작은 수를 입력하세요.");
				} else {
					System.out.println("정답");
					System.out.println("시도한 횟수 :" + count + " 번 입니다.");
					break;
				}
			} while(true);
		}while(startYN != 0);
		s.close();
		
		}
	
	}