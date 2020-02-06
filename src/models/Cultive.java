package models;

public class Cultive{

    private static int sequential = 0;
    private int id;
    private int year;
    private Species species;
    private int cultivatedQuantity;
    private int harvestedQuantity;
	private double averageWeightByHarvestedAnimalKg;
	private double costByKg;

    public Cultive(int year, Species species,int cultivatedQuantity, int harvestedQuantity, double averageWeightByHarvestedAnimalKg, double costByKg){
        this.id = ++sequential;
        this.year  = year;
        this.species = species;
        this.cultivatedQuantity = cultivatedQuantity;
        this.harvestedQuantity = harvestedQuantity;
        this.averageWeightByHarvestedAnimalKg = averageWeightByHarvestedAnimalKg;
        this.costByKg = costByKg;
    }

    public int getId(){
        return id;
    }

    public Species getSpecies(){
        return species;
    }

    public int getCultivatedQuantity(){
        return cultivatedQuantity;
    }

    public int getYear(){
        return year;
    }
    
    public int getHarvestedQuantity() {
  		return harvestedQuantity;
  	}

  	public void setHarvestedQuantity(int harvestedQuantity) {
  		this.harvestedQuantity = harvestedQuantity;
  	}

  	public double getAverageWeightByHarvestedAnimalKg() {
		return averageWeightByHarvestedAnimalKg;
	}

	public void setAverageWeightByHarvestedAnimalKg(
			double averageWeightByHarvestedAnimalKg) {
		this.averageWeightByHarvestedAnimalKg = averageWeightByHarvestedAnimalKg;
	}

	public double getCostByKg() {
  		return costByKg;
  	}

  	public void setCostByKg(double costByKg) {
  		this.costByKg = costByKg;
  	}

  	public double calculateTotalCultiveCost(){
  		return (this.costByKg *(this.harvestedQuantity * this.averageWeightByHarvestedAnimalKg));
  	}
  	
  	public double calculateTotalCultiveWeightKg(){
  		return (this.averageWeightByHarvestedAnimalKg * this.harvestedQuantity);
  	}
  	
  	public Object[] toObjectVector() {
  		return new Object[] {this.id, this.year, this.species.getName(), this.cultivatedQuantity, this.harvestedQuantity, this.calculateTotalCultiveWeightKg(), this.calculateTotalCultiveCost()};
  	}
}