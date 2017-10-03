package myshopingcart.design.decorator;

 // http://www.journaldev.com/1540/decorator-design-pattern-in-java-example

public class DecoratorPatternTest {
	public static void main(String[] args) {
		Car sportcar = new SportsCar(new BasicCar());
		sportcar.assemble();
		System.out.println("\n ****** ");

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}
