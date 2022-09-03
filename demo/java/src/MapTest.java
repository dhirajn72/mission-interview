import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapTest {
	public static void main(String[] args){
		Map<Employee, Integer> map = new HashMap<>();
		Employee emp = new Employee(1, "a");
		map.put(emp, 1);
		map.put(emp, 2);
		System.out.println(map);
		System.out.println("-------------");
		map.keySet().stream().forEach(key -> System.out.println(key + " : " + map.get(key)));
		System.out.println("-------");
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() ));

	}
}
class Employee{
	int id;
	String name;
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("equals called()");
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (id != employee.id) return false;
		return name != null ? name.equals(employee.name) : employee.name == null;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		Random random  = new Random();
		int result = random.nextInt();
		System.out.println("Generated random is : " + result);
		return result;
	}
}