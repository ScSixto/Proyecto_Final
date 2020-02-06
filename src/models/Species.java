package models;

public class Species{

    private String name;
    private int id;
    private double costByPound;
    private WaterType waterType;
    private Food food;

    public Species(int id, String name, double costByPound, WaterType waterType, Food food){
        this.name = name;
        this.id = id;
        this.costByPound = costByPound;
        this.waterType = waterType;
        this.food = food;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

	public double getCostByPound() {
		return costByPound;
	}

	public void setCostByPound(double costByPound) {
		this.costByPound = costByPound;
	}

	public WaterType getWaterType() {
		return waterType;
	}

	public void setWaterType(WaterType waterType) {
		this.waterType = waterType;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
    
    
}
