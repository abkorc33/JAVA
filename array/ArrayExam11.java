package array;

public class ArrayExam11 {

	public static void main(String[] args) {
		
		char[] abc = {'A', 'B', 'C', 'D'};	// abc.length
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};	// num.length
		
		char[] result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
			//읽어올배열, 읽어올배열의 시작위치, 기록할배열, 기록할 배열의 쓰여질 위치, 기록할길이
		
		System.arraycopy(num, 0, result, abc.length, num.length);	// abc.length가 끝난 뒤에 num을 붙일 것이기 때문에
		System.out.println(new String(result));					// 위치 자리에 abc.length가 오는 것.

	}

}
