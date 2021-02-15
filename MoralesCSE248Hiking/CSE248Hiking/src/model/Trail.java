package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Trail implements Serializable, Comparable<Trail> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4240474456391219292L;
	
	private String name;
	private String trailHead;
	private double length;
	private double elevationGain;
	private int difficulty; //0=easy, 1=moderate, 2=hard
	private int type; //0=loop, 1=out and back, 2=point-to-point
	private boolean isEnabled;
	private static int uniqueNum;
	private int uniqueID;
	
	public Trail(String name, String trailHead, double length, double elevationGain, int difficulty, int type) {
		this.name = name;
		this.trailHead = trailHead;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficulty = difficulty;
		this.type = type;
		this.setEnabled(true);
		try {
			this.uniqueID = generateUniqueID();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Trail(String name, String trailHead, double length, double elevationGain, int difficulty, int type, boolean isEnabled) {
		this.name = name;
		this.trailHead = trailHead;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficulty = difficulty;
		this.type = type;
		this.isEnabled = isEnabled;
		try {
			this.uniqueID = generateUniqueID();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrailHead() {
		return trailHead;
	}

	public void setTrailHead(String trailHead) {
		this.trailHead = trailHead;
	}

	public double getLength() {
		return length;
	}
	
	public String lengthString() {
		return Double.toString(this.length);
	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public double getElevationGain() {
		return elevationGain;
	}
	
	public String elevationGainString() {
		return Double.toString(this.elevationGain);
	}
	
	public void setElevationGain(double elevationGain) {
		this.elevationGain = elevationGain;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public String difficultyString() {
		if(this.difficulty == 0) {
			return "Easy";
		} else if(this.difficulty == 1) {
			return "Moderate";
		} else {
			return "Hard";
		}
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String typeString() {
		if(this.type == 0) {
			return "Loop";
		} else if(this.type == 1) {
			return "Out and back";
		} else {
			return "Point-to-point";
		}
	}
	
	public int generateUniqueID() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("UniqueNum.dat")));
		uniqueNum = (int) ois.readObject();
		uniqueNum++;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("UniqueNum.dat")));
		oos.writeObject(uniqueNum);
		return uniqueNum;
	}
	
	public String toString() {
		return "Name: " + name + ", Trailhead: " + trailHead + ", Length: " + Double.toString(length) + " miles, Elevation Gain: " + Double.toString(elevationGain) + " feet, Difficulty: " + difficultyString() + ", Type: " + typeString();
	}

	@Override
	public int compareTo(Trail t) {
		if(this.name.compareTo(t.name) > 0) {
			return 1;
		} else if(this.name.compareTo(t.name) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getUniqueID() {
		return uniqueID;
	}
}
