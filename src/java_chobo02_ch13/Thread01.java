package java_chobo02_ch13;

public class Thread01 extends Thread {
	@Override
	public void run() {
		super.run();
	for(int i = 0; i < 10; i++) {
		System.out.println(getName() + " ");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}
