package headfirst.methodfactoryabstract;

public class CheesePizza extends Pizza{
	private PizzaIngredientFactory ingredientFactory;
	public CheesePizza(PizzaIngredientFactory ingredientFactory){
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
