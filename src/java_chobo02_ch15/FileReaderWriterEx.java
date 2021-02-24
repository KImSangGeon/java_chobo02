package java_chobo02_ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterEx {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		fileReaderWriterEx();
		try(FileReader fr = new FileReader("output2.properties");
				BufferedReader br = new BufferedReader(fr, 8192);
				
				FileWriter fw = new FileWriter("test.properties");
				BufferedWriter bw = new BufferedWriter(fw, 8192)
		){
			String line; 
			while((line = br.readLine())!= null) {
				bw.write(line);
				bw.newLine();
			}
			
		}
	}

	public static void fileReaderWriterEx() {
		try(FileReader fr = new FileReader("output.xml");
				FileWriter fw = new FileWriter("test.xml")){
			char[] cbuf = new char[512];
			while((fr.read(cbuf)) != -1) {
				fw.write(cbuf);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("해당 파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}