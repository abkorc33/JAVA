package array;

public class ArrayExercise02 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		// 3300원이 낼 수 있는 최대금액
		int[] coinUnit = {500, 100, 50, 10};	// 동전의 종류
		int[] coin = {5, 5, 5, 5};		// 동전 단위별 개수
		
		System.out.println("동전으로 교환할 금액은 얼마인가요?");
		int myMoney = sc.nextInt();
		// 남은 동전의 개수, 거스르고 남은 돈?
	
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;	// 동전의 개수를 저장할 변수
			// 금액을 동전 단위로 나누어서 필요한 동전의 개수를 구한다.
			coinNum = myMoney / coinUnit[i];	 //사용한 동전 갯수
			// 동전의 개수가 모자란다면 있는만큼만 거슬러준다.
			if(coin[i] >= coinNum) {
				coin[i] -= coinNum;
			}else {
				coinNum = coin[i];	// 5개가 최대니까 coinNum에 coin[i]값을 덮어 씌움
				coin[i] = 0;	// 남은 동전의 갯수를 0으로 만들어줌
			}
			// 금액에서 동전의 개수x동전 단위만큼 차감한다.
			myMoney -= coinNum * coinUnit[i];	//myMoney 빼기 (사용한 동전개수x동전의가격) = 남은금액
			System.out.println(coinUnit[i] + "원 : " + coinNum + "개");
		}
		System.out.println("남은 금액 : " + myMoney + "원");
		System.out.println("남은 동전의 개수");
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i] + "개");
		}
	}

}
