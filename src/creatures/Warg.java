package creatures;

public class Warg extends Creature implements IBite {

	private double bitePower;

	public Warg(double stamina, double speed, int agility, String nickname, long score, double bitePower) {
		super(stamina, speed, agility, nickname, score);
		this.bitePower = bitePower;
	}

	@Override
	public double getBitePower() {
		return this.bitePower;
	}

	@Override
	public void powerUp(double newStamina, double newSpeed, int newAgility) {
		super.powerUp(newStamina / 2, newSpeed * 4, newAgility);
	}

	@Override
	public String toString() {
		return super.toString() + "\nBite Power: " + this.bitePower;
	}
}