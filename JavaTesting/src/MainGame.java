import java.util.ArrayList;

@SuppressWarnings("unused")
public class MainGame {
	Player p1;
	Player p2;
	Point target;
	
	public void startGame() {
		Shipwright shipMaker = new Shipwright();
		p1 = new Player();
		p1.name = "Player One";
		p2 = new Player();
		p2.name = "Player Two";
		
		Shipwright.makeShips(p1);
		p1.getShipLocations();
		Shipwright.makeShips(p2);
		p2.getShipLocations();
		
		while(true) {
			p1.fire();
			target = p1.saveguess;
			System.out.println("Firing at " + target.getPoint() + "!");
			p2.PatrolBoat.hitCheck(target);
			p2.Cruiser.hitCheck(target);
			p2.Battleship.hitCheck(target);
			p2.Carrier.hitCheck(target);
			
			p2.fire();
			target = p2.saveguess;
			System.out.println("Firing at " + target.getPoint() + "!");
			p1.PatrolBoat.hitCheck(target);
			p1.Cruiser.hitCheck(target);
			p1.Battleship.hitCheck(target);
			p1.Carrier.hitCheck(target);

			
		if(p1.shipcount==0 || p2.shipcount==0) {
				if(p1.shipcount==0) {
					System.out.println(p1.name + ": all ships destroyed");
					System.out.println("Winner is " + p2.name);
					break;
				}
				if(p2.shipcount==0) {
					System.out.println(p2.name + ": all ships destroyed");
					System.out.println("Winner is " + p1.name);
					break;
				}
			}
			else {
				System.out.println("Fire next salvo!");
			}
		}
	}
}