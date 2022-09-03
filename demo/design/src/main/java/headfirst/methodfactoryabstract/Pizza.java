package headfirst.methodfactoryabstract;

public abstract class Pizza {
	String name;
	Douge douge;
	Sauce sauce;
	Veggies veggies;
	Cheese cheese;
	Pepperoni pepperoni;
	Clame clame;

	abstract void prepare();
	void bake(){
		System.out.println("Bake for 25 minutes at 350");
	}
	void cut(){
		System.out.println("Cutting the pizza into diagonal slices");
	}
	void box(){
		System.out.println("Place pizza in official PizzaStore box");
	}
	void setName(String name){
		this.name = name;
	}
	String getName(){
		return name;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", douge=" + douge +
				", sauce=" + sauce +
				", veggies=" + veggies +
				", cheese=" + cheese +
				", pepperoni=" + pepperoni +
				", clame=" + clame +
				'}';
	}
}
