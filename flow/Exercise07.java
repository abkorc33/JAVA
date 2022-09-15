package flow;

public class Exercise07 {

	public static void main(String[] args) {
		// Fibonnaci 수열 : 두 수가 주어지고, 바로 앞의 두 수를 더해서 다음 수를 만든다.
		// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.......
		// 1과 1로 시작하는 피보나치 수열의 10번째 수는?
		
		/*int i = 0;
		int sum = 0;
		
		for(i = 1; i <= 10; i++)
			sum += i+i++;
		System.out.println(i);*/
		
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1 + ", " + num2);
		
		for(int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			System.out.print(", " + num3);
			
			num1 = num2;
			num2 = num3;
		}
		
	}

}
