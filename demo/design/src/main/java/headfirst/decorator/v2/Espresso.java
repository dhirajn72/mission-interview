package headfirst.decorator.v2;

public class Espresso implements Beverage{
	private String description ;
	Espresso(){
		description = "Espresso";
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double cost() {
		return 2.13;
	}
}
