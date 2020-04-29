package university;

public class Teacher_part_time extends Teacher{
	private  int hour_active;

	public Teacher_part_time(int id, String name, int type, double base_salary, int hour_active) {
		super(id, name, type, base_salary);
		this.hour_active = hour_active;
	}

	public int getHour_active() {
		return hour_active;
	}

	public void setHour_active(int hour_active) {
		this.hour_active = hour_active;
	}

	@Override
	public double calculateSalary() {
		return base_salary * hour_active;
	}

}
