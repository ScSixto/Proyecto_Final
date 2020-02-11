package models;

public enum Food {
	PLANCTON("Plancton"), MEAT("Carne"), ALGAE("Algas"), MOLLUSKS("Moluscos"), INSECTS(
			"Insectos"), ORGANIC_MATERIAL("Materia Organica"), EGG("Huevos");

	private String name;

	Food(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}