package headfirst.methodfactoryabstract;

public class ClamePizza extends Pizza{
	private PizzaIngredientFactory ingredientFactory;
	public ClamePizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing :" + name);
		douge = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
