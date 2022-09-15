package network;	// 페이지 소스 자바 콘솔창에 가져오기

import java.net.*;
import java.io.*;	// io는 input output

public class NetworkExam03 {

	public static void main(String[] args) {
		
		URL url = null;
		BufferedReader input = null;
		
		String address = "https://comic.naver.com/index";
		String line = "";
		
		try {
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			// input으로부터 데이터를 읽음
			while((line = input.readLine()) != null) {
			// 한 줄씩 읽음, not null일 때까지
			System.out.println(line);
			}
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
