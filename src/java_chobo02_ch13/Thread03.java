package java_chobo02_ch13;

public class Thread03 implements Runnable {
	static boolean autoSave = false;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (autoSave) {
				autoSave();
			}
		}

	}

	private void autoSave() {
		System.out.println("작업 파일에 자동 저장되었습니다. ");
	}

}
