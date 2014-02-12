import java.util.ArrayList;

public class Shipwright {
	static ArrayList<String> occupied;
	
	@SuppressWarnings("static-access")
	public Shipwright() {
		this.occupied = new ArrayList<String>();
		Point initial = new Point(26,26);
		this.occupied.add(initial.getPoint());
	}
	
	static void makeShips(Player player) {
		PatrolBoat pboat = new PatrolBoat(player);
		pboat.generateShip();
		player.PatrolBoat = pboat;
		Cruiser cruiser = new Cruiser(player);
		cruiser.generateShip();
		player.Cruiser = cruiser;
		Battleship bship = new Battleship(player);
		bship.generateShip();
		player.Battleship = bship;
		Carrier carrier = new Carrier(player);
		carrier.generateShip();
		player.Carrier = carrier;
	}
}
