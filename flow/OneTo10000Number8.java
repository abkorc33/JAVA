package flow;

public class OneTo10000Number8 {

	public static void main(String[] args) {
		/* 1부터 10000까지의 정수 안에 8이라는 숫자가 총 몇번 나오나요?
		 * 888 => 3번, 8088 => 3번, 8888 => 4번 //8이들어간 숫자만 추출 어케함?
		 * 답 : 4000번
		 */
		
		int i =0;
		int temp = 0;
		int count = 0;
		
		for(i = 1; i <= 10000; i++) {
			temp = i;	// i는 변하지않고 반복되야하니까 i의 숫자를 가공하기위해 저장할 변수 필요
			while(temp != 0) {
			if(temp % 10 == 8) count++;	// 임의의 숫자를 10으로 나눈 나머지가 8일때
			temp = temp / 10;	// 0이 되기 전까지 나머지 구하기위해 10단위씩 잘라줌
			}					
		}
		System.out.println(count);	// 수강생 도움받아서 푼 문제
		
		count = 0; // 8이라는 글자의 누적 카운트	//선생님코드
		int wonbon = 0; // num의 값을 임시로 저장하는 변수
		
		for(int num = 1; num <= 10000; num++) {
			wonbon = num;	//작업 대상이 되는 수를 변수에 저장한다,
			while(num >= 10) {
				if(num % 10 == 8) {
					count++;
					num /= 10;
				} else {
					num /= 10;
					continue;
				}
			}
			if(num == 8) {
				count++;
			}
			num = wonbon;
		}
		System.out.println("1 ~ 10000까지 8이라는 숫자가 나오는 횟수 : " + count);
		
	}

}
