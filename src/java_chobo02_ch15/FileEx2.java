package java_chobo02_ch15;

import java.io.File;

import javax.swing.JFileChooser;

public class FileEx2 {
	public static void main(String[] args) {
		
		File f = getSearchFile();
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유요하지 않은 디렉터리입니다. ");
			System.exit(0);
		}
		File[] files = f.listFiles();
		for(File file : files) {
			System.out.println(file.isDirectory() ? "[" +file.getName() + "]" : file.getName());
		}
	}
	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int res = jfc.showOpenDialog(null);
		File file = null;
		if(res == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
		}
		return file;
	}
}
