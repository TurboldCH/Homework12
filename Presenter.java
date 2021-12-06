import java.io.Serializable;

/*
 * Presenter class implements Serializable
 * and contains information about the presenter
 */

public class Presenter implements Serializable{
	public String name;
	public String phoneN;
	public String DOB;
	public String email;
	
	public Presenter(String name, String phoneN, String dOB, String email) {
		super();
		this.name = name;
		this.phoneN = phoneN;
		DOB = dOB;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneN() {
		return phoneN;
	}
	public void setPhoneN(String phoneN) {
		this.phoneN = phoneN;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Name: " + this.name + 
				"\nPhone number: " + this.phoneN +
				"\nDate of Birth: " + this.DOB +
				"\nEmail: " + this.email;
	}
}
