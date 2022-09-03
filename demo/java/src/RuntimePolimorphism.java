public class RuntimePolimorphism {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.doStuff();
		p = new ChildA();
		p.doStuff();
		p = new ChildB();
		p.doStuff();
	}
}

class Parent{
	void doStuff(){
		System.out.println("Parent");
	}
}

class ChildA extends Parent{
	@Override
	void doStuff() {
		System.out.println("ChildA");;
	}
}
class ChildB extends Parent{
	@Override
	void doStuff() {
		System.out.println("ChildB");
	}
}