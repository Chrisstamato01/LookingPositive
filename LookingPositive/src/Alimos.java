public class Alimos extends Geography {
	public static Alimos facilities[] = new Alimos[100];
	private int count = 0;
	public int populationAlimos = 49720; 

	public Alimos(String type, String name, String municipality) {
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

	@Override

	public String toString() {
		return this.type + " Όνομα: " + this.name + " " + this.municipality;
	}

}
