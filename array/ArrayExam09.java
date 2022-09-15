package array;

public class ArrayExam09 {

	public static void main(String[] args) {	// score.length 는 row의 갯수, 
		int[][] score = {						// score[2].length // 2번째 방의 크기를 의미한다
				{30, 40, 50},	// 1번 학생의 국영수 점수
				{60, 70, 80},	// 2
				{55, 65, 45},	// 3
				{88, 91, 30},	// 4
				{30, 45, 92},	// 5
		};
		int korTotal = 0;
		int engTotal = 0;
		int matTotal = 0;
		int sum = 0;
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균\t");
		System.out.println("===============================================");
		
		// 학생 수만큼 작업한다.
		for(int i = 0; i < score.length; i++) {
			korTotal += score[i][0];
			engTotal += score[i][1];
			matTotal += score[i][2];
			System.out.print(i+1+"\t");
			
			// 학생 한명이 가지고 있는 점수들을 모두 작업한다.
			for(int j = 0; j < score[i].length; j++) {
				 System.out.print(score[i][j] + "\t");
				 sum += score[i][j];
				 }
				 System.out.println(sum + "\t"+ sum/score[i].length);
				 sum = 0;
				 }
				System.out.println("===============================================");
				System.out.print("총점:\t"+korTotal+"\t"+engTotal+"\t"+matTotal+"\t");
				
	}

}
