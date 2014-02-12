public class Battleship extends Ship {
	public Battleship(Player owner) {
		super(owner);
		this.name = "Battleship";
		this.length = 4;
		this.shiphp = length;
	}
}
