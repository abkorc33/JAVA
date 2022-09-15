package object;

import java.util.Scanner;

public class Exam {
	
	public static void main(String[] args) {
		// 1 ~ 9 사이의 랜덤한 네자리의 수를 선정해서 사용자가 5회 입력
		// 각 자리의 위치와 숫자가 일치하면 strike
		// 자리는 맞지 않지만 숫자는 존재하면 ball
		// 총 5회의 기회, 중간에 제대로 수를 맞추면 종료, 5번 기회가 지나도 종료.
		// 회차마다 스트라이크와 볼 표시는 옵션.
		// 랜덤 네자리 숫자, 숫자 자릿수 떼고 하나씩 보는것, 조건(일치,불일치), 반복문
		
		Scanner sc = new Scanner(System.in);
		int[] num = new int[4];
		int[] num2 = new int[4];
		for (int i = 0; i < 4; i++) {
			num[i] = (int)(Math.random() * 9 + 1);
			if(i > 0) {
				for(int k = 0; k < i; k++) {
					if(num[i] == num[k]) {
						i--;
						break;
					}
				}
			}
		}
		while (true) {
			int choice = 0;
			int count = 0;
			int chance = 5;
			int strike = 0;
			int ball = 0;
			System.out.println("Game Start! 기회는 " + chance + "번");
			while (true) {
				System.out.println("얼마를 입력하시겠습니까?");
				choice = sc.nextInt();
				int length = (int)(Math.log10(choice) + 1);
				if(length != 4) {
					System.out.println("숫자 4자리를 입력해주세요.");
				}else {
					strike = 0;
					ball = 0;
					for(int i = 3; i > -1; i--) { //입력 숫자 절삭하면 거꾸로 배치되니까
						// 애초에 배열 끝에서부터 저장하면 입력한 그대로 하나씩 배열에 저장됨
						int temp = choice;
						num2[i] = temp % 10;
						choice /= 10;
					}
					for (int i = 0; i < 4; i++) {
						for(int j = 0;j < 4; j++) {
							if(num[i] == num2[j] && i == j) {	//숫자일치, 배열일치
								strike++;
							} else if(i != j && num[i] == num2[j]) {//숫자일치, 배열 다름
								ball++;
							}
						}
					}
					count++;
					System.out.println("Strike : " + strike + "개\tBall : " + ball + "개\t남은기회 : " + (chance - count) + "번");
				}
				if(count == chance && strike != 4) {
					System.out.println("모든 기회를 사용하셨습니다!");
					System.out.println("정답은");
					for(int i = 0; i < 4; i++) {
						System.out.print(num[i]);
					}
					System.out.println("입니다.");
					System.out.println("다시하려면 1번, 게임을 종료하려면 아무 숫자나 눌러주세요.");
					int yes = sc.nextInt();
					if (yes == 1) {
						count = 0;
						for (int i = 0; i < 4; i++) {
							num[i] = (int) (Math.random() * 9 + 1);
							if (i > 0) {
								for (int k = 0; k < i; k++) {
									if (num[i] == num[k]) {
										i--;
										break;
									}
								}
							}
						}
						continue;	// 얼마를 입력하시겠습니까로 올라감
					} else {
						break;
					}
				} else if (strike == 4) {
					System.out.println("정답입니다!");
					System.out.println("다시하려면 1번, 게임을 종료하려면 아무 숫자나 눌러주세요.");
					int yes = sc.nextInt();
					if (yes == 1) {
						count = 0;
						for (int i = 0; i < 4; i++) {
							num[i] = (int) (Math.random() * 9 + 1);
							if (i > 0) {
								for (int k = 0; k < i; k++) {
									if (num[i] == num[k]) {
										i--;
										break;
									}
								}
							}
						}
						continue;
					} else {
						break;
					}
				}
				ball = 0;
				strike = 0;
			}
			break;
		}
		sc.close();
	
		
	}
}
