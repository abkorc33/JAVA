package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// 키보드로 입력한 문자열을 서버로 전송하는 클래스(전송하는 입장이므로 대기할 필요 없어서 그냥 클래스로만듬)
class WriteClass {
	Socket socket;
	ClientFrame cf;
	String str;
	String id;
	
	// 생성자
	public WriteClass(ClientFrame cf) {
		this.cf = cf;
		this.socket = cf.socket;
	}
	
	// 입력한 메세지를 전송하는 메서드
	public void sendMsg() {
		// 키보드로부터 읽어오기 위한 스트림객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		
		try {
			// 서버로 문자열을 전송하기 위한 스트림객체를 생성한다.
			pw = new PrintWriter(socket.getOutputStream(),true);
			
			// 전송할 첫번째 데이터는 id이다. 상대방에게 id와 함께 나의 ip주소를 전송한다.
			if(cf.isFirst == true) {	// 처음 접속한 경우
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				getId();
				
				str = "[" + id + "] 님 로그인 (" + ip + ")";
			} else {	// 처음 접속이 아닌 경우
				str = "[" + id + "] " + cf.txtF.getText();	// 아이디 + 입력한 내용
			}
			
			// 문자열을 서버로 보낸다.
			pw.println(str);
			
		} catch(IOException ie) { 
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br != null) br.close();	// 메모리 잡아먹으므로 사용 후 닫아줌
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
	
	// id(로그인시 기술한 아이디)를 가져오는 메서드
	public void getId() {
		id = Id.getId();
	}
	
}

// 서버가 보내온 문자열을 전송받는 쓰레드(항상 대기해야하므로 쓰레드로 만듬)
class ReadThread extends Thread {
	Socket socket;
	ClientFrame cf;
	
	// 생성자
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf = cf;
		this.socket = socket;
	}
	
	// run()
	public void run() {
		BufferedReader br = null;
		
		try {
			// 서버로부터 전송된 문자열을 읽어오기 위한 스트림 객체
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				// 소켓으로부터 문자열을 읽어온다.
				String str = br.readLine();
				if(str == null) {
					System.out.println("접속이 끊겼습니다.");
					break;
				}
				// 서버로부터 전송받은 문자열을 화면에 출력한다.
				cf.txtA.append(str + "\n");
			}
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				// 열려있는 자원을 닫는다.
				if(br != null)	br.close();// 데이터베이스 다썼으면 닫아주기
				if(socket != null)	socket.close();
			} catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
	
}

public class MultiChatClient {

	public static void main(String[] args) {
		Socket socket = null;
		ClientFrame cf;
		
		try {
			// 클라이언트는 접속할 서버의 IP주소와 포트정보로 소켓을 생성해서 서버에 연결을 요청한다.
			socket = new Socket("127.0.0.1", 7000);
			System.out.println("연결 성공");
			
			// 연결이 되었으므로 대화를 나눌 화면을 준비한다.
			cf = new ClientFrame(socket);
			new ReadThread(socket, cf).start();
			
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
