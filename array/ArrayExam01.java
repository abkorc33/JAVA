package array;

public class ArrayExam01 {

	public static void main(String[] args) {

	int sum = 0;	// 총점을 저장하기 위한 변수
	int avg = 0;	// 평균을 저장하기 위한 변수
	
	int[] score = {88, 70, 91, 45, 30, 55, 97};
	// score[0] == 88, score[4] == 30
	//sum = score[0]+score[1]+score[2]+score[3]+score[4];
	
	for(int i = 0; i < score.length; i++) {
		sum += score[i];
	}
	avg = sum / score.length;
	
	System.out.println("총점 : " + sum);
	System.out.println("평균 : " + avg);
	}

}
