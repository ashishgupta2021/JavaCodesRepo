package code.springframework.model;

public class Owner extends Person {

	@Override
	public String toString() {
		return "Owner [getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
