package array;

public class ArrayExam10 {

	public static void main(String[] args) {

	int[] oldNum = {1,2,3,4,5};
	int[] newNum = new int[10];
	
	for(int i = 0; i < oldNum.length; i++) {
		newNum[i] = oldNum[i];
	}
	for(int i =0; i <newNum.length; i++) {
		System.out.print(newNum[i] + ", ");
	}

	}

}
