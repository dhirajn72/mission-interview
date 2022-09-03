package headfirst.methodfactoryabstract;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
	@Override
	public Douge createDough() {
		return new ThinCrustDouge();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new RegginoCheese();
	}

	@Override
	public Veggies[] createVegies() {
		return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clame createClame() {
		return new FreshClame();
	}
}
