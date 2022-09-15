package flow;

public class Star05 {

	public static void main(String[] args) {
		// 별 삼각뿔모양
		
		/*for(int i = 5; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print('★');
					if(j < 5){
					System.out.print(" ");
				} 
			}
			System.out.println();
		}*/
		int linenum = 5;	//라인수가 삼각형의 정가운데를 가리킨다.
		int i = 0;
		int j = 0;
		for(i = 0; i < linenum; i++) {
			for(j = linenum - i - 1; j >= 1; j--) {
				System.out.print(" ");
			}
			for(j = 0; j < i * 2+1; j++) {
				System.out.print('★');
			}
			System.out.println();
		}
		
		linenum = 5;
		for(i = 0; i < linenum; i++) {
			for(j = 0; j < linenum - 1 - i; j++) {	// j를 0부터 시작하면 -1을 추가해야한다 // 4321반복
				System.out.print(" ");				// j를 1부터 시작하면 -1을 추가할 필요가 없다.
			}
			for(j = 0; j < i*2+1; j++) {	// 13579순으로 *을 그린다.
				System.out.print("★");			// 1부터 시작해서 2씩 증가시키면서 그린다.
			}
			System.out.println();
		}
	}

}
