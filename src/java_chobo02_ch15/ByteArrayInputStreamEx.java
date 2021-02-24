package java_chobo02_ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class ByteArrayInputStreamEx {

	public static void main(String[] args) {

		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
		byte[] outSrc = null;
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
		int data = 0;
		
		while( (data = bais.read()) != -1) {
			baos.write(data);
			
		}
		outSrc = baos.toByteArray();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
		
		
	}

}
