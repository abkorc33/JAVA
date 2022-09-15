package object;

public class ReturnExam {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 3;
		
		ReturnExam re = new ReturnExam();
		int result = re.plus(num1, num2);
		System.out.println("더하기 결과 : " + result);
		
		int max = re.max(num1,  num2);
		System.out.println(num1 + "과 " + num2 + " 중 " + max + "이 더 큰 수 입니다.");
	}
	
	int plus(int num1, int num2) {	//지역변수
		return num1 + num2;
	}
	
	int max(int num1, int num2) {	//지역변수
		// if(num1 > num2) return num1;
		// else			return num2;
		int result = 0;
		if(num1 > num2) result = num1;
		else 			result = num2;
		return result;	//코드는 늘어났지만, 리턴값은 가능한 한번만 나오는게 좋다.
	}

}
