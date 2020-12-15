public class Dimos3B extends Geography {
	public static Dimos3B facilities[] = new Dimos3B[100];
	private int count = 0;

	public Dimos3B(String type, String name, String municipality) {
		super(type, name, municipality);
		facilities[count] = this;
		this.type = type;
		this.name = name;
		this.municipality = municipality;
		count++;
	}

	public static void printFacilities() {
		for (int z = 0 ; z < 100 ; z ++ ) {
			if(facilities[z] != null) {
				System.out.println(facilities[z]);
			}
		}
	}

	public static void fillTables() {
		Dimos3B AB = new Dimos3B("Σουπερ Μαρκετ", "ΑΒ Βασιλοπουλος", "Δημος 3Β");
		Dimos3B.facilities[0] = AB;
	}

	@Override

	public String toString() {
		return this.type + " Όνομα: " + this.name + " " + this.municipality;
	}

}
