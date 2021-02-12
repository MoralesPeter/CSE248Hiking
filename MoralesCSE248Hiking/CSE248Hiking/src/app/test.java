package app;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Admin;
import model.Trail;
import model.TrailStorage;
import model.User;
import model.UserStorage;

public class test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Trail t0 = new Trail("name0", "trailhead0", 1.0, 5.0, 0, 0);
		Trail t1 = new Trail("name1", "trailhead1", 1.0, 2.0, 0, 0);
		Trail t2 = new Trail("name2", "trailhead2", 1.0, 3.0, 0, 0);
		Trail t3 = new Trail("name3", "trailhead2", 1.0, 4.0, 0, 0);
		TrailStorage theStorage = new TrailStorage();
		theStorage.addTrail(t0);
		theStorage.addTrail(t1);
		theStorage.addTrail(t2);
		theStorage.addTrail(t3);
		
		System.out.println(theStorage.search("2"));
		
		UserStorage userStorage = new UserStorage();
		User u = new User("user", "a", "John", "Doe", 5558675309L, "user.jpg");
		Admin a = new Admin("admin", "b", "Jane", "Doe", 5558675309L, "user.jpg");
		userStorage.addUser("user", u);
		userStorage.save();
		
	}

}
