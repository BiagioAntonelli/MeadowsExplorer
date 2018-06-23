package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

/**
 * A template for storing Location and ViewInfo objects and keep the current
 * status of the application.
 *
 * @author Biagio Antonelli; s1782299@ed.ac.uk;
 * @version 1.0.0 20/11/2017 17:00
 */

public class MyWorld {

	private Location currLocation;
	private Direction currDirection;
	private List<Image> worldItemsList = new ArrayList<>();

	public MyWorld() {

		// Locations' instances
		Location loc1 = new Location("home");
		Location loc2 = new Location("street1");
		Location loc3 = new Location("street2");
		Location loc4 = new Location("street3");
		Location loc5 = new Location("street4");
		Location loc6 = new Location("street5");
		Location loc7 = new Location("street4");
		Location loc8 = new Location("library");

		// insert pictures in the collection for location 1
		Direction dir1 = new Direction(0, "loc1", "pictures/loc1dir0.jpg");
		Direction dir2 = new Direction(90, "loc1", "pictures/loc1dir90.jpg");
		Direction dir3 = new Direction(180, "loc1", "pictures/loc1dir180.jpg");
		Direction dir4 = new Direction(270, "loc1", "pictures/loc1dir270.jpg");
		dir4.setNextLocation(loc2);
		dir2.setNextLocation(loc1);
		dir1.addItem("items/coffee.png");
		dir1.addItem("items/book.png");
		dir1.addItem("items/bag.png");

		// insert pictures in the collection for location 2
		Direction dir5 = new Direction(0, "Loc2", "pictures/loc2dir0.jpg");
		Direction dir6 = new Direction(180, "loc2", "pictures/loc2dir180.jpg");
		Direction dir7 = new Direction(270, "loc2", "pictures/loc2dir270.jpg");
		Direction dir7n = new Direction(90, "loc2", "pictures/loc2dir90.jpg");
		dir5.setNextLocation(loc3);
		dir6.setNextLocation(loc1);
		dir7.addItem("items/pencil.png");

		// insert pictures in the collection for location 3
		Direction dir8 = new Direction(0, "Loc3", "pictures/loc3dir0.jpg");
		Direction dir9 = new Direction(270, "loc3", "pictures/loc3dir270.jpg");
		Direction dir10 = new Direction(315, "loc3", "pictures/loc3dir315.jpg");
		Direction dir10n = new Direction(180, "loc3", "pictures/loc3dir180.jpg");
		dir9.setNextLocation(loc4);
		dir10n.setNextLocation(loc2);

		// insert pictures in the collection for location 4
		Direction dir11 = new Direction(0, "Loc4", "pictures/loc4dir0.jpg");
		Direction dir12 = new Direction(270, "loc4", "pictures/loc4dir270.jpg");
		Direction dir13 = new Direction(315, "loc4", "pictures/loc4dir315.jpg");
		Direction dir131 = new Direction(90, "loc4", "pictures/loc4dir90.jpg");
		dir13.setNextLocation(loc5);
		dir131.setNextLocation(loc3);

		// insert pictures in the collection for location 5
		Direction dir14 = new Direction(305, "Loc5", "pictures/loc5dir305.jpg");
		Direction dir15 = new Direction(325, "loc5", "pictures/loc5dir325.jpg");
		Direction dir15n = new Direction(120, "loc5", "pictures/loc5dir120.jpg");
		dir15n.setNextLocation(loc6);

		// insert pictures in the collection for location 6
		Direction dir17 = new Direction(135, "Loc6", "pictures/loc6dir135.jpg");
		Direction dir18 = new Direction(170, "loc6", "pictures/loc6dir170.jpg");
		Direction dir19 = new Direction(235, "loc6", "pictures/loc6dir235.jpg");
		Direction dir20 = new Direction(35, "Loc6", "pictures/loc6dir35.jpg");
		Direction dir21 = new Direction(80, "loc6", "pictures/loc6dir80.jpg");
		Direction dir22 = new Direction(325, "loc6", "pictures/loc6dir325.jpg");
		dir22.setNextLocation(loc7);
		dir17.addItem("items/squirrel.png");

		// insert pictures in the collection for location 7
		Direction dir23 = new Direction(0, "Loc7", "pictures/loc7dir0.jpg");
		Direction dir24 = new Direction(145, "loc7", "pictures/loc7dir145.jpg");
		Direction dir25 = new Direction(160, "loc7", "pictures/loc7dir160.jpg");
		dir23.setNextLocation(loc8);
		dir24.setNextLocation(loc6);

		// insert pictures in the collection for location 8
		Direction dir26 = new Direction(0, "Loc8", "pictures/loc8dir0.jpg");
		Direction dir27 = new Direction(180, "loc8", "pictures/loc8dir180.jpg");
		Direction dir28 = new Direction(90, "loc8", "pictures/loc8dir90.jpg");
		dir26.addItem("items/cup.png");
		dir27.setNextLocation(loc7);

		// add pictures to the Locations
		loc1.addDirection(dir1);
		loc1.addDirection(dir2);
		loc1.addDirection(dir3);
		loc1.addDirection(dir4);
		
		loc2.addDirection(dir5);
		loc2.addDirection(dir6);
		loc2.addDirection(dir7);
		loc2.addDirection(dir7n);

		loc3.addDirection(dir8);
		loc3.addDirection(dir9);
		loc3.addDirection(dir10);
		loc3.addDirection(dir10n);

		loc4.addDirection(dir11);
		loc4.addDirection(dir12);
		loc4.addDirection(dir13);
		loc4.addDirection(dir131);

		loc5.addDirection(dir14);
		loc5.addDirection(dir15);
		loc5.addDirection(dir15n);

		loc6.addDirection(dir17);
		loc6.addDirection(dir18);
		loc6.addDirection(dir19);
		loc6.addDirection(dir20);
		loc6.addDirection(dir21);
		loc6.addDirection(dir22);

		loc7.addDirection(dir23);
		loc7.addDirection(dir24);
		loc7.addDirection(dir25);

		loc8.addDirection(dir26);
		loc8.addDirection(dir27);
		loc8.addDirection(dir28);

		// starting location and view
		currLocation = loc1;
		currDirection = dir1;

	}

	/**
	 * Update the current location.
	 *
	 * @param loc
	 *
	 */
	public void updateLocation(Location loc) {

		this.currLocation = loc;

	}

	/**
	 * Update the current View.
	 *
	 * @param pic
	 *
	 */
	public void updateCurrDirection(Direction dir) {

		this.currDirection = dir;

	}

	/**
	 * Get the current Location object.
	 *
	 */
	public Location getLocation() {

		return this.currLocation;

	}

	/**
	 * Get the current Direction object.
	 *
	 */
	public Direction getDirection() {

		return this.currDirection;

	}

	/**
	 * Get the list of my items.
	 *
	 */
	public List<Image> getItemsList() {

		return this.worldItemsList;

	}

	/**
	 * Update my item list.
	 *
	 */
	public void updateItemsList(List<Image> list) {

		this.worldItemsList = list;

	}

}
