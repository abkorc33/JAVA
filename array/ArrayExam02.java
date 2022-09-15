package array;

public class ArrayExam02 {

	public static void main(String[] args) {
		// 시험 성적 중 가장 높은 점수와 가장 작은 점수는 무엇인가요?
		int[] score = {70, 60, 88, 45, 97, 58};
		
		int max = score[0];	// 배열의 첫 번째 값으로 최대값을 초기화 한다.
		int min = score[0];	// 배열의 첫 번째 값으로 최소값을 초기화 한다.
		
		/*for(int i = score[0]; i <= score[5]; i++) {
			for(int j = score[0]; j < i; j++) {
				max = score[i];
				min = score[j];
			}
		}
		System.out.println(max + ", " + min); */
		
		for(int i = 1; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];	// 값 덮어씌우기
			}
			if(score[i] < min) {
				min = score[i];
			}
		}
		System.out.println(max + ", " + min);

	}

}
