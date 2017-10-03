package pattern.decorator;

public class DecoratorPatternTest {

	public static void main(String[] args) {
	   Pizza panPizza = new PanPizza();
	   panPizza = new Tomatos(panPizza);
	   panPizza = new Onion(panPizza);
	   
		System.out.println("Pan Pizza Cost " + panPizza.cost());
	}

}
