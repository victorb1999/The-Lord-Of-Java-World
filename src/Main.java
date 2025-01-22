import java.lang.reflect.Modifier;
import java.util.Scanner;

import creatures.Abilities;
import creatures.Cohort;
import creatures.Creature;
import creatures.Dragon;
import creatures.IBite;
import creatures.IBurn;
import creatures.ICreature;
import creatures.Mumakil;
import creatures.Warg;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testId = scanner.nextInt();
		switch (testId) {
		case 0:
			System.out.println("Ok! Let's start!");
			break;
		case 1:
			Parameters parameters = new Parameters("Mac OS", "./username", "strongPassword2021", 100);
			System.out.println(parameters);
		case 2:
			Abilities ability1 = new Abilities(25.0, 100.0, 14);
			Abilities ability2 = new Abilities(25.0, 98.0, 14);
			Abilities ability3 = new Abilities(25.0, 98.0, 27);

			System.out.println(ability1.compareTo(ability2));
			System.out.println(ability2.compareTo(ability3));

			System.out.println(ability1.powerDifferenceApprox(ability2));
			ability1.update(30, 17, -10);
			System.out.println(ability1.powerDifferenceApprox(ability2));
			break;
		case 3:
			Class<Creature> creature = Creature.class;
			System.out.println(Modifier.isAbstract(creature.getModifiers()));
			System.out.println(ICreature.class.isAssignableFrom(creature));
			System.out.println(Comparable.class.isAssignableFrom(creature));
			break;
		case 4:
			Class<Dragon> dragonClass = Dragon.class;
			Dragon dragon1 = new Dragon(25, 100, 15, "master_dragon", 80, 20, 40);
			System.out.println(IBurn.class.isAssignableFrom(dragonClass));
			dragon1.powerUp(10, 20, 12);
			System.out.println(dragon1);
			break;
		case 5:
			Class<Warg> wargClass = Warg.class;
			Warg warg1 = new Warg(25, 100, 15, "master_warg", 85, 20);
			System.out.println(IBite.class.isAssignableFrom(wargClass));
			warg1.powerUp(10, 20, 12);
			System.out.println(warg1);
			break;
		case 6:
			Mumakil mumakil1 = new Mumakil(25, 100, 15, "master_muma", 60);
			mumakil1.powerUp(10, 20, 12);
			System.out.println(mumakil1);
			break;
		case 7:
			Cohort<Dragon> dragonCohort = new Cohort<>();
			Dragon dragon71 = new Dragon(25, 100, 15, "master_dragon1", 80, 20, 40);
			Dragon dragon72 = new Dragon(35, 76, 5, "master_dragon2", 100, 20, 40);

			System.out.println(dragonCohort.isEmpty());
			dragonCohort.addNewCitizen("25,25", dragon71);
			dragonCohort.addNewCitizen("10,12", dragon72);
			System.out.println(dragonCohort.isEmpty());

			System.out.println(dragonCohort.getCitizenAt("25,25"));
			System.out.println(dragonCohort.getAllCitizensToFight());
			System.out.println(dragonCohort.getCitizenAt("test"));
			break;
		case 8:
			LordOfJava lordOfJava = new LordOfJava("Mac OS", "./username", "strongPassword2021", 3);

			Dragon dragon81 = new Dragon(25, 100, 15, "master_dragon1", 80, 20, 40);
			Dragon dragon82 = new Dragon(35, 76, 5, "master_dragon2", 100, 20, 40);

			Warg warg81 = new Warg(25, 100, 15, "master_warg1", 85, 20);
			Warg warg82 = new Warg(80, 56, 23, "master_warg1", 85, 20);

			Mumakil mumakil81 = new Mumakil(25, 100, 15, "master_muma", 60);

			lordOfJava.addCreature(dragon81, "25,25");
			lordOfJava.addCreature(dragon82, "14,24");
			lordOfJava.addCreature(warg81, "12,27");
			lordOfJava.addCreature(warg82, "05,15");
			lordOfJava.addCreature(mumakil81, "01,01");

			System.out.println(lordOfJava.battleDragonsWargs());
			System.out.println(lordOfJava);
		case 9:
			Cohort<Mumakil> mCohort = new Cohort<>();
			System.out.println(mCohort.isEmpty());
			mCohort.addNewCitizen("address1", new Mumakil(300, 100, 100, "Mumakil1", 10000));
			System.out.println(mCohort.isEmpty());
			mCohort.addNewCitizen("address2", new Mumakil(200, 100, 100, "Mumakil2", 10000));
			System.out.println(mCohort.size());
			System.out.println(mCohort.getCitizenAt("address2"));
			System.out.println();
			System.out.println(mCohort.toString());
			break;
		case 10:
			lordOfJava = new LordOfJava("Windows", "Users/Games", "credentials.txt", 2);
			lordOfJava.addCreature(new Mumakil(200, 100, 100, "Mumakil2", 10000), "address1");
			lordOfJava.addCreature(new Dragon(300, 100, 100, "Dragon1", 10000, 23.4, 300), "address2");
			lordOfJava.addCreature(new Warg(9500, 400, 3000, "Castwargarozas", 2880, 88400), "address3");
			System.out.println(lordOfJava.battleDragonsWargs());
			lordOfJava.addCreature(new Dragon(300, 100, 100, "Dragonnnnnn", 10000, 23.4, 300), "address4");
			lordOfJava.addCreature(new Warg(9500, 400, 3000, "Catz", 2880, 88400), "address5");
			System.out.println(lordOfJava.battleDragonsWargs());
			System.out.println(lordOfJava.toString());
			break;
		default:
			System.out.println("Invalid test number!");
			break;
		}
	}
}