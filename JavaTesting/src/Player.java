import java.util.ArrayList;

public class Player {
	Carrier Carrier;
	Battleship Battleship;
	Cruiser Cruiser;
	PatrolBoat PatrolBoat;
	int shipcount = 4;
	String name;
	Point saveguess;
	ArrayList<String> alreadyChecked;
	boolean lastHit=false;
	
	public Player() {
		this.alreadyChecked = new ArrayList<String>();
	}
	
	void fire() {
		Point aim = Point.randomPoint(25);
		if(alreadyChecked.contains(aim.getPoint())) {
			fire();
			}
		else {
			saveguess = aim;
			alreadyChecked.add(aim.getPoint());
			}
		}
	
	void getShipAttributes() {
		this.Carrier.getAttributes();
		this.Battleship.getAttributes();
		this.Cruiser.getAttributes();
		this.PatrolBoat.getAttributes();
	}
	
	void getShipLocations() {
		this.Carrier.getLocation();
		this.Battleship.getLocation();
		this.Cruiser.getLocation();
		this.PatrolBoat.getLocation();
	}
}