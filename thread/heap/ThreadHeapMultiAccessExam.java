package thread.heap;

class Sum {
	int num;	// 공통으로 쓰는 인스턴스, heap영역
	public Sum() {num = 0;}
	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

class AdderThread extends Thread {
	Sum sumInst;
	int start, end;
	
	public AdderThread(Sum sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	
	public void run() {
		for(int i = start; i <= end; i++) {
			sumInst.addNum(i);
		}
	}
}

public class ThreadHeapMultiAccessExam {

	public static void main(String[] args) {
		Sum s = new Sum();
		AdderThread at1 = new AdderThread(s, 1, 50);
		AdderThread at2 = new AdderThread(s, 51, 100);
		
		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1부터 100까지의 합은 " + s.getNum() + "입니다.");
		// 시스템상의 문제로 제대로 된 합이 안나옴, 왔다갔다 함
		// 연산은 cpu를 이용한다.
		// 서로 읽어오는 과정에서의 미세한 차이가 결과값을 다르게 만든다.
	}

}
