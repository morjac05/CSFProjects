public class PatrolBoat extends Ship {
	public PatrolBoat (Player owner) {
		super(owner);
		this.name = "Patrol Boat";
		this.length = 2;
		this.shiphp = length;
	}
}
