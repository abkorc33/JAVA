package thread.priority01;	// 쓰레드 우선순위를 자바 버츄얼머신이 판단

class MessageSendingThread extends Thread {
	String message;
	int priority;
	
	public MessageSendingThread(String str) {
		message = str;
	}
	
	public void run() {
		for(int i = 0; i < 10000; i++) {
			// getPriority() 자신의 우선순위를 인지함
			// 너한번 나한번 공평한게 아니라 자바 버츄얼머신이 적절하게 판단
			System.out.println(message + "[" + getPriority() + "]");
		}
	}
}

public class PriorityExamOne {

	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("First");
		MessageSendingThread tr2 = new MessageSendingThread("Second");
		MessageSendingThread tr3 = new MessageSendingThread("Third");

		tr1.start();
		tr2.start();
		tr3.start();
	}

}
