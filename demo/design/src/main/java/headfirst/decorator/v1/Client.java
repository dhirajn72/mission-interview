package headfirst.decorator.v1;

public class Client {
	public static void main(String[] args){

		/**
		 * Get me Espresso coffe with Mocha and Soy.
		 */
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() +" : " + beverage.cost()); // Only Espress here,
		beverage = new Mocha(beverage); // Added mocha to the espresso
		beverage = new Soy(beverage); // Added Soy to the espresso and Mocha
		System.out.println(beverage.getDescription() +" : " + beverage.cost());

		System.out.println("--------------");

		/**
		 * Get me HouseBlend with only soy and not mocha
		 */
		Beverage beverage1 = new HouseBlend();
		System.out.println(beverage1.getDescription() +" : "+ beverage1.cost());
		beverage1 = new Soy(beverage1); // Here it is !
		System.out.println(beverage1.getDescription() +" : "+ beverage1.cost());
	}
}
