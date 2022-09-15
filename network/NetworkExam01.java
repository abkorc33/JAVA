package network;

import java.net.*;
import java.util.*;

public class NetworkExam01 {

	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() => " + ip.getHostName());
			System.out.println("getHostAddress() => " + ip.getHostAddress());
			System.out.println("toString() => " + ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() => " + Arrays.toString(ipAddr));
			
			String result = "";
			for(int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			System.out.println("getAddress() + 256 => " + result);
			System.out.println();
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() => " + ip.getHostName());
			System.out.println("getHostAddress() => " + ip.getHostAddress());
			System.out.println();
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] => " + ipArr[i]);
			}
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
/*
getHostName() => www.naver.com
getHostAddress() => 23.196.172.185
toString() => www.naver.com/23.196.172.185
getAddress() => [23, -60, -84, -71]
getAddress() + 256 => 23.196.172.185.

getHostName() => DESKTOP-34RD8QL
getHostAddress() => 192.168.4.177

ipArr[0] => www.naver.com/23.196.172.185*/
