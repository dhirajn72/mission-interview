package headfirst.decorator.v2;

public class HomeBlend implements Beverage{
	private String description;
	HomeBlend(){
		description = "Home Blend Coffe";
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double cost() {
		return 3.12;
	}
}
