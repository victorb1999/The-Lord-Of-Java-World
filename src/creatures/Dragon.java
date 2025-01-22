package creatures;

public class Dragon extends Creature implements IBurn {

	private double flamesPower;
	private int flySpeed;

	public Dragon(double stamina, double speed, int agility, String nickname, long score, double flamesPower,
			int flySpeed) {
		super(stamina, speed, agility, nickname, score);
		this.flamesPower = flamesPower;
		this.flySpeed = flySpeed;
	}

	public double getFlamesPower() {
		return this.flamesPower;
	}

	public int getFlyingSpeed() {
		return this.flySpeed;
	}

	@Override
	public void powerUp(double newStamina, double newSpeed, int newAgility) {
		super.powerUp(2 * newStamina, newSpeed / 2, 3 * newAgility);
	}

	@Override
	public String toString() {
		return super.toString() + "\nFlames power: " + this.flamesPower + "\nFly speed: " + this.flySpeed;
	}
}
