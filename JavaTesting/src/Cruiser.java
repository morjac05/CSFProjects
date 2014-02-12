public class Cruiser extends Ship {
	public Cruiser(Player owner) {
		super(owner);
		this.name = "Cruiser";
		this.length = 3;
		this.shiphp = length;
	}
}
