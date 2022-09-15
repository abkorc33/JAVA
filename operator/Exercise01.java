package operator;

public class Exercise01 {

	public static void main(String[] args) {
		
		int numOfApples = 134; //사과의 갯수
		int sizeOfBucket = 10; //바구니에 담을 수 있는 사과의 갯수
		
		//필요한 바구니 갯수
		int a = numOfApples / sizeOfBucket;
		int b = ++a;
		System.out.println("필요한 바구니의 갯수는 "+ b + "개");
		
		//필요한 바구니의 개수 + 몫 + (짜투리가 있으면 +1) 선생님풀이
		int numOfBucket = numOfApples / sizeOfBucket
						+ (numOfApples % sizeOfBucket >= 0 ? 1 : 0);
		System.out.println("필요한 바구니의 갯수 : " + numOfBucket);
	}

}
