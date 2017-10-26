
public class Course {
	String name;    /** Course Name **/
	int id;         /** Course ID **/
	
	
	/*
	 * Default Constructer
	 */
	public Course(){}
	
	/*
	 * Constructor Using Fields
	 */
	public Course(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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
	
	/*
	 * a method to print the attributes and their values in an organized manner
	 */
	public void printInfo(){
		
		System.out.println(this.name+""+this.id);
		
	}
	
	

}
