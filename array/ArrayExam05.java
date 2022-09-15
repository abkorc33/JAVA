package array;

public class ArrayExam05 {

	public static void main(String[] args) {
		// 작은 숫자가 왼쪽에 오도록 정렬해주세요.

	int[] number = new int[10];
	int count = 0;
	// boolean changed = false;		// boolean타입으로 풀기
	
	for(int i = 0; i < number.length; i++) {
		System.out.print(number[i] = (int)(Math.random() * 10));	//중복될 수 있음
	}
	System.out.println();
	
	// (세로방향) 전체 작업은 2개씩 비교하므로, number.length보다 1 작은 만큼한다.
	for(int i = 0; i < number.length; i++) {
	// (가로방향) number.length보다 1작은 만큼 작업을 하는데
	// 한번 작업이 끝나면 작업 횟수를 1씩 감소시킨다.
	// for문에 해당하는 number방의 값이 다음 값과 같으면 서로 값을 바꾼다.
	// 배열에 변화가 일어나지 않으면 반복문 멈추기
		for(int j = 0; j < number.length-1-i; j++) {	//작업이 끝난 방은 다음 작업에서 제외시킨다.(-i)
			if(number[j] > number[j+1]) {	// number[j]의 값이 number[j+1]의 값보다 크면 교환한다.
				int imsi = number[j];
				number[j] = number[j+1];
				number[j+1] = imsi;
				count++;		// 변화가 생기는걸 체크하기 위함.
				//changed = true;
			}
		}
		//if(!changed) break;	//자리바꿈이 없으면 반복문을 벗어난다.
		if(count == 0) {	// 숫자 자리바꿈이 진행되는 for문 밖에 count가 들어간 if문을 넣어야된다.
			break;		// 변화가 없으면 break
		} else {
			count = 0;	// count에 0을 넣어서 초기화시킴.
		}
		// 작업이 모두 끝나면 정렬된 결과 출력.
		for(int k = 0; k < number.length; k++) 
			System.out.print(number[k]);
			System.out.println();
	}
	
	}

}
