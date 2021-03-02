package java_chobo02_ch14;

import java_chobo02_ch14.LambdaInterClass.LambdaInter1;
import java_chobo02_ch14.LambdaInterClass.LambdaInter2;
import java_chobo02_ch14.LambdaInterClass.LambdaInter3;
import java_chobo02_ch14.LambdaInterClass.LambdaInter4;


	

interface LambdaInter{
	 int max(int a, int b);
}

class LambdaInterClass implements LambdaInter{

	@Override
	public int max(int a, int b) {
		return a > b? a : b;
	}
	
interface LambdaInter1{
	void printVar(String name, int i);
	
}
interface LambdaInter2{
	int square(int x);
}

interface LambdaInter3{
	int roll();
}

interface LambdaInter4{
	int sumArr(int[] arr);
}


}

public class LambdaEx01 {
	public static void main(String[] args) {
		
		LambdaInterClass lic = new LambdaInterClass();
		int c = lic.max(5, 4);
		System.out.println("max = " + c);
		
		
		
		
		LambdaInter lbi = (i, j) ->  i > j ? i : j;
		
		int b = lbi.max(5, 3);
		System.out.println("max = "+ b);
		
		LambdaInter1 lbi1 = (String name, int i) -> {System.out.println(name + " : " + i);};
		lbi1.printVar("김상건", 5);
		
		LambdaInter1 lbi2 = (String name, int i) -> {System.out.println(name + " : " + i);};
		lbi1.printVar("이나연", 15);
		
		LambdaInter1 lbi3 = (String name, int i) -> System.out.println(name + " : " + i);
		lbi1.printVar("신범건", 25 );
		
		LambdaInter2 lbi4 = (int x) -> x * x;
		LambdaInter2 lbi5 = x -> x * x;
		System.out.println("square  : " + lbi4.square(5));
		System.out.println("square  : " + lbi5.square(3));
		
		LambdaInter3 lbi6 = () -> {return (int)(Math.random() *6 );};
		LambdaInter3 lbi7 = () -> (int)(Math.random() *6 );
		
		System.out.println("random : " + lbi6.roll());
		System.out.println("random : " + lbi7.roll());
		
		LambdaInter4 lbi8 = (int[] arr) -> {
			int sum = 0;
			for(int i : arr) sum +=i;
			return sum;
		};
		
		System.out.println(lbi8.sumArr(new int[] {1,2,3,4,5,6,7,8,9,10}));
	}

}
