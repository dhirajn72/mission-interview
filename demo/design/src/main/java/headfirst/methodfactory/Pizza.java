package headfirst.methodfactory;

import java.util.ArrayList;

public abstract class Pizza {
	protected String name, dough, sauce;
	protected ArrayList<String> toppings = new ArrayList<>();
	void prepare(){
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough ... ");
		System.out.println("Adding sauce ... ");
		System.out.println("Addint toppings ...");
		for(String topping : toppings){
			System.out.println(" " + topping);
		}
	}
	void bake(){
		System.out.println("Bake for 25 minutes at 350");
	}
	void cut(){
		System.out.println("Cutting the pizza into diagonal slices");
	}
	void box(){
		System.out.println("Place pizza in official PizzaStore box");
	}
	public String getName(){
		return name;
	}
}
