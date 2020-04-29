package main;

import java.util.Scanner;

import university.University;

public class Main {

	public static void main(String[] args) {
		University uni = new University();
		Scanner read = new Scanner(System.in);
		int opc = 0;
		int count = 0;
		
		while(opc != 8) {
			System.out.println("----------------------------------------" );
			System.out.println("           Welcome to the university" );
			System.out.println("----------------------------------------" );
			System.out.println("Please choose one option: "
					+ "\n1.Do you want print the list of teachers?"
					+ "\n2.Do you want print the list of students?"
					+ "\n3.Do you want print the list of classes?"
					+ "\n4.Do you want create a new teacher?"
					+ "\n5.Do you want create a new student?"
					+ "\n6.Do you want create a new class?"
					+ "\n7.Do you want to see all the classes that a student has belonged to?"
					+ "\n8.Exit the program");
			opc = read.nextInt();
			
			switch(opc) {
			case 1:
				System.out.println("----------------------------------------" );
				uni.printTeacher();
				break;
			case 2:
				System.out.println("----------------------------------------" );
				uni.printStudent();
				break;
			case 3:
				System.out.println("----------------------------------------" );
				uni.printSubect();
							
				break;
			case 4:
				System.out.println("----------------------------------------" );
				uni.createTeacher();		
				break;
			case 5:
				System.out.println("----------------------------------------" );
				uni.createStudent();		
				break;
			case 6:
				System.out.println("----------------------------------------" );
				uni.createSubject();		
				break;
			case 7:
				System.out.println("----------------------------------------" );
				uni.findStudentSubjects();		
				break;
			}	
		}	
	}

}
