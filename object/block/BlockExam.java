package object.block;

public class BlockExam {
	
	static {	// 클래스 초기화 블럭
		System.out.println("클래스 초기화 블럭입니다.");
	}
	
	{	// 인스턴스 초기화 블럭
		System.out.println("인스턴스 초기화 블럭입니다.");
	}
	
	BlockExam() {	// 생성자
		System.out.println("생성자 입니다.");
	}

	public static void main(String[] args) {
		System.out.println("첫번째 BlockExam 클래스를 생성합니다.");
		BlockExam be1 = new BlockExam();
		
		System.out.println("두번째 BlockExam 클래스를 생성합니다.");
		BlockExam be2 = new BlockExam();
		
	}

}
