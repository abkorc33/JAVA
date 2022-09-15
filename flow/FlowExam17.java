package flow;

public class FlowExam17 {

	public static void main(String[] args) {
		// i값을 1씩 증가시키면서 누적을 시켜나갔을 때,
		// 1부터 몇까지 더하면 누적합계가 100을 넘지않는 제일 큰 수가 되는지 계산
		// while문을 사용해서 만들기
		int sum = 0;	//누적된 값을 저장할 변수
		int i = 0;		//1씩 증가시키는데 사용할 변수
		
		while(sum + i < 100) {
			sum += ++i; // sum = sum + ++i;		//sum이 100보다 작은게 조건인데 나온 이유
			System.out.println(i + "=>" + sum); //이 식이 끝난 순간 91이 값으로, 100을 안넘어서
												//한 번 더 반복하러 간 것.
		}
		//System.out.println(i + "=>" + sum);
	}

}
