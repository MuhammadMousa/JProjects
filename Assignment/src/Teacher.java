
public class Teacher {
	String name;  /** teacher's name **/
	int id;       /** teacher's id **/
	double basicSalary;
	double extraPaymentRate;
	Course[] coursesTaught;
	
	/*
	 * Default constructor
	 */
	public Teacher(){}
	
	/*
	 * Constructor using fields
	 */
	public Teacher(String name, int id, double basicSalary,
			double extraPaymentRate, Course[] coursesTaught) {
		super();
		this.name = name;
		this.id = id;
		this.basicSalary = basicSalary;
		this.extraPaymentRate = extraPaymentRate;
		this.coursesTaught = coursesTaught;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getExtraPaymentRate() {
		return extraPaymentRate;
	}

	public void setExtraPaymentRate(double extraPaymentRate) {
		this.extraPaymentRate = extraPaymentRate;
	}

	public Course[] getCoursesTaught() {
		return coursesTaught;
	}

	public void setCoursesTaught(Course[] coursesTaught) {
		this.coursesTaught = coursesTaught;
	}
	
	/*
	 * a method which takes a level as an argument and return a level as 
	 * an argument and return the number of courses of that level.
	 */
	public int countCourseLevel(int level){
		int numOfCourse = 0;
		int courseLevel = 0;;
		
		for (int i = 0; i < this.coursesTaught.length; i++) {
			courseLevel = Math.floorDiv(this.coursesTaught[i].id, 100); // get the course level from the course id
			if(courseLevel == level){
				numOfCourse++;
			}
		}
		
		return numOfCourse;
	}
	
	/*
	 * calculates and returns the value of extra payment.
	 */
	public double calculateExtraPayment(){
		int courseLevel;
		int numOfLevelCourses = 0;
		double extraPayment = 0.0;
		for (int i = 0; i < this.coursesTaught.length; i++) {
			
			courseLevel = Math.floorDiv(this.coursesTaught[i].id, 100);
			numOfLevelCourses = countCourseLevel(courseLevel);

		    extraPayment += (numOfLevelCourses * courseLevel *this.extraPaymentRate);
			
		}
		
		return extraPayment;
	}
	/*
	 * a method to print teacher's information in an organized manner
	 */
	public void printInfo(int id){
		System.out.printf("Teacher's Name: ");System.out.printf(this.name+"\n");
		System.out.printf("Teacher's ID: ");System.out.printf(this.id+"\n");
		System.out.printf("Teacher's Basic Salary: ");System.out.printf(this.basicSalary+"\n");
		System.out.printf("Extra Payment Rate: ");System.out.printf(this.extraPaymentRate+"\n");
		
		System.out.println("Courses Taught by "+this.name+": ");
		for (int i = 0; i < this.coursesTaught.length; i++) {
			this.coursesTaught[i].printInfo();	// this is the method (printInfo) for the course
		}
		
	}
	
	
	
	

}
