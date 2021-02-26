package java_chobo02_ch16;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URlClasseEx {

	public static void main(String[] args) throws MalformedURLException {
//		getURL();
		String address = "https://sports.news.naver.com/index.nhn";
			

			try {
				URL url = new URL(address);
				URLConnection conn = url.openConnection();
				System.out.println("conn.toString():" + conn);
				System.out.println("getAllowUserInteraction():" + conn.getAllowUserInteraction());
				System.out.print("\tgetConnectTimeout():" + conn.getConnectTimeout());
				System.out.println("getContent():" + conn.getContent());
				System.out.println("getContentEncoding():" + conn.getContentEncoding());
				System.out.print("\tgetContentLength():" + conn.getContentLength());
				System.out.println("getContentType():" + conn.getContentType());
				System.out.print("\tgetDate():" + conn.getDate());
				System.out.println("getDefaultAllowUserInteraction():" + conn.getDefaultAllowUserInteraction());
				System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
				System.out.print("\tgetDoInput():" + conn.getDoInput());
				System.out.println("getDoOutput():" + conn.getDoOutput());
				System.out.print("\tgetExpiration():" + conn.getExpiration());
				System.out.println("getHeaderFields():" + conn.getHeaderFields());
				System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
				System.out.print("\tgetLastModified():" + conn.getLastModified());
				System.out.println("getReadTimeout():" + conn.getReadTimeout());
				System.out.println("getURL():" + conn.getURL());
				System.out.println("getUseCaches():" + conn.getUseCaches());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // main
	
		
	

	public static void getURL() throws MalformedURLException {
		URL url = new URL("http://www.codechobo.com:80/sample/"
				+"hello.html?referer=codechobo#index1");
		
		System.out.println("url.getAuthority() : " + url.getAuthority());
//		System.out.println("url.getContent():" + url.getContent());
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort());
		System.out.println("url.getPort() : " + url.getPort());
		System.out.println("url.getFile() : " + url.getFile());
		System.out.println("url.getHost() : " + url.getHost());
		System.out.println("url.getPath() : " + url.getPath());
		System.out.println("url.getProtocol() : " + url.getProtocol());
		System.out.println("url.getQuery() : " + url.getQuery());
		System.out.println("url.getRef() : " + url.getRef());
		System.out.println("url.getUserInfo() : " + url.getUserInfo());
		System.out.println("url.toExternalForm() : " + url.toExternalForm() );
//		System.out.println("utl.toURI() : " + url.toURI());
	}

}
