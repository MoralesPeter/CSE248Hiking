package app;

import model.Trail;
import model.TrailStorage;

public class test {

	public static void main(String[] args) {
		Trail t0 = new Trail("name0", "trailhead0", 1.0, 2.0, 0, 0);
		Trail t1 = new Trail("name1", "trailhead1", 1.0, 2.0, 0, 0);
		Trail t2 = new Trail("name2", "trailhead2", 1.0, 2.0, 0, 0);
		Trail t3 = new Trail("name3", "trailhead2", 1.0, 2.0, 0, 0);
		TrailStorage theStorage = new TrailStorage();
		theStorage.addTrail(t0);
		theStorage.addTrail(t1);
		theStorage.addTrail(t2);
		theStorage.addTrail(t3);
		
		System.out.println(theStorage.search("Easy"));
	}

}
