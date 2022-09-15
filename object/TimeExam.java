package object;

class Time {
	private int hour;
	private int minute;
	private int second;
	
	Time(int hour, int minute, int second) {	// 밑에 get, set메서드 만들어놨기 때문에 이런식으로 사용 가능
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public int getHour() {	// 시간을 알아내는 메서드, get은 매개변수 없고 리턴값이 있다
		return hour;
	}
	public void setHour(int hour) {	// 시간을 변경하는 메서드, set은 매개변수가 있고 리턴값이 없다. 
		// 시간의 범위(0 ~ 23)을 초과하는 값이 들어온다면
		if(hour < 0 || hour > 23) return;	// or로 묶어줘야함
		this.hour = hour;
	}
	// 우클릭 -> source -> Generate getters and setters선택 -> 멤버변수들 클릭 -> Generate
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0 || minute > 59) return;
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0 || second > 59) return;
		this.second = second;
	}
	// 우클릭 -> source -> Generate toString()선택 -> 멤버변수들 클릭 -> Generate
	// @ Annotation어노테이션, 컴파일 될 때 컴파일러에게 오버라이딩 된 것이라고 알려주는 역할
	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	
}

public class TimeExam {	// 클래스에 붙는 public은 하나밖에 없다. 주축이 되는 클래스에만 붙임
	// 하나의 소스파일(*.java)에는 public 클래스가 단 하나만 존재할 수 있으며,
	// 소스파일의 이름은 반드시 public 클래스의 이름과 같아야한다.

	public static void main(String[] args) {
		
		Time t = new Time(12, 40, 51);
		//System.out.println(t); toString해주지 않으면 주소값이 나옴
		
		t.setMinute(t.getMinute()-3);  // 기본 입력 값에 minute만 시간을 수정하고싶을 때

		System.out.println(t);
	}

}
