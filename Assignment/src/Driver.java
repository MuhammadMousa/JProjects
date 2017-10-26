import java.io.IOException;
import java.util.Scanner;


public class Driver {

	private static Scanner scan; // to read the user input.
    private static Teacher[] teachers;
	public static void main(String[] args){
	   scan = new Scanner(System.in);
	   
		int numOfTeachers = 0;
		System.out.println("Please Enter Number of teachers: ");
		numOfTeachers = scan.nextInt();
		teachers  = new Teacher[numOfTeachers];
		for (int i = 0; i < teachers.length; i++) {
			teachers[i] = new Teacher();
		}
       
		System.out.println("Please Enter teacher’s name, id, basic salary, and extra payment rate: ");
		for (int i = 0; i < teachers.length; i++) {
			teachers[i].name = scan.next();
			teachers[i].id = scan.nextInt();
			teachers[i].basicSalary = scan.nextDouble();
			teachers[i].extraPaymentRate = scan.nextDouble();
			
			System.out.println("Please Enter Number of courses that " +teachers[i].name + " taught: ");
			int numOfCoursesTaught = 0;
			numOfCoursesTaught = scan.nextInt();
			teachers[i].coursesTaught = new Course[numOfCoursesTaught];
			System.out.println("Please enter course name and id for each in the form \"CourseName CourseID\": ");
			for (int j = 0; j < teachers[i].coursesTaught.length ; j++) {
				teachers[i].coursesTaught[j] = new Course(scan.next(), scan.nextInt());
			}
			
		}
		
		
		// while the user isn't choosing EXIT keep showing the main menu.
		int userChoice = 0;
		showMainMenu(); // Displaying the menu of choices
		userChoice = scan.nextInt();
		do {
			getUserChoice(userChoice);
			chooseAgain();
			showMainMenu();
			userChoice = scan.nextInt();
		} while (true); 
		
	
		
	}
	
	/**
	 * Get the user choice and output the result accordingly.
	 * @param userChoice
	 */
	
	public static void getUserChoice(int userChoice ){
		int targetTeacher = 0;  
		boolean found = false;
		if(userChoice == 1){ // Print Teacher Info
			
			System.out.println("Please Enter Teacher's ID");
			targetTeacher = scan.nextInt();
			
			for (int i = 0; i < teachers.length; i++) { /** Search for the specific teacher **/
				if (teachers[i].id == targetTeacher) {
					teachers[i].printInfo(targetTeacher);   /** Print the information of the teacher **/
					found = true;
					break;
				}
			}
			if(found == false){
			System.out.println("Sorry No such teacher");
			}
			System.out.println("----------------------------------------");

		}
		else if(userChoice == 2){ //Display All teachers names and total salaries
			for (int i = 0; i < teachers.length; i++) {
				System.out.println("Teacher Name: "+teachers[i].name +","+"Total Salary: "
			                       + (teachers[i].basicSalary + teachers[i].calculateExtraPayment()));
			}
			System.out.println("----------------------------------------");
			
		}
		else if(userChoice == 3){ //Change Basic salary for a teacher
			System.out.println("Please Enter Teacher's ID");
			targetTeacher = scan.nextInt();
			double updatedSalary = 0.0;
			for (int i = 0; i < teachers.length; i++) { /** Search for the specific teacher **/
				if (teachers[i].id == targetTeacher) {
					
					System.out.println("Please Enter the new value of "+teachers[i].name+"'s Salary");
					updatedSalary = scan.nextDouble();
					teachers[i].basicSalary = updatedSalary;
					found = true;
					break;
					
				}
				
			}
			if(found == false){
			System.out.println("Sorry No such teacher");
			}
			System.out.println("----------------------------------------");
			
		}
		else if(userChoice == 4){ //Display sum of total salaries for all tteachers
			double sumOfAllSalaries = 0.0;
			for (int i = 0; i < teachers.length; i++) {
				sumOfAllSalaries += (teachers[i].basicSalary + teachers[i].calculateExtraPayment());
			}
			System.out.println("Sum of all salaries = "+sumOfAllSalaries);
			System.out.println("----------------------------------------");
			
			
		}
		else if(userChoice == 5){ //Exit
			System.out.println("Good Bye");
			System.exit(0);
			
		}
		
		else {  // if invalid choice
			System.out.println("Invalid Choice");
			System.out.println("Please Try Again");
			System.out.println("----------------------------------------");
		}
		
	}
	
	
	/**
	 * if the user chooses to choose again this method will be invoked.
	 */
	public static void chooseAgain(){
		System.out.println("Press ENTER to continue...");
        try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	/**
	 * a method to diplay the main menu.
	 */
	public static void showMainMenu(){
		
		System.out.println("Please Enter Your choice of tasks (1-5):");
		System.out.println("1- Print Teacher Info.");
		System.out.println("2- Display All teachers names and total salaries.");
		System.out.println("3- Change Basic salary for a teacher.");
		System.out.println("4- Display sum of total salaries for all tteachers.");
		System.out.println("5- Exit.");
		
		}
	
	
      
}
