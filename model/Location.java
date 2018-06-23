package model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * A template for storing all the information of a location. A location object
 * contains a collection of ViewInfo object and a "internal map" to look at the
 * different views stored.
 *
 * @author Biagio Antonelli; s1782299@ed.ac.uk;
 * @version 1.0.0 20/11/2017 17:00
 */

public class Location {

	private HashMap<Integer, Direction> directionList = new HashMap<>();
	private String name;
	private List<Integer> internalMap = new ArrayList<>();

	public Location(String loc_name) {

		name = loc_name;
		directionList = new HashMap<>();

	}

	/**
	 * Add a direction to this location.
	 *
	 */
	public void addDirection(Direction dirObject) {

		int dirValue = dirObject.getValue();
		directionList.put(dirValue, dirObject);
		internalMap.add(dirValue);
		Collections.sort(internalMap);

	}

	/**
	 * Turn right. Return the "right" view in the current location from the internal
	 * map.
	 *
	 * @param dir
	 *
	 */
	public Direction turnRight(int dir) {

		int key = (internalMap.indexOf(dir) + 1) % internalMap.size();
		return directionList.get(internalMap.get(key));

	}

	/**
	 * Turn left. Return the "left" view in the current location from the internal
	 * map.
	 *
	 */
	public Direction turnLeft(int dir) {

		int key = (internalMap.size() + internalMap.indexOf(dir) - 1) % internalMap.size();
		return directionList.get(internalMap.get(key));

	}

	/**
	 * Turn left. Return the "left" view in the current location from the internal
	 * map.
	 *
	 */
	public Direction picClosestDir(int dir) {

		List<Integer> tempList = new ArrayList<>();
		int diff;
		for (int i = 0; i < internalMap.size(); i++) {
			diff = Math.abs(internalMap.get(i) - dir);
			if (diff >= 180) {
				diff = 360 - diff;
			}
			tempList.add(diff);
		}

		int key = tempList.indexOf(Collections.min(tempList));

		return directionList.get(internalMap.get(key));
	}

	public String getName() {

		return this.name;

	}

}
