package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TrailStorage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 226044182497471384L;
	
	private HashSet<Trail> trailStorage = new HashSet<>(50000);
	
	public TrailStorage() {
		
	}
	
	public void addTrail(Trail t) {
		trailStorage.add(t);
	}
	
	public List<Trail> search(String input) {
		List<Trail> list = trailStorage.stream()
		.filter(x -> x.getName().contains(input) || x.getTrailHead().contains(input)
		|| x.lengthString().contains(input) || x.elevationGainString().contains(input)
		|| x.difficultyString().contains(input) || x.typeString().contains(input))
		.sorted()
		.collect(Collectors.toList());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void initialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TrailStorage.dat")));
		trailStorage = (HashSet<Trail>) ois.readObject();
	}
	
	public void save() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TrailStorage.dat")));
		oos.writeObject(trailStorage);
	}
}
