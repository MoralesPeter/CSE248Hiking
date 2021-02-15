package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Admin;
import model.Hiker;
import model.Trail;
import model.TrailStorage;
import model.UserStorage;
import model.Utilities;

public class PopulateData {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		int uniqueNum = 0;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("UniqueNum.dat")));
		oos.writeObject(uniqueNum);
		
		UserStorage userStorage = new UserStorage();
		
		for(int i=0; i<50; i++) {
			Hiker h = new Hiker(Utilities.emitText("usernames.txt", 2292), "a", Utilities.emitText("firstnames.txt", 2000), Utilities.emitText("lastnames.txt", 2000), 5558675309L, new File("default-user.png"));
			userStorage.addUser(h.getUsername(), h);
		}
		
		TrailStorage trailStorage = new TrailStorage();
		
		for(int i=0; i<500; i++) {
			Trail t = new Trail(Utilities.emitText("trailnames.txt", 1048) + " trail", Utilities.emitText("trailheads.txt", 132) + " trailhead", Utilities.emitDouble(1000, 10.0), Utilities.emitDouble(10000, 10.0), (int) (Math.random() * 3), (int) (Math.random() * 3));
			trailStorage.addTrail(t);
		}
		
		trailStorage.save();
		
		File defaultImage = new File("default-user.png");
		Hiker h = new Hiker("user", "a", "John", "Doe", 5558675309L, defaultImage);
		Admin a = new Admin("admin", "b", "Jane", "Doe", 5558675309L, defaultImage);
		userStorage.addUser("user", h);
		userStorage.addUser("admin", a);
		userStorage.save();
		
	}

}
