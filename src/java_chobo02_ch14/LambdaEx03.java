package java_chobo02_ch14;


@FunctionalInterface
interface MyFunction{
	void myMethod();
}


public class LambdaEx03 {

	public static void main(String[] args) {
		MyFunction2 f = () -> System.out.println("myMethod()");
		aMethod(f);
		aMethod(() -> System.out.println("myTwuomethod()"));
		
	}
	
	public static void aMethod(MyFunction2 f) {
		f.myMethod();
	}

}
