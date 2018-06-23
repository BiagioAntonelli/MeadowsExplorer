package controller;



import java.util.Collections;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.Direction;
import model.Location;
import model.MyWorld;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;

/**
 * Implementing a controller for a LocationViewer application.
 *
 * @author Biagio Antonelli; s1782299@ed.ac.uk;
 * @version 1.0.0 20/11/2017 17:00
 */

public class WorldController {

	private MyWorld myWorld;

	@FXML
	private ImageView imageView;

	@FXML
	private ImageView itemView;

	@FXML
	private ImageView myItemView;

	@FXML
	private Polygon viewItemButton;

	@FXML
	private Polygon worldItemButton;

	@FXML
	private Polygon nextPol;

	@FXML
	private Polygon rightPol;
	
	@FXML
	private Polygon leftPol;

	@FXML
	private MenuItem menuLocName;

	@FXML
	private MenuItem menuLocDir;

	/**
	 * Initialise the controller.
	 * 
	 */
	public void Initialise() {

		myWorld = new MyWorld();
		Direction currDir = myWorld.getDirection();
		this.displayView(currDir);

	}

	/**
	 * Display the closest direction available on the right.
	 *
	 */
	public void lookRight() {

		int dir = myWorld.getDirection().getValue();
		Direction currDir = myWorld.getLocation().turnRight(dir);
		this.displayView(currDir);

	}

	/**
	 * Display the closest direction available on the left.
	 *
	 */
	public void lookLeft() {

		int dir = myWorld.getDirection().getValue();
		Direction currDir = myWorld.getLocation().turnLeft(dir);
		this.displayView(currDir);

	}

	/**
	 * Go to the next location in closest direction available in the new location.
	 *
	 */
	public void goNext() {

		int dir = myWorld.getDirection().getValue();
		Direction currDir = myWorld.getDirection();

		if (currDir.getNextLocation() != null) {

			Location nextLoc = currDir.getNextLocation();
			Direction nextDir = nextLoc.picClosestDir(dir);

			myWorld.updateLocation(nextLoc);
			this.displayView(nextDir);

		}

	}

	/**
	 * Pick the selected item available in the location and add to the personal
	 * items collection.
	 *
	 */
	public void pickItem() {

		Direction currDir = myWorld.getDirection();
		List<Image> itemList = currDir.getItemsList();
		List<Image> worldItemsList = myWorld.getItemsList();

		if (!itemList.isEmpty()) {

			worldItemsList.add(0, itemList.get(0));
			itemList.remove(0);

			myWorld.updateItemsList(worldItemsList);
			currDir.updateItemsList(itemList);

			this.showLocItems(itemList);
			this.showMyItems(worldItemsList);
			disableItemSelection(itemList, worldItemsList);

		} else {

			itemView.setImage(null);

		}

	}

	/**
	 * Put the selected item available in the personal items collection in the
	 * current location.
	 *
	 */
	public void putItem() {

		Direction currDir = myWorld.getDirection();
		List<Image> itemList = currDir.getItemsList();
		List<Image> worldItemsList = myWorld.getItemsList();

		if (!worldItemsList.isEmpty()) {

			itemList.add(0, worldItemsList.get(0));
			worldItemsList.remove(0);

			myWorld.updateItemsList(worldItemsList);
			currDir.updateItemsList(itemList);

			this.showLocItems(itemList);
			this.showMyItems(worldItemsList);

			disableItemSelection(itemList, worldItemsList);

		}
	}

	/**
	 * Display current view.
	 * 
	 * @param currDir
	 *
	 */
	public void displayView(Direction currDir) {

		// Display image of the current view
		Image img = new Image(currDir.getPath());
		imageView.setImage(img);

		// Display Menu
		this.displayMenu(currDir);

		// Update myWorld info
		myWorld.updateCurrDirection(currDir);

		// Display items
		List<Image> itemList = currDir.getItemsList();
		List<Image> worldItemsList = myWorld.getItemsList();
		this.showLocItems(itemList);
		this.showMyItems(worldItemsList);

		// Manage Button Views
		this.buttonView(currDir);

		// Disable items selection if not needed
		this.disableItemSelection(itemList, worldItemsList);

	}

	/**
	 * Disable menu items not needed.
	 *
	 * @param currDir
	 */

	public void buttonView(Direction currDir) {

		if (currDir.getNextLocation() == null) {

			nextPol.setFill(Color.TRANSPARENT);
			nextPol.setDisable(true);

		} else {

			nextPol.setFill(Color.rgb(134, 42, 42));
			nextPol.setDisable(false);

		}

	}

	/**
	 * Display text in the menu items.
	 *
	 * @param currDir
	 */
	public void displayMenu(Direction currDir) {

		// Display menu info
		menuLocName.setText(myWorld.getLocation().getName());
		menuLocDir.setText("" + currDir.getValue() + " N");

	}

	/**
	 * Show the items in the current view.
	 *
	 * @param itemList
	 */
	public void showLocItems(List<Image> itemList) {

		if (itemList.size() > 0) {

			itemView.setImage(itemList.get(0));

		} else {

			itemView.setImage(null);

		}
	}

	/**
	 * Show my items.
	 * 
	 * @param worldItemsList
	 */
	public void showMyItems(List<Image> worldItemsList) {

		if (worldItemsList.size() > 0) {

			myItemView.setImage(worldItemsList.get(0));

		} else {

			myItemView.setImage(null);

		}

	}
	
	/**
	 * Restart application.
	 * 
	 */
	public void restartApp() {

		this.Initialise();

	}

	/**
	 * Show the next item in the current location when the selection arrow is
	 * pressed.
	 *
	 */
	public void scrollViewItems() {

		Direction currDir = myWorld.getDirection(); 
		List<Image> itemList = currDir.getItemsList(); 
		List<Image> worldItemsList = myWorld.getItemsList();

		if (!itemList.isEmpty()) {

			Collections.rotate(itemList, -1);
			itemView.setImage(itemList.get(0));

		} else {

			itemView.setImage(null);

		}

		this.showMyItems(worldItemsList);
		this.disableItemSelection(itemList, worldItemsList);

	}

	/**
	 * Show my next item when the selection arrow is pressed.
	 *
	 */
	public void scrollWorldItems() {

		List<Image> worldItemsList = myWorld.getItemsList();

		if (!worldItemsList.isEmpty()) {

			Collections.rotate(worldItemsList, -1);
			myWorld.updateItemsList(worldItemsList);
			this.showMyItems(worldItemsList);

		} else {

			myItemView.setImage(null);

		}

	}

	/**
	 * Disable view for button who do not have to be displayed.
	 * 
	 * @param itemList
	 * @param worldItemsList
	 *
	 */
	public void disableItemSelection(List<Image> itemList, List<Image> worldItemsList) {

		if (itemList.size() < 2) {

			viewItemButton.setFill(Color.TRANSPARENT);
			viewItemButton.setDisable(true);

		} else {

			viewItemButton.setFill(Color.rgb(251, 200, 46));
			viewItemButton.setDisable(false);
		}

		if (worldItemsList.size() < 2) {

			worldItemButton.setFill(Color.TRANSPARENT);
			worldItemButton.setDisable(true);

		} else {

			worldItemButton.setFill(Color.rgb(251, 200, 46));
			worldItemButton.setDisable(false);

		}
	}

}