public class Carrier extends Ship {
	public Carrier(Player owner) {
		super(owner);
		this.name = "Aircraft Carrier";
		this.length = 5;
		this.shiphp = length;
		this.init();
	}
}
