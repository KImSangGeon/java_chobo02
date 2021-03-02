package java_chobo02_ch14;

@FunctionalInterface
interface MyFunction2{
	void  run();
}


public class LambdaEx14_1 {
	static void execute(MyFunction2 f) {
		f.run();
	}
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}

	
	public static void main(String[] args) {
		MyFunction f1 = ()-> System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() {
			public void run() {
				System.out.println("f2.run()");
			}
		};
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()"));
		
	}

}
