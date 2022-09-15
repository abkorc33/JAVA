package flow;

public class Exercise09 {

	public static void main(String[] args) {
		// 이름 국어 영어 수학 총점 평균
		String name = "방자";
		int kor = 97;
		int eng = 56;
		int mat = 80;
		
		int total = kor+eng+mat;
		int avg = kor+eng+mat/3;
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("===============================================");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+total+"\t"+avg);

	}

}
