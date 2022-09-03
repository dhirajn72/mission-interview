package headfirst.decorator.v1;

public class HouseBlend implements Beverage{
	@Override
	public String getDescription() {
		return "House Blend Coffe";
	}

	@Override
	public double cost() {
		return .99;
	}
}
