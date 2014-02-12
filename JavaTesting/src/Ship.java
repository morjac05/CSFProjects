import java.util.ArrayList;

public class Ship {
	String name;
	Player owner;
	int length;
	int shiphp;
	Point startPoint;
	ArrayList<Point> location;
	
	public Ship(Player owner) {
		this.owner = owner;
		this.startPoint = Point.randomPoint(25-(length-1));
		this.location = new ArrayList<Point>();
	}
	
	void damage() {
		if (shiphp>0) {
			shiphp--;
			System.out.println(this.owner.name + "'s " + this.name + " has been damaged! " + this.shiphp + " hit point(s) remaining.");
			if (shiphp==0) {
				System.out.println(this.owner.name + "'s " + this.name + " has been destroyed!");
				owner.shipcount--;
			}
		}
	}
	void getAttributes() {
		String attributes = "Name: " + this.name + "\n Owner: " + this.owner.name + "\n Length: " + this.length + "\n Remaining Hit Points: " + this.shiphp + "\n Origin Point: " + this.startPoint.getPoint();
		System.out.println(attributes);
	}
	
	@SuppressWarnings("unused")
	void generateShip() {
		Shipwright shipMaker = new Shipwright();
		int x = startPoint.getX();
		int y = startPoint.getY();
		int z = 0;
		int direction = (Math.random()<0.5)?0:1;
		if(direction==0) {
			for(x = startPoint.getX(); z<length; x++) {
				Point gridpoint = new Point(x,y);
				if(Shipwright.occupied.contains(gridpoint.getPoint())) {
					generateShip();	
				}
				location.add(gridpoint);
				Shipwright.occupied.add(gridpoint.getPoint());
				z++;
			}
		}
		if(direction==1) {
			for(y = startPoint.getY(); z<length; y++) {
				Point gridpoint = new Point(x,y);
				if(Shipwright.occupied.contains(gridpoint.getPoint())) {
					generateShip();
				}
				location.add(gridpoint);
				Shipwright.occupied.add(gridpoint.getPoint());
				z++;
			}
		}
	}
	
	void getLocation() {
		int n = 0;
		String shiploc = this.owner.name + "'s " + this.name + " is located at ";
		for(n=0; n<length; n++) {
			shiploc += this.location.get(n).getPoint() + ", ";
		}
		System.out.println(shiploc);
	}
	
	void hitCheck(Point shot) {
		Player player = this.owner;
		String hitPoint = shot.getPoint();
		ArrayList<String> targets = new ArrayList<String>();
		for(Point p:location) {
			String pointstring = p.getPoint();
			targets.add(pointstring);
		}
		if(targets.contains(hitPoint)) {
			this.damage();
			player.lastHit=true;
		}
	}
}