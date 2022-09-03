package headfirst.adapter;

public class WildTurkey implements Turkey{
	@Override
	public void gobble() {
		System.out.println("gooble");
	}

	@Override
	public void fly() {
		System.out.println("WildTurkey - fly");
	}
}
