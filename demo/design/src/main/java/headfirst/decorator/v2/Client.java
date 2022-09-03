package headfirst.decorator.v2;

public class Client {
	public static void main(String[] args){
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() +" : "+ beverage.cost());

		Beverage beverage1 = new HomeBlend();
		beverage1 = new Mocha(beverage1);
		beverage1 = new Soy(beverage1);
		System.out.println(beverage1.getDescription() + " : " + beverage1.cost());
	}
}
