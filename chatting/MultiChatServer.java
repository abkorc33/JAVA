package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// 클라이언트로부터 전송된 문자열을 받아서 다른 클라이언트들에게 문자열을 보내주는 쓰레드
class EchoThread extends Thread {
	
	Socket socket;
	Vector<Socket> vec;
	
	// 생성자를 통해서 접속한 클라이언트의 정보를 받는다.
	public EchoThread(Socket socket, Vector<Socket> vec) {
		this.socket = socket;
		this.vec = vec;
	}
	
	// run메소드(main과 같음), 메세지를 주고 받는 역할
	public void run() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = null;
			
			// 서버니까 상대방이 끊기전에 끊어지면 안됨
			while(true) {
				// 클라이언트로부터 문자열을 받는다.
				str = br.readLine();
				
				// 상대가 접속을 끊으면 break;
				if(str == null) {
					// 접속이 끊어진 클라이언트를 벡터에서 제거한다.
					vec.remove(socket);
					break;
				}
				// 연결된 소켓들을 통해서 다른 클라이언트들에게 문자열을 보내준다.
				sendMsg(str);
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
	
	// 클라이언트로 부터 전송받은 문자열을 다른 클라이언트들에게 전송하는 메서드
	public void sendMsg(String str) {
		
		try {// 향상된 for문, vec에 데이터가 있으면 socket에 집어넣기를 반복
			for(Socket socket:vec) {
				// for문을 돌되 현재의 socket(this.socket)이 문자열을 보낸 클라이언트인 경우를 제외하고
				// 나머지 socket들에게만 문자열을 보낸다.
				if(socket != this.socket) {	// 현재 쓰레드와 접속된 소켓이 아닌 경우
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
					pw.println(str);
					pw.flush();// 라인안에 있는걸 밀어낸다
					// 단, 여기서 구한 소켓들은 접속한 클라이언트가 아니라 남의 것들이기 때문에
					// 여기서 소켓을 닫으면 안된다.
				}
			}	
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
	
}

public class MultiChatServer {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		// 클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터객체를 생성한다.
		Vector<Socket> vec = new Vector<Socket>();	// 키와 값으로 이루어진 vector
		
		try {
			server = new ServerSocket(7000);	// 7000은 포트
			
			while(true) {
				System.out.println("접속 대기중.....");
				socket = server.accept();	// 대기하다가 값이 들어오면 소켓에 넣음
				
				// 클라이언트와 연결된 소켓을 벡터에 담는다.
				vec.add(socket);
				// 쓰레드를 생성해서 연결된 클라이언트와 통신하도록 한다.
				new EchoThread(socket, vec).start();
			}
			
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
