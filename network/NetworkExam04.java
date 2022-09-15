package network;	// 읽은 페이지 소스를 파일로 내보내기

import java.net.*;
import java.io.*;

public class NetworkExam04 {

	public static void main(String[] args) {
		
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		
		String address = "https://comic.naver.com/index";
		int ch = 0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("webtoon.txt");
			
			while((ch = in.read()) != -1) {
				out.write(ch);  // 2진 데이터를 읽어서 쓴다 ch에
			}
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
