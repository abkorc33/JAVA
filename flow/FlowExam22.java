package flow;

public class FlowExam22 {

	public static void main(String[] args) {
		
		for(int i =2; i <= 9; i++) {
			Loop1: for(int j = 1; j <= 9; j++) {
				if(j == 5)
					//break Loop1; //5단 전까지만 표시됨
					continue Loop1; //각 단의 5단만 빠짐, Loop잘 안씀
				System.out.print(i + "x" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}

	}

}
