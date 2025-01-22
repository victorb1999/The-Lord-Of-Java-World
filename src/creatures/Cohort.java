package creatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cohort<C extends Creature> {

	private Map<String, C> creatures = new HashMap<>();

	public int size() {
		return this.creatures.size();
	}

	public C getCitizenAt(String address) {
		return this.creatures.get(address);
	}

	public boolean isEmpty() {
		return this.creatures.isEmpty();
	}

	public void addNewCitizen(String address, C creature) {
		this.creatures.put(address, creature);
	}

	public ArrayList<C> getAllCitizensToFight() {
		ArrayList<C> result = new ArrayList<>(creatures.values());
		Collections.sort(result);
		return result;
	}

	@Override
	public String toString() {
		ArrayList<C> citizensToString = getAllCitizensToFight();
		String result = "";

		for (C creature : citizensToString) {
			result += creature + "\n";
		}

		return result;
	}
}
