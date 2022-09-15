package operator;

public class OperatorExam02 {

	public static void main(String[] args) {
		
		int i = 5;
		int j = 0;
		j = i++;
		System.out.println("j = i++ 를 실행한 후 i=" + i + ", j=" + j);
		
		i = 5;
		j = 0;
		j = ++i;
		System.out.println("j = ++i 를 실행한 후 i=" + i + ", j=" + j);

	}

}
