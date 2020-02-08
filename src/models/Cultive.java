package models;

public class Cultive{

    private static int sequential = 0;
    private int id;
    private int year;
    private Species species;
    private int cultivatedQuantity;
    private int harvestedQuantity;
	private double averageWeightByHarvestedAnimalKg;

    public Cultive(int year, Species species,int cultivatedQuantity, int harvestedQuantity, double averageWeightByHarvestedAnimalKg){
        this.id = ++sequential;
        this.year  = year;
        this.species = species;
        this.cultivatedQuantity = cultivatedQuantity;
        this.harvestedQuantity = harvestedQuantity;
        this.averageWeightByHarvestedAnimalKg = averageWeightByHarvestedAnimalKg;
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

  	public double calculateTotalCultiveCost(){
  		return ((this.species.getCostByPound()*2)*(this.harvestedQuantity * this.averageWeightByHarvestedAnimalKg));
  	}
  	
  	public double calculateTotalCultiveWeightKg(){
  		return (this.averageWeightByHarvestedAnimalKg * this.harvestedQuantity);
  	}
  	
  	public Object[] toObjectVector() {
  		return new Object[] {this.id, this.year, Util.getConvertedSpeciesName(this.species), this.cultivatedQuantity, this.harvestedQuantity, this.calculateTotalCultiveWeightKg(), this.calculateTotalCultiveCost()};
  	}
}