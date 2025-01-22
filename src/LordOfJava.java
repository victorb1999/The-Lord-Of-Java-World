
import java.util.ArrayList;

import creatures.Cohort;
import creatures.Creature;
import creatures.Dragon;
import creatures.Mumakil;
import creatures.Warg;

public class LordOfJava {
	
	private Parameters parameters;
	private Cohort<Dragon> dragons = new Cohort<>();
	private Cohort<Warg> wargs = new Cohort<>();
	private Cohort<Mumakil> mumakils = new Cohort<>();

	public LordOfJava(String OS, String gamePATH, String credentials, int noLives) {
		this.parameters = new Parameters(OS, gamePATH, credentials, noLives);
	}

	public void addCreature(Creature creature, String address) {
			String creatureName = creature.getClass().getName();

			if (creature instanceof Dragon) {
				dragons.addNewCitizen(address, (Dragon) creature);
			} else if (creature instanceof Warg) {
				wargs.addNewCitizen(address, (Warg) creature);
			} else if (creature instanceof Mumakil) {
				mumakils.addNewCitizen(address, (Mumakil) creature);
			} else {
				throw new IllegalArgumentException("Creature type unknown: " + creatureName);
			}
		}
	
	public int battleDragonsWargs() {
		if (dragons.size() > wargs.size()) {
			return 1;
		} else if (dragons.size() < wargs.size()) {
			return -1;
		} else {
			ArrayList<Dragon> dragonsFight = dragons.getAllCitizensToFight();
			ArrayList<Warg> wargsFight = wargs.getAllCitizensToFight();
			
			int counter = 0;
			
			for (int i = 0; i < dragons.size(); i++) {
				int fight = dragonsFight.get(i).compareTo(wargsFight.get(i));
				counter += fight;
			}
			
      return counter;
		}
	}
	
	@Override
	public String toString() {
		return this.parameters.toString() + "\n" + this.dragons.toString() + "\n" + this.wargs.toString() +
            "\n" + this.mumakils.toString();
	}
}
