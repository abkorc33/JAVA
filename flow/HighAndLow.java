package flow;

import java.util.Scanner;

public class HighAndLow {

	public static void main(String[] args) {
		// 1 ~ 100 사이의 임의의 정수값을 추출해서 answer에 저장한다.
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0;	//사용자가 입력한 값을 저장할 변수
		int count = 0;	//사용자가 정답을 맞추기 위해 시도한 횟수를 저장할 변수

		//화면으로부터 사용자가 입력한 값을 받기 위해서 Scanner클래스를 사용한다.
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.println("게임을 진행하시겠습니까? 1.시작 0.종료");
			input = s.nextInt();
			
			if(input == 1) {
				System.out.println("Game Start");
			} else if(input == 0) {
				System.out.println("게임이 종료되었습니다.");
				break;
			} else {
				System.out.println("0이나 1을 입력해주세요.");
				break;
			}
			
			while(true) {
				System.out.print("1과 100사이의 정수를 입력하십시오. : ");
				input = s.nextInt();
				count++;	//게임이 시작되었으므로 게임 횟수를 1증가시킨다.
				System.out.println("내가 입력한 수는 " + input + "입니다.");
				
				if(answer > input) {
					System.out.println("더 큰 수를 입력하세요.");
				} else if(answer < input) {
					System.out.println("더 작은 수를 입력하세요.");
				} else {
					System.out.println("정답");
					System.out.println("시도한 횟수 :" + count + " 번 입니다.");
					break;
				}
			}
		}
		s.close();
	}
	
	}

