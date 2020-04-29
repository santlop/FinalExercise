package university;
import utils.Utils;
import java.util.*;

public class University {
	private List<Teacher> teacher = new ArrayList<Teacher>();
	private List<Student> student = new ArrayList<Student>();
	private List<Subject> subject = new ArrayList<Subject>();
	Utils util = new Utils();
	Scanner read = new Scanner(System.in);
	
	public University() {
		this.student = initStudent();
		this.teacher = initTeacher();
		this.subject = initSubject();
	}
	
	private List<Teacher> initTeacher() {
		teacher.add(new Teacher_full_time(00001, "Juan Carlos", 1, 800000, 2));
		teacher.add(new Teacher_full_time(00002, "Justo Alberto", 1, 850000, 5));
		teacher.add(new Teacher_part_time(00003, "Andres Lopez", 2, 500000, 10));
		teacher.add(new Teacher_part_time(00004, "Julian Camilo", 2, 600000, 20));

        return teacher;
    }
	
	private List<Student> initStudent() {
		student.add(new Student("Camilo", 1111, 20));
		student.add(new Student("Andres", 1112, 21));
		student.add(new Student("Santiago", 1113, 22));
		student.add(new Student("Julian", 1114, 23));
		student.add(new Student("Juan", 1115, 22));
		student.add(new Student("Martin", 1116, 23));

        return student;
    }
	

	private List<Teacher> randomTeacher() {
		List<Teacher> teac = new ArrayList<Teacher>();
		teac.add(teacher.get(util.random(3)));
        return teac;
    }
	
	private List<Student> randomStudent() {		
		List<Student> stud = new ArrayList<Student>();
		stud.add(student.get(util.random(5)));
		stud.add(student.get(util.random(5)));
        return stud;
    }
	
	
	private List<Subject> initSubject() {
		subject.add(new Subject("Math", 101, randomTeacher(), randomStudent()));
		subject.add(new Subject("Science", 102, randomTeacher(), randomStudent()));
		subject.add(new Subject("Music", 103, randomTeacher(), randomStudent()));
		subject.add(new Subject("Languaje", 104, randomTeacher(), randomStudent()));

        return subject;
    }
	
	public List<Teacher> getTeacherList() {
        return teacher;
    }
	
	public List<Student> getStudentList() {
        return student;
    }
	
	public List<Subject> getSubjectList() {
        return subject;
    }
	
	
	
	
	public void printTeacher() {
		int count = 1;
		System.out.println("Teachers: \n");
		for (Teacher teacherp : getTeacherList()) {
			if(teacherp.getType() == 1) {
				System.out.println(count + ". Name: " + teacherp.getName()
									+ "\nNational ID: " + teacherp.getId()
									+ "\nType: Full time" 
									+ "\nBase salary: " + teacherp.getBase_salary()
									+ "\nExperience: " + ((Teacher_full_time) teacherp).getExperience()
									+ "\nSalary: " + ((Teacher_full_time) teacherp).calculateSalary() + "\n");
				
			}else if(teacherp.getType() == 2) {
				System.out.println(count + ". Name: " + teacherp.getName() 
				+ "\nNational ID: " + teacherp.getId()
				+ "\nType: Part time" 
				+ "\nBase salary: " + teacherp.getBase_salary()
				+ "\nHours active: " + ((Teacher_part_time) teacherp).getHour_active()
				+ "\nSalary: " + ((Teacher_part_time) teacherp).calculateSalary() + "\n");
			}
			count = count + 1;			
		}
	}
	
	
	public void printStudent() { 
		int count = 1;
		System.out.println("Students: \n");
		for (Student studentp : getStudentList()) {			
				System.out.println(count + ". Name: " + studentp.getName() 
									+ "\nNational ID: " + studentp.getId() 
									+ "\nBase salary: " + studentp.getAge() +"\n");			
			count = count + 1;			
		}
	}
	

	public void printSubect() { 
		getSubjectList().forEach(su -> System.out.println("Class name: " + su.getName() + "\nClassroom: " + su.getClassroom() + "\n"));
		
		System.out.println("Do you want to see the information about a class? y/n");
		String res = read.nextLine();
		
		if(res.equals("y")) {
			
			System.out.println("Please enter the number of classroom");			
			int cl = read.nextInt();
			
			for (Subject subjectp : getSubjectList()) {	
				if(subjectp.getClassroom() == cl) {
					
					System.out.println("Name: " + subjectp.getName()  +"\n"
									+ "Classroom: " + subjectp.getClassroom()  +"\n");	
					
					for (Teacher teacherc : subjectp.getTeacher()) {
						if(teacherc.getType() == 1) {
							
							System.out.println("Teacher: \n	Name:" + teacherc.getName()
												+ "\n	National ID: " + teacherc.getId()
												+ "\n	Type: Full time" 
												+ "\n	Base salary: " + teacherc.getBase_salary()
												+ "\n	Experience: " + ((Teacher_full_time) teacherc).getExperience()
												+ "\n	Salary: " + ((Teacher_full_time) teacherc).calculateSalary() + "\n");
							
						}else if(teacherc.getType() == 2) {
							
							System.out.println("Teacher: \n	Name:" + teacherc.getName() 
												+ "\n	National ID: " + teacherc.getId()
												+ "\n	Type: Part time" 
												+ "\n	Base salary: " + teacherc.getBase_salary()
												+ "\n	Hours active: " + ((Teacher_part_time) teacherc).getHour_active()
												+ "\n	Salary: " + ((Teacher_part_time) teacherc).calculateSalary() + "\n");
						}
					}
					
					int count2 = 1;
					System.out.println("Students: ");
					
					for (Student studentc : subjectp.getStudentList()) {				
						System.out.println(count2 + ". Name: " + studentc.getName() 
											+ "\n	National ID: " + studentc.getId() 
											+ "\n	Base salary: " + studentc.getAge() +"\n");
						count2 = count2 + 1;
					}			
				}
			}				
		}
	}
	
	public void createTeacher() {
		System.out.println("Please choose the type of teacher that you want add: \n1. Full time\n2. Part time");
		int tp = read.nextInt();
		if(tp == 1) {
			System.out.println("Please enter the national id: ");
			int id = read.nextInt();
			System.out.println("Please enter the name of new teacher: ");
			String name = read.next();
			System.out.println("Please enter the salary base: ");
			double base_salary = read.nextDouble();
			System.out.println("Please enter the years of experience: ");
			int experience = read.nextInt();
			
			teacher.add(new Teacher_full_time(id, name, 1, base_salary, experience));
			
		}else if(tp == 2) {
			System.out.println("Please enter the national id: ");
			int id = read.nextInt();
			System.out.println("Please enter the name of new teacher: ");
			String name = read.next();
			System.out.println("Please enter the salary base: ");
			double base_salary = read.nextDouble();
			System.out.println("Please enter the hours active : ");
			int hour_active = read.nextInt();
			
			teacher.add(new Teacher_part_time(id, name, 2, base_salary, hour_active));
			
		}
	}
	
	public void createStudent() {
		System.out.println("Please enter the national id of the new student: ");
		int id = read.nextInt();
		System.out.println("Please enter the name of new student: ");
		String name = read.next();
		System.out.println("Please enter the age: ");
		int age = read.nextInt();
		Student new_stu = new Student(name, id, age);
		student.add(new_stu);
		
		System.out.println("Do you want to add the new a student a class? y/n");
		String res = read.nextLine();
		if(res.equals("y")) {
			System.out.println("Please enter the number of classroom");
			int cl = read.nextInt();
			
			boolean  exist = false;
			for (Subject subjectp : getSubjectList()) {
				if(subjectp.getClassroom() == cl) {
					subjectp.getStudentList().add(new_stu);	
					 exist = true;
				}
			}
			if(exist) {
				System.out.println("Classroom selected successful");
			}else {
				System.out.println("The classroom number don't exist");
			}
		}	
	}
	
	public void createSubject() {
		System.out.println("Please enter the name of new class: ");
		String name = read.next();
		System.out.println("Please enter the number of classroom: ");
		int num = read.nextInt();
		System.out.println("Please enter the national ID of the teacher: ");
		int idt = read.nextInt();		
		List<Teacher> teach = findTeacher(idt);
		if(teach != null) {
			List<Student> studentclass = new ArrayList<Student>();
			Subject subjectc = new Subject(name, idt, teach, studentclass);			
			addStudentSubject(subjectc);
			subject.add(subjectc);
			
		}else {
			System.out.println("The professor don't exist");
		}
		
	}
	
	private List<Teacher> findTeacher(int idt) {
		int pos = -1;
		
		for (Teacher teacherp : getTeacherList()) {
			if(teacherp.getId() == idt) {
					pos = pos + 1;
			}
		}		
		getTeacherList().get(pos);
        return teacher;
    }
	
	private Student findStudent(int idst) {		
		for (Student studentp : getStudentList()) {
			if(studentp.getId() == idst) {
				return studentp;
			}
		}		
        return null;
    }
	
	private void addStudentSubject(Subject subject) {
		
		System.out.println("Please enter the national ID of the student: ");
		int idst = read.nextInt();
		
		Student stu = findStudent(idst);
		
		if(stu != null) {
			subject.getStudentList().add(stu);
			System.out.println("Do yopu want to add a another student? y/n");
			String r = read.next();
			if(r.equals("y")) {
				addStudentSubject(subject);
			}
		}else {
			System.out.println("The student don't exist");
			System.out.println("Do yopu want to add a another student? y/n");
			String r = read.next();
			if(r.equals("y")) {
				addStudentSubject(subject);
			}			
		}
	}
	
	public void findStudentSubjects(){
		System.out.println("Please enter the national ID of the student: ");
		int idsc = read.nextInt();
		System.out.println("The student belong to following classes: ");
		int count1 = 1;
		for (Subject subjectp : getSubjectList()) {	
			for (Student studentc : subjectp.getStudentList()) {				
				if(studentc.getId() == idsc) {
					System.out.println(count1 + ". Name class:  " + subjectp.getName() + "\n	Classroom: " + subjectp.getClassroom());
					count1 = count1 + 1;
				}
			}
		}
		
	}
}
