package university;

public class Teacher_full_time extends Teacher{
	private int experience;

	public Teacher_full_time(int id, String name, int type, double base_salary, int experience) {
		super(id, name, type, base_salary);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public double calculateSalary() {
		return experience * ((base_salary*110)/100);
	}

}
