package designpatterns;

public class Builder {
	public static void main(String[] args){
		EmployeeBuilder.Employee employee = new EmployeeBuilder().setId(100).setName("oracle").build();
		System.out.println(employee);
	}
}

class EmployeeBuilder{
	private int id;
	private String name;
	private String email;
	private String phone;

	public EmployeeBuilder setId(int id){
		this.id = id;
		return this;
	}
	public EmployeeBuilder setName(String name){
		this.name = name;
		return this;
	}
	public EmployeeBuilder setEmail(String email){
		this.email = email;
		return this;
	}
	public EmployeeBuilder setPhone(String phone){
		this.phone = phone;
		return this;
	}
	public Employee build(){
		Employee employee = new Employee();
		employee.id = this.id;
		employee.name = this.name;
		employee.email = this.email;
		employee.phone = this.phone;
		return employee;
	}
	class Employee{
		private int id;
		private String name;
		private String email;
		private String phone;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "Employee{" +
					"id=" + id +
					", name='" + (name != null ? name : "") + '\'' +
					", email='" + (email != null ? email : "") + '\'' +
					", phone='" + (phone != null ? phone : "") + '\'' +
					'}';
		}
	}
}
