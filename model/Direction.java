package model;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

/**
 *
 *A template for storing the direction objects.  
 *A direction object includes direction, next location, items and image file path.
 *
 * @author Biagio Antonelli; s1782299@ed.ac.uk;
 * @version 1.0.0 20/11/2017 17:00
 */

public class Direction {

	private int dir;
	private String locationName;
	private Location nextLoc;
	private String path;
	private List<Image> itemsList = new ArrayList<>();

	public Direction(int direction, String locName, String img_path) {

		dir = direction;
		locationName = locName;
		path = img_path;
		nextLoc = null;

	}
	
	/**
	 * Get the direction of the current view with respect to the Nord.
	 *
	 */
	public int getValue() {

		return this.dir;

	}

	/**
	 * Get the name of the location to which this view belong.
	 *
	 */
	public String getLocationName() {

		return this.locationName;

	}

	/**
	 * Get the image path of the picture of the current view.
	 *
	 */
	public String getPath() {

		return this.path;

	}

	/**
	 * Get the Location object accessible from this view.
	 *
	 */
	public Location getNextLocation() {

		return this.nextLoc;

	}

	/**
	 * Set the Location object accessible from this view.
	 *
	 * @param loc
	 *
	 */
	public void setNextLocation(Location loc) {

		this.nextLoc = loc;

	}

	/**
	 * Add item to the current view.
	 *
	 * @param itemPath
	 *
	 */
	public void addItem(String itemPath) {

		Image img = new Image(itemPath);
		itemsList.add(img);

	}

	/**
	 * Get the list of items present in the current view.
	 *
	 */
	public List<Image> getItemsList() {

		return this.itemsList;

	}

	/**
	 * Update the list of items present in the current direction.
	 *
	 * @param list
	 *
	 */
	public void updateItemsList(List<Image> list) {

		this.itemsList = list;

	}

}
