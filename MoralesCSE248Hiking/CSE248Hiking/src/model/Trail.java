package model;

import java.io.Serializable;

public class Trail implements Serializable {
	
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
	
	public Trail(String name, String trailHead, double length, double elevationGain, int difficulty, int type) {
		
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

	public void setLength(double length) {
		this.length = length;
	}

	public double getElevationGain() {
		return elevationGain;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
