package network;

import java.net.*;

public class NetworkExam02 {

	public static void main(String[] args) throws Exception {	
		// 메인 메서드에서 어떤 예외가 발생하더라도 네가 알아서 처리해라 throw, 던져버림
		URL url = new URL("https://home.ebs.co.kr/ebsnews/menu1/newsAllView/60248845/N?eduNewsYn=N&newsFldDetlCd=");
		
		System.out.println("url.getAuthority() : " + url.getAuthority());
		System.out.println("url.getContent() : " + url.getContent());
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort());
		System.out.println("url.getPort() : " + url.getPort());
		System.out.println("url.getFile() : " + url.getFile());
		
		System.out.println("url.getHost() : " + url.getHost());
		System.out.println("url.getPath() : " + url.getPath());
		System.out.println("url.getProtocol() : " + url.getProtocol());
		System.out.println("url.getQuery() : " + url.getQuery());
		System.out.println("url.getRef() : " + url.getRef());
		
		System.out.println("url.getUserInfo() : " + url.getUserInfo());
		System.out.println("url.toExternalForm() : " + url.toExternalForm());
		System.out.println("url.toURI() : " + url.toURI());
	}

}
/*
url.getAuthority() : home.ebs.co.kr
url.getContent() : sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@5b94b04d
url.getDefaultPort() : 443
url.getPort() : -1
url.getFile() : /ebsnews/menu1/newsAllView/60248845/N?eduNewsYn=N&newsFldDetlCd=
url.getHost() : home.ebs.co.kr
url.getPath() : /ebsnews/menu1/newsAllView/60248845/N
url.getProtocol() : https
url.getQuery() : eduNewsYn=N&newsFldDetlCd=
url.getRef() : null
url.getUserInfo() : null
url.toExternalForm() : https://home.ebs.co.kr/ebsnews/menu1/newsAllView/60248845/N?eduNewsYn=N&newsFldDetlCd=
url.toURI() : https://home.ebs.co.kr/ebsnews/menu1/newsAllView/60248845/N?eduNewsYn=N&newsFldDetlCd=
*/
