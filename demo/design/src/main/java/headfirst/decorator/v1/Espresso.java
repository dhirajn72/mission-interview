package headfirst.decorator.v1;

/**
 *
 */
public class Espresso implements Beverage{
	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}
