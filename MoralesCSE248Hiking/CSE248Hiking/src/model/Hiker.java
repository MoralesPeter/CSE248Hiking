package model;

import java.io.File;
import java.io.Serializable;

public class Hiker extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7409119092727369060L;

	public Hiker(String username, String password, String firstName, String lastName, long phoneNumber,
			File image) {
		super(username, password, firstName, lastName, phoneNumber, image);
	}
	
}
