package models;

public enum WaterType {

	SALTWATER("Agua Salada"), SWEET_WATER("Agua Dulce");

	private String name;

	WaterType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}