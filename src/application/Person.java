package application;

public class Person implements Comparable<Person>{

	private String FirstName;
	private String LastName;
	private Person left;
	private Person right;
	



	public Person(String firstName, String lastName) {
		super();
		FirstName = firstName;
		LastName = lastName;
	}




	public String getFirstName() {
		return FirstName;
	}




	public void setFirstName(String firstName) {
		FirstName = firstName;
	}




	public String getLastName() {
		return LastName;
	}




	public void setLastName(String lastName) {
		LastName = lastName;
	}




	public Person getLeft() {
		return left;
	}




	public void setLeft(Person left) {
		this.left = left;
	}




	public Person getRight() {
		return right;
	}




	public void setRight(Person right) {
		this.right = right;
	}




	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(o.getFirstName());
		
	}



	@Override
	public String toString() {
		return this.FirstName+" "+this.LastName;
	}

	

	
	
	
	
	
}
	