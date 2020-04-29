package university;

public abstract class Teacher {
	private int id;
	private String name;
	private int type;
	protected double base_salary;
	
	public Teacher (int id, String name, int type, double base_salary) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.base_salary = base_salary;
	}
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(double base_salary) {
		this.base_salary = base_salary;
	}


	public abstract double calculateSalary ();
	
}
