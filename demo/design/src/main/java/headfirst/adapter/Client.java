package headfirst.adapter;

public class Client {
	public static void main(String[] args){
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();

		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		System.out.println("The Turkey says :: ");
		turkey.gobble();
		turkey.fly();
		System.out.println("------------");

		testDuck(duck);
		System.out.println("The TurkeyAdapter says ::");
		testDuck(turkeyAdapter);
	}
	private static void testDuck(Duck duck){
		duck.quack();
		duck.fly();
	}
}
