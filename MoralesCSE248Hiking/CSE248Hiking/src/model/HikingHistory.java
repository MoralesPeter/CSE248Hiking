package model;

import java.io.Serializable;
import java.util.LinkedList;

public class HikingHistory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6266761206617035026L;
	
	private LinkedList<HikedTrail> hikingHistory = new LinkedList<>();
	
	public HikingHistory() {
		
	}
	
	public void addTrail(HikedTrail h) {
		hikingHistory.push(h);
	}
	
	public LinkedList<HikedTrail> getHikingHistory() {
		return hikingHistory;
	}
}
