package java_chobo02_ch12;

interface Eatable{}

class Fruit implements Eatable {
	public String toStirng() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {
}

public class Ex12_3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>();
//		FruitBox<Grape> toyBox = new FruitBox<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		grapeBox.add(new Grape());
//		appleBox.add(new Grape());
		System.out.println("fruitBox -" + fruitBox);
		System.out.println("appleBox -" + appleBox);
		System.out.println("grapeBox -" + grapeBox);

	}

}
