package multithreadin;

public class ThreadLocalTest {
	public static final ThreadLocal<StateHolder> threadLocal = new ThreadLocal<StateHolder>(){
		@Override
		protected StateHolder initialValue() {
			return new StateHolder("active");
		}
	};

}
class StateHolder{
	private final String state;
	public StateHolder(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
