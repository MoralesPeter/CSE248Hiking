package model;

import java.io.File;
import java.io.Serializable;

public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2990723706639097331L;
	
	public Admin(String username, String password, String firstName, String lastName, long phoneNumber, File image) {
		super(username, password, firstName, lastName, phoneNumber, image);
	}
	
	public void changePassword(User u, String password) {
		u.setPassword(password);
	}
	
	public void changeFirstName(User u, String firstName) {
		u.setFirstName(firstName);
	}
	
	public void changeLastName(User u, String lastName) {
		u.setLastName(lastName);
	}
	
	public void changePhoneNumber(User u, long phoneNumber) {
		u.setPhoneNumber(phoneNumber);
	}
	
	public void changeImagePath(User u, File image) {
		u.setImage(image);
	}
}
