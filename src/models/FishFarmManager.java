package models;

import exeptions.UnfoundObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FishFarmManager{

    public  static final int VALUE_NOT_FOUND_CODE = -1;
    public static final String SPECIES_UNFOUNDED_MESSAGE = "Especie no encontrada.";
    public static final String TOWN_UNFOUNDED_MESSAGE = "Municipio no encontrado.";
    public static final char CULTIVATED_FISHES_STATE = 'c';
    public static final char HARVESTED_FISHES_STATE = 'h';

    private ArrayList<Town> townList;
    private ArrayList<Species> speciesList;

    public FishFarmManager(){
        this.townList = new ArrayList<>();
        this.speciesList = new ArrayList<>();
    }
//CRUD{
//-------------------------------------------------------------------------------------------------
    public void addTown(Town town){
        this.townList.add(town);
    }

    public int getTownId(int position){
        return this.townList.get(position).getId();
    }

    public int searchTown(int id) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < townList.size(); i++)
            if(townList.get(i).getId() == id){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(TOWN_UNFOUNDED_MESSAGE);
        else return position;
    }

    public int searchTownByName(String name) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < townList.size(); i++)
            if(townList.get(i).getName().equalsIgnoreCase(name)){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(TOWN_UNFOUNDED_MESSAGE);
        else return position;
    }

    public static Town createTown(String name){
        return new Town(name);
    }

    public void removeTown(int townId) throws UnfoundObject{
        this.townList.remove(this.searchTown(townId));
    }

    public void addSpecies(Species species){
        this.speciesList.add(species);
    }

    public Species getSpecies(int position){
        return this.speciesList.get(position);
    }

    public int searchSpecies(int id) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < speciesList.size(); i++)
            if(speciesList.get(i).getId() == id){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(SPECIES_UNFOUNDED_MESSAGE);
        else return position;
    }

    public int searchSpeciesByName(String name) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < speciesList.size(); i++)
            if(speciesList.get(i).getName().equalsIgnoreCase(name)){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(SPECIES_UNFOUNDED_MESSAGE);
        else return position;
    }


    public static Species createSpecies(int id, String name, double costByPound, WaterType waterType, Food food){
        return new Species(id, name, costByPound, waterType, food);
    }

    public void removeSpecies(int speciesId) throws UnfoundObject{
        this.speciesList.remove(this.searchSpecies(speciesId));
    }

    public void addCultive(Cultive cultive, int townId) throws UnfoundObject{
        this.townList.get(this.searchTown(townId)).addCultive(cultive);
    }

    public static Cultive createCultive(int year, Species species,int cultivatedQuantity, int harvestedQuantity, double averageWeightByHarvestedAnimalKg, double costByKg){
        return new Cultive(year, species, cultivatedQuantity, harvestedQuantity, averageWeightByHarvestedAnimalKg, costByKg);
    }

    public void removeCultive(int cultiveId, int townId) throws UnfoundObject{
        this.townList.get(searchTown(townId)).removeCultive(cultiveId);
    }

    public ArrayList<Object[]> toObjectVectorTown(){
    	ArrayList<Object[]> toObjectVectorTown = new ArrayList<>();
    	for (Town town : townList) {
    		toObjectVectorTown.add(town.toObjectVector());
		}
    	return toObjectVectorTown;
    }

    public HashMap<String, ArrayList<Object[]>> townsAndCultives(){
    	HashMap<String, ArrayList<Object[]>> townsAndCultives = new HashMap<>();
		for (Town town : townList) {
			townsAndCultives.put(town.getName(), town.toObjectVectorCultives());
		}
		return townsAndCultives;
    }
//-------------------------------------------------------------------------------------------------
//REPORTS
//-------------------------------------------------------------------------------------------------
    public ArrayList<Integer> getCultiveYearList(){
		ArrayList<Integer> yearList = new ArrayList<>();
		
		boolean yearExist = false;
    	for (Town town : townList) {
    		for (Cultive cultive : town.getCultiveList()) {
				int yearCultive = cultive.getYear();
					for(int i = 0; !yearExist && i < yearList.size(); i++){
						if(yearList.get(i) == yearCultive)yearExist=true;
					}
					if(!yearExist)yearList.add(yearCultive);
					yearExist=false;
    			}
    		}
    	return yearList;
    }
    
    public HashMap<String, Double> convertToPercentValues(HashMap<String, Double> realValues){
    	double maxValue = this.getMaxValue((ArrayList<Double>)realValues.values());
    	HashMap<String, Double> percentValues = new HashMap<>();
    	Iterator<Entry<String, Double>> it = realValues.entrySet().iterator();
    	while(it.hasNext()){
    		Entry<String, Double> entry = it.next();
    		percentValues.put(entry.getKey(), entry.getValue()*100/maxValue);
    	}
    	return percentValues;
    }
    
    public double getMaxValue(ArrayList<Double> values){
    	double maxValue = values.get(0);
    	for (int i = 1; i < values.size(); i++) {
			if(values.get(i) > maxValue){
				maxValue = values.get(i);
			}
		}
    	return maxValue;
    }
    
    public double getMinValue(ArrayList<Double> values){
    	double minValue = values.get(0);
    	for (int i = 1; i < values.size(); i++) {
			if(values.get(i) < minValue){
				minValue = values.get(i);
			}
		}
    	return minValue;
    }
    
    //FISH QUANTITY PER YEAR
    //-------------------------------------------------------------------------------------------------
/*    public HashMap<Integer, Long> getFishesPerYear(char cultiveState){
    	HashMap<Integer, Long> fishesPerYear = new HashMap<>();
    	ArrayList<Integer> yearQuantity = getCultiveYearList();
		for (Integer year : yearQuantity){
			fishesPerYear.put(year, this.calculateFishesPerYear(year, cultiveState));		
		}
		return fishesPerYear;
	}
*/	
    public HashMap<String, Double> getFishesPerYear(char cultiveState){
    	HashMap<String, Double> fishesPerYear = new HashMap<>();
    	ArrayList<Integer> yearQuantity = getCultiveYearList();
		for (Integer year : yearQuantity){
			fishesPerYear.put(""+year, (double)this.calculateFishesPerYear(year, cultiveState));		
		}
		return fishesPerYear;
    }

    public long calculateFishesPerYear(int year, char cultiveState){
    	long fishesQuantity = 0;
    	for (Town town : townList){
    		for (Cultive cultive : town.getCultiveList()) {
				if(cultive.getYear() == year)
					if(cultiveState == CULTIVATED_FISHES_STATE)
						fishesQuantity += cultive.getCultivatedQuantity();
					else
						fishesQuantity += cultive.getHarvestedQuantity();
			}
		}
    	return fishesQuantity;
    }
    //-------------------------------------------------------------------------------------------------
    //FISH KILOGRAMS PER TOWN    
    //-------------------------------------------------------------------------------------------------
    public double calculateFishKilogramsPerYearPerTown(int year, Town town, char cultiveState){
    	double fishKilogramsPerYearPerTown = 0;
    	for(Cultive cultive: town.getCultiveList())
    		if(cultive.getYear() == year){
    			if(cultiveState == CULTIVATED_FISHES_STATE)
    				fishKilogramsPerYearPerTown += cultive.getCultivatedQuantity();
    			else
    				fishKilogramsPerYearPerTown += cultive.getHarvestedQuantity();
    		}
    	return fishKilogramsPerYearPerTown;
    }
    
    public HashMap<Town, Double> calculateFishKilogramsPerTown(int year, char cultiveState){
    	HashMap<Town, Double> fishKilogramsPerTown = new HashMap<>();
    	for (Town town : this.townList){
			fishKilogramsPerTown.put(town, this.calculateFishKilogramsPerYearPerTown(year, town, cultiveState));
		}
    	return fishKilogramsPerTown;
    }
    
    public HashMap<Integer,HashMap<Town, Double>> getFishKilogramsPerTownPerYear(char cultiveState){
    	HashMap<Integer,HashMap<Town, Double>> totalFishKilogramsPerTownPerYear = new HashMap<>();
    	for (int year : this.getCultiveYearList()){
			totalFishKilogramsPerTownPerYear.put(year,this.calculateFishKilogramsPerTown(year, cultiveState));
		}
    	return totalFishKilogramsPerTownPerYear;
    }
    //-------------------------------------------------------------------------------------------------
    //SPECIES KILOGRAMS CULTIVATED PER YEAR
    //-------------------------------------------------------------------------------------------------
    public HashMap<Integer,HashMap<Species, Double>> getHarvestedFishKilogramsPerSpeciesPerYear(){
    	HashMap<Integer,HashMap<Species, Double>> fishKilogramsPerSpeciesPerYear = new HashMap<>();
    	for (Integer year : this.getCultiveYearList()){
			fishKilogramsPerSpeciesPerYear.put(year, this.getHarvestedFishKilogramsPerSpecies(year));		
		}
    	return fishKilogramsPerSpeciesPerYear;
    }
    
    public HashMap<Species, Double> getHarvestedFishKilogramsPerSpecies(int year){
    	HashMap<Species, Double> fishKilogramsPerSpecies = new HashMap<>();
    	for (Species species : this.speciesList){
    		fishKilogramsPerSpecies.put(species, this.calculateHarvestedFishKilogramsPerSpecies(year, species));
    	}
    	return fishKilogramsPerSpecies;
    }
    
    public double calculateHarvestedFishKilogramsPerSpecies(int year, Species species){
    	double fishKilogramsPerSpecies = 0;
    	for(Town town: this.townList){
    		for (Cultive cultive : town.getCultiveList()){
				if(cultive.getYear() == year && cultive.getSpecies() == species){
					fishKilogramsPerSpecies += cultive.calculateTotalCultiveWeightKg();
				}
			}
    	}
    	return fishKilogramsPerSpecies;
    }
    //-------------------------------------------------------------------------------------------------
    //EARNINGS PER TOWN
    //-------------------------------------------------------------------------------------------------
/*    public HashMap<Integer,HashMap<Town, Double>> getEarningsPerTownPerYear(){
    	HashMap<Integer,HashMap<Town, Double>> earningsPerTownPerYear = new HashMap<>();
    	for (Integer year : this.getCultiveYearList()){
    		earningsPerTownPerYear.put(year, this.getEarningsPerTown(year));		
		}
    	return earningsPerTownPerYear;
    }

    public HashMap<Town, Double> getEarningsPerTown(int year){
    	HashMap<Town, Double> earningsPerTown = new HashMap<>();
    	for (Town town : this.townList){
    		earningsPerTown.put(town, this.calculateEarningsPerTown(year, town));
    	}
    	return earningsPerTown;
	}
*/
	public HashMap<String, Double> getEarningsPerTown(int year){
    	HashMap<String, Double> earningsPerTown = new HashMap<>();
    	for (Town town : this.townList){
    		earningsPerTown.put(town.getName(), this.calculateEarningsPerTown(year, town));
    	}
    	return earningsPerTown;
    }

    public double calculateEarningsPerTown(int year, Town town){
    	double earningsPerTown = 0;
		for (Cultive cultive : town.getCultiveList()){
			if(cultive.getYear() == year)
				earningsPerTown += cultive.calculateTotalCultiveCost();
		}
    	return earningsPerTown;
    }
    //-------------------------------------------------------------------------------------------------
    //AVERAGE WEIGHT PER SPECIES UNIT
    //-------------------------------------------------------------------------------------------------
    public HashMap<Species, Double> getAverageWeightPerSpeciesKg(){
    	HashMap<Species, Double> averageWeightPerSpeciesKg = new HashMap<>();
    	for (Species species : this.speciesList){
    		averageWeightPerSpeciesKg.put(species, this.calculateAverageWeightPerSpeciesKg(species));
    	}
    	return averageWeightPerSpeciesKg;
    }

    public double calculateAverageWeightPerSpeciesKg(Species species){
    	double totalWeightPerSpeciesKg = 0;
    	int totalFishQuantityPerSpecies = 0;
    	for (Town town : townList){
    		for (Cultive cultive : town.getCultiveList()){
    			if(cultive.getSpecies().equals(species)){
    				totalWeightPerSpeciesKg += cultive.calculateTotalCultiveWeightKg();
    				totalFishQuantityPerSpecies += cultive.getHarvestedQuantity();
    			}
    		}
    	}
    	return totalWeightPerSpeciesKg/totalFishQuantityPerSpecies;
    }
    //-------------------------------------------------------------------------------------------------
    //FISH FOOD QUANTITY
    //-------------------------------------------------------------------------------------------------
    public HashMap<Food,Integer> getFishFoodQuantityPerType(){
    	HashMap<Food,Integer> fishFoodQuantityPerType = new HashMap<>();
    	for (Food food : Food.values()){
    		fishFoodQuantityPerType.put(food, this.calculateFishFoodQuantityPerType(food));		
		}
    	return fishFoodQuantityPerType;
    }

    public int calculateFishFoodQuantityPerType(Food food){
    	int fishFoodQuantityPerType = 0;
    	for (Town town : this.townList){
    		for (Cultive cultive : town.getCultiveList()) {
    			if(cultive.getSpecies().getFood().equals(food))
    				fishFoodQuantityPerType += cultive.getCultivatedQuantity();
			}
    	}
    	return fishFoodQuantityPerType;
    }
    //-------------------------------------------------------------------------------------------------
    //WATER TYPE MORE USED
    //-------------------------------------------------------------------------------------------------
    public HashMap<WaterType,Integer> getWaterTypeQuantityPerType(){
    	HashMap<WaterType,Integer> waterTypeQuantityPerType = new HashMap<>();
    	for (WaterType waterType : WaterType.values()){
    		waterTypeQuantityPerType.put(waterType, this.calculateWaterTypeQuantityPerType(waterType));		
		}
    	return waterTypeQuantityPerType;
    }

    public int calculateWaterTypeQuantityPerType(WaterType waterType){
    	int waterTypeQuantityPerType = 0;
    	for (Town town : this.townList){
    		for (Cultive cultive : town.getCultiveList()) {
    			if(cultive.getSpecies().getWaterType().equals(waterType))
    				waterTypeQuantityPerType += cultive.getCultivatedQuantity();
			}
    	}
    	return waterTypeQuantityPerType;
    }
    //-------------------------------------------------------------------------------------------------
    //CULTIVE PER TOWN
    //-------------------------------------------------------------------------------------------------
    public ArrayList<Object[]> getCultivesPerTown(String townSearched){
    	ArrayList<Object[]> cultivesTown = new ArrayList<Object[]>();
    	for (Town town : townList) {
			if(town.getName().equalsIgnoreCase(townSearched)) {
				cultivesTown = town.toObjectVectorCultives();
				break;
			}	
		}
    	return cultivesTown;
    }
    
    //-------------------------------------------------------------------------------------------------
    //CULTIVE PER SPECIE
    //-------------------------------------------------------------------------------------------------
    
    public ArrayList<Object[]> getCultivesPerSpecie(String specieSearched){
    	ArrayList<Object[]> cultivesSpecie = new ArrayList<Object[]>();
    	for (Town town : townList) {
    		for (Cultive cultive : town.getCultiveList()) {
    			if(cultive.getSpecies().getName().equalsIgnoreCase(specieSearched)) {
    				cultivesSpecie.add(cultive.toObjectVector());
    			}	
			}
		}
    	return cultivesSpecie;
    }
    
    //-------------------------------------------------------------------------------------------------
    //CULTIVE PER YEAR
    //-------------------------------------------------------------------------------------------------
    
    public ArrayList<Object[]> getCultivesPerYear(int yearSearched){
    	ArrayList<Object[]> cultivesYear = new ArrayList<Object[]>();
    	for (Town town : townList) {
    		for (Cultive cultive : town.getCultiveList()) {
    			if(cultive.getYear() == (yearSearched)) {
    				cultivesYear.add(cultive.toObjectVector());
    			}	
			}
		}
    	return cultivesYear;
    }
    
    //Esto es solo de prueba
    public void showConsoleReport(){
        for(Town tow: this.townList){
            System.out.println(tow.getId() + ". " + tow.getName());
            for(Cultive cultive: tow.getCultiveList()){
                System.out.println("\t" + cultive.getId() + ". Cultivo de " + cultive.getSpecies().getName() 
                		+ "\n\t\t(" + cultive.getYear() + ") Catidad: " + cultive.getCultivatedQuantity());
            }
        }
    }
/*
    public void showConsoleReportReport(){
    	HashMap<Integer, Long> harvestedFishesPerYear = getFishesPerYear(HARVESTED_FISHES_STATE);
    	Iterator<Entry<Integer, Long>> it = harvestedFishesPerYear.entrySet().iterator();
    	while(it.hasNext()){
	        Entry<Integer, Long> pair = it.next();
	        System.out.println(pair.getKey() + "-" + pair.getValue());

    	}
        for(Town tow: this.townList){
            System.out.println(tow.getId() + ". " + tow.getName());
            for(Cultive cultive: tow.getCultiveList()){
                System.out.println("\t" + cultive.getId() + ". Cultivo de " + cultive.getSpecies().getName() 
                		+ "\n\t\t(" + cultive.getYear() + ") Catidad: " + cultive.getCultivatedQuantity());
            }
        }
    }*/
    
    public void reportdelreport() {
    	for (Object[] object : getCultivesPerYear(2018)) {
			System.err.println(object[0] + "-" + object[1] + "-" + object[2] + "-"  + object[3] );
		}
	}
}