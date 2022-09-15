package flow;

public class Exercise08 {

	public static void main(String[] args) {
		// 회문수(palindrome) : 숫자를 거꾸로 읽어도 앞으로 읽은 것과 같은 수를 말한다.
		// 11111, 12321, 12233221
		
		// 아래의 수가 회문수 인지 아닌지 판별해주세요.
		int number = 13579; // -> 97531로 뒤집어야 비교를 할 수 있다.
		//각 단위별로 잘라내야함.
		int temp = number;	//원본을 복사해서 저장할 변수
		int result = 0;	//주어진 숫자를 작업할 변수
		
		while(temp != 0) {
			result *= 10;	//각 자리의 숫자를 구한 뒤 10씩 곱해서 자릿수를 가지게 해준다.
			// 나머지가 9였으면 10곱해서 90만들어주고 다음 나머지가 7이면 밑줄에서 97만들어주고 다시 10곱해서
			// 970만들고 다음 나머지가 3이면 밑줄에서 973만들어주고 다시 10곱하면 9730 반복
			result = result + temp % 10;	//주어진 숫자를 10으로 나눈 나머지를 구한 후 result에 더해줌.
			temp = temp / 10;	//다음 계산을 위해서 자릿수의 각 숫자를 구하기 위해 단위수 줄이기 반복
		
		}
		System.out.println(result); //result가 제대로 뒤집어졌는지 확인
		if(number == result) System.out.println(number + "는 회문수 입니다.");
		else System.out.println(number + "는 회문수가 아닙니다.");
	}

}
