public class Glyfada extends Geography {
	public static Glyfada facilities[] = new Glyfada[100];
	private int count = 0;

	public Glyfada(String type, String name, String municipality) {
		super(type, name, municipality);
		facilities[count] = this;
		this.type = type;
		this.name = name;
		this.municipality = municipality;
		count++;
	}

	public static void printFacilities() {
		for (int z=0; z<100; z++) {
			if(facilities[z] != null) {
				System.out.println(facilities[z]);
			}
		}
	}

	public static void fillTables() {
		Glyfada AB = new Glyfada("Super Market","Sklavenitis","Glyfada");
		facilities[0] = AB;
	}

	@Override

	public String toString() {
		return this.type + "Name: " + this.name + " " + this.municipality;
	}
}