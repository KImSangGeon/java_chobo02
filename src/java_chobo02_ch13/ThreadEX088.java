package java_chobo02_ch13;

class Thread05 extends Thread {
	@Override
	public void run() {
		while (!isInterrupted()) {
			System.out.println("a");
		}
		System.out.println("end");
	}
}

public class ThreadEX088 {
	public static void main(String[] args) throws InterruptedException {
		Thread05 t = new Thread05();
		t.start();
		
		Thread.sleep(3000);
		t.interrupt();
	}
}
