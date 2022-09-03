package headfirst.methodfactoryabstract;

public interface PizzaIngredientFactory {
	Douge createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies[] createVegies();
	Pepperoni createPepperoni();
	Clame createClame();
}
