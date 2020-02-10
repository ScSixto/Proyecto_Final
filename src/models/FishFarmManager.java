package models;

import exceptions.UnfoundObjectException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FishFarmManager {

	public static final int VALUE_NOT_FOUND_CODE = -1;
	public static final String SPECIES_UNFOUNDED_MESSAGE = "Especie no encontrada.";
	public static final String TOWN_UNFOUNDED_MESSAGE = "Municipio no encontrado.";
	public static final String CULTIVE_UNFOUNDED_MESSAGE = "Cultivo no encontrado.";
	public static final char CULTIVATED_FISHES_STATE = 'c';
	public static final char HARVESTED_FISHES_STATE = 'h';
	public static final int SIZE_TO_OBJECT_VECTOR_CULTIVES = 8;

	private ArrayList<Town> townList;
	private ArrayList<Species> speciesList;

	public FishFarmManager() {
		this.townList = new ArrayList<>();
		this.speciesList = new ArrayList<>();
	}

	// CRUD{
	// -------------------------------------------------------------------------------------------------
	public void addTown(Town town) {
		this.townList.add(town);
	}

	public int getTownId(int position) {
		return this.townList.get(position).getId();
	}

	public int searchTown(int id) throws UnfoundObjectException {
		int position = VALUE_NOT_FOUND_CODE;
		for (int i = 0; i < townList.size(); i++)
			if (townList.get(i).getId() == id) {
				position = i;
				break;
			}
		if (position == VALUE_NOT_FOUND_CODE)
			throw new UnfoundObjectException(TOWN_UNFOUNDED_MESSAGE);
		else
			return position;
	}

	public int searchTownByName(String name) throws UnfoundObjectException {
		int position = VALUE_NOT_FOUND_CODE;
		for (int i = 0; i < townList.size(); i++)
			if (townList.get(i).getName().equalsIgnoreCase(name)) {
				position = i;
				break;
			}
		if (position == VALUE_NOT_FOUND_CODE)
			throw new UnfoundObjectException(TOWN_UNFOUNDED_MESSAGE);
		else
			return position;
	}

	public static Town createTown(String name) {
		return new Town(name);
	}

	public void removeTown(int townId) throws UnfoundObjectException {
		this.townList.remove(this.searchTown(townId));
	}

	public void addSpecies(Species species) {
		this.speciesList.add(species);
	}

	public Species getSpecies(int position) {
		return this.speciesList.get(position);
	}

	public int searchSpecies(int id) throws UnfoundObjectException {
		int position = VALUE_NOT_FOUND_CODE;
		for (int i = 0; i < speciesList.size(); i++)
			if (speciesList.get(i).getId() == id) {
				position = i;
				break;
			}
		if (position == VALUE_NOT_FOUND_CODE)
			throw new UnfoundObjectException(SPECIES_UNFOUNDED_MESSAGE);
		else
			return position;
	}

	public int searchSpeciesByName(String name) throws UnfoundObjectException {
		int position = VALUE_NOT_FOUND_CODE;
		for (int i = 0; i < speciesList.size(); i++)
			if (speciesList.get(i).getName().equalsIgnoreCase(name)) {
				position = i;
				break;
			}
		if (position == VALUE_NOT_FOUND_CODE)
			throw new UnfoundObjectException(SPECIES_UNFOUNDED_MESSAGE);
		else
			return position;
	}

	public static Species createSpecies(int id, String name,
			double costByPound, WaterType waterType, Food food) {
		return new Species(id, name, costByPound, waterType, food);
	}

	public void removeSpecies(int speciesId) throws UnfoundObjectException {
		this.speciesList.remove(this.searchSpecies(speciesId));
	}

	public void addCultive(Cultive cultive, int townId)
			throws UnfoundObjectException {
		this.townList.get(this.searchTown(townId)).addCultive(cultive);
	}

	public static Cultive createCultive(int year, Species species,
			int cultivatedQuantity, int harvestedQuantity,
			double averageWeightByHarvestedAnimalKg) {
		return new Cultive(year, species, cultivatedQuantity,
				harvestedQuantity, averageWeightByHarvestedAnimalKg);
	}

	public void removeCultive(int cultiveId, int townId)
			throws UnfoundObjectException {
		this.townList.get(searchTown(townId)).removeCultive(cultiveId);
	}

	public ArrayList<Object[]> toObjectVectorTown() {
		ArrayList<Object[]> toObjectVectorTown = new ArrayList<>();
		for (Town town : townList) {
			toObjectVectorTown.add(town.toObjectVector());
		}
		return toObjectVectorTown;
	}

	public HashMap<String, ArrayList<Object[]>> townsAndCultives() {
		HashMap<String, ArrayList<Object[]>> townsAndCultives = new HashMap<>();
		for (Town town : townList) {
			townsAndCultives.put(Util.getConvertedTownName(town),
					town.toObjectVectorCultives());
		}
		return townsAndCultives;
	}

	public HashMap<String, Object[]> getCultive(int idCultive)
			throws UnfoundObjectException {
		HashMap<String, Object[]> townAndCultives = new HashMap<>();
		boolean found = false;
		for (Town town : townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getId() == idCultive) {
					townAndCultives.put(Util.getConvertedTownName(town),
							cultive.toObjectVector());
					found = true;
				}
			}
		}
		if (!found)
			throw new UnfoundObjectException(CULTIVE_UNFOUNDED_MESSAGE);
		else
			return townAndCultives;
	}

	public void editCultive(Object[] infoCultives) {
		for (Town town : townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getId() == (int) infoCultives[6]) {
					Util.editCultive(cultive, infoCultives);
					break;
				}
			}
		}
	}

	public Object[] searchCultiveDelete(int idCultive)
			throws UnfoundObjectException {
		Cultive cultiveDeleted = null;
		int j = 0;
		for (int i = 0; cultiveDeleted == null && i < townList.size(); i++) {
			for (Cultive cultive : townList.get(i).getCultiveList()) {
				if (cultive.getId() == idCultive) {
					cultiveDeleted = cultive;
					j = i;
					break;
				}
			}
		}
		if (cultiveDeleted == null)
			throw new UnfoundObjectException(CULTIVE_UNFOUNDED_MESSAGE);
		else
			return new Object[] { j, cultiveDeleted };
	}

	public void deleteCultive(Object[] townAndCultive) {
		townList.get((int) townAndCultive[0]).removeCultive(
				(Cultive) townAndCultive[1]);
	}

	// public
	// -------------------------------------------------------------------------------------------------
	// REPORTS
	// -------------------------------------------------------------------------------------------------

	public Object[] getSpeciesName() {
		Object[] listOfSpecies = new Object[this.speciesList.size()];
		int i = 0;
		for (Species species : speciesList) {
			listOfSpecies[i++] = Util.getConvertedSpeciesName(species);
		}
		return listOfSpecies;
	}

	public ArrayList<Integer> getCultiveYearList() {
		ArrayList<Integer> yearList = new ArrayList<>();
		boolean yearExist = false;
		for (Town town : townList) {
			for (Cultive cultive : town.getCultiveList()) {
				int yearCultive = cultive.getYear();
				for (int i = 0; !yearExist && i < yearList.size(); i++) {
					if (yearList.get(i) == yearCultive)
						yearExist = true;
				}
				if (!yearExist)
					yearList.add(yearCultive);
				yearExist = false;
			}
		}
		return yearList;
	}

	public HashMap<String, Double> convertToPercentValues(
			HashMap<String, Double> realValues) {
		double maxValue = this.getMaxValue((ArrayList<Double>) realValues
				.values());
		HashMap<String, Double> percentValues = new HashMap<>();
		Iterator<Entry<String, Double>> it = realValues.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Double> entry = it.next();
			percentValues
					.put(entry.getKey(), entry.getValue() * 100 / maxValue);
		}
		return percentValues;
	}

	public double getMaxValue(ArrayList<Double> values) {
		double maxValue = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) > maxValue) {
				maxValue = values.get(i);
			}
		}
		return maxValue;
	}

	public double getMinValue(ArrayList<Double> values) {
		double minValue = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) < minValue) {
				minValue = values.get(i);
			}
		}
		return minValue;
	}

	// FISH QUANTITY PER YEAR
	// -------------------------------------------------------------------------------------------------
	public HashMap<Character, HashMap<Integer, Long>> getFishesPerYearPerCultiveState() {
		HashMap<Character, HashMap<Integer, Long>> fishesPerYear = new HashMap<>();
		fishesPerYear.put(HARVESTED_FISHES_STATE,
				getFishesPerYear(HARVESTED_FISHES_STATE));
		fishesPerYear.put(CULTIVATED_FISHES_STATE,
				getFishesPerYear(CULTIVATED_FISHES_STATE));
		return fishesPerYear;
	}

	public HashMap<Integer, Long> getFishesPerYear(char cultiveState) {
		HashMap<Integer, Long> fishesPerYear = new HashMap<>();
		ArrayList<Integer> yearQuantity = getCultiveYearList();
		for (Integer year : yearQuantity) {
			Long fishesPerYearValue = this.calculateFishesPerYear(year,
					cultiveState);
			if (fishesPerYearValue > 0)
				fishesPerYear.put(year, fishesPerYearValue);
		}
		return fishesPerYear;
	}

	/*
	 * public HashMap<String, Double> getFishesPerYear(char cultiveState){
	 * HashMap<String, Double> fishesPerYear = new HashMap<>();
	 * ArrayList<Integer> yearQuantity = getCultiveYearList(); for (Integer year
	 * : yearQuantity){ fishesPerYear.put(""+year,
	 * (double)this.calculateFishesPerYear(year, cultiveState)); } return
	 * fishesPerYear; }
	 */

	public long calculateFishesPerYear(int year, char cultiveState) {
		long fishesQuantity = 0;
		for (Town town : townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getYear() == year)
					if (cultiveState == CULTIVATED_FISHES_STATE)
						fishesQuantity += cultive.getCultivatedQuantity();
					else
						fishesQuantity += cultive.getHarvestedQuantity();
			}
		}
		return fishesQuantity;
	}

	// -------------------------------------------------------------------------------------------------
	// FISH KILOGRAMS PER TOWN
	// -------------------------------------------------------------------------------------------------
	public double calculateFishKilogramsPerYearPerTown(int year, Town town,
			char cultiveState) {
		double fishKilogramsPerYearPerTown = 0;
		for (Cultive cultive : town.getCultiveList())
			if (cultive.getYear() == year) {
				if (cultiveState == CULTIVATED_FISHES_STATE)
					fishKilogramsPerYearPerTown += cultive
							.getCultivatedQuantity();
				else
					fishKilogramsPerYearPerTown += cultive
							.getHarvestedQuantity();
			}
		return fishKilogramsPerYearPerTown;
	}

	public HashMap<Town, Double> calculateFishKilogramsPerTown(int year,
			char cultiveState) {
		HashMap<Town, Double> fishKilogramsPerTown = new HashMap<>();
		for (Town town : this.townList) {
			double fishKilogramsPerTownValue = this
					.calculateFishKilogramsPerYearPerTown(year, town,
							cultiveState);
			if (fishKilogramsPerTownValue > 0)
				fishKilogramsPerTown.put(town, fishKilogramsPerTownValue);
		}
		return fishKilogramsPerTown;
	}

	public HashMap<Integer, HashMap<Town, Double>> getFishKilogramsPerState(
			char cultiveState) {
		HashMap<Integer, HashMap<Town, Double>> totalFishKilogramsPerTownPerYear = new HashMap<>();
		for (int year : getCultiveYearList()) {
			totalFishKilogramsPerTownPerYear.put(year,
					this.calculateFishKilogramsPerTown(year, cultiveState));
		}
		return totalFishKilogramsPerTownPerYear;
	}

	public HashMap<Character, HashMap<Integer, HashMap<Town, Double>>> getFishKilogramsPerTownPerYearPerCultiveState() {
		HashMap<Character, HashMap<Integer, HashMap<Town, Double>>> fishesPerYear = new HashMap<>();
		fishesPerYear.put(HARVESTED_FISHES_STATE,
				this.getFishKilogramsPerState(HARVESTED_FISHES_STATE));
		fishesPerYear.put(CULTIVATED_FISHES_STATE,
				this.getFishKilogramsPerState(CULTIVATED_FISHES_STATE));

		return fishesPerYear;
	}

	// -------------------------------------------------------------------------------------------------
	// SPECIES KILOGRAMS CULTIVATED PER YEAR
	// -------------------------------------------------------------------------------------------------
	public HashMap<Integer, HashMap<Species, Double>> getHarvestedFishKilogramsPerSpeciesPerYear() {
		HashMap<Integer, HashMap<Species, Double>> fishKilogramsPerSpeciesPerYear = new HashMap<>();
		for (Integer year : this.getCultiveYearList()) {
			fishKilogramsPerSpeciesPerYear.put(year,
					this.getHarvestedFishKilogramsPerSpecies(year));
		}
		return fishKilogramsPerSpeciesPerYear;
	}

	public HashMap<Species, Double> getHarvestedFishKilogramsPerSpecies(int year) {
		HashMap<Species, Double> fishKilogramsPerSpecies = new HashMap<>();
		for (Species species : this.speciesList) {
			double fishKilogramsPerSpeciesValue = this
					.calculateHarvestedFishKilogramsPerSpecies(year, species);
			if (fishKilogramsPerSpeciesValue > 0)
				fishKilogramsPerSpecies.put(species,
						fishKilogramsPerSpeciesValue);
		}
		return fishKilogramsPerSpecies;
	}

	public double calculateHarvestedFishKilogramsPerSpecies(int year,
			Species species) {
		double fishKilogramsPerSpecies = 0;
		for (Town town : this.townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getYear() == year
						&& cultive.getSpecies().equals(species)) {
					fishKilogramsPerSpecies += cultive
							.calculateTotalCultiveWeightKg();
				}
			}
		}
		return fishKilogramsPerSpecies;
	}

	// -------------------------------------------------------------------------------------------------
	// EARNINGS PER TOWN
	// -------------------------------------------------------------------------------------------------
	public HashMap<Integer, HashMap<Town, Double>> getEarningsPerTownPerYear() {
		HashMap<Integer, HashMap<Town, Double>> earningsPerTownPerYear = new HashMap<>();
		for (Integer year : this.getCultiveYearList()) {
			earningsPerTownPerYear.put(year, this.getEarningsPerTown(year));
		}
		return earningsPerTownPerYear;
	}

	public HashMap<Town, Double> getEarningsPerTown(int year) {
		HashMap<Town, Double> earningsPerTown = new HashMap<>();
		for (Town town : this.townList) {
			double earningsPerTownValue = this.calculateEarningsPerTown(year,
					town);
			if (earningsPerTownValue > 0)
				earningsPerTown.put(town, earningsPerTownValue);
		}
		return earningsPerTown;
	}

	/*
	 * public HashMap<String, Double> getEarningsPerTown(int year){
	 * HashMap<String, Double> earningsPerTown = new HashMap<>(); for (Town town
	 * : this.townList){ earningsPerTown.put(town.getName(),
	 * this.calculateEarningsPerTown(year, town)); } return earningsPerTown; }
	 */

	public double calculateEarningsPerTown(int year, Town town) {
		double earningsPerTown = 0;
		for (Cultive cultive : town.getCultiveList()) {
			if (cultive.getYear() == year)
				earningsPerTown += cultive.calculateTotalCultiveCost();
		}
		return earningsPerTown;
	}

	// -------------------------------------------------------------------------------------------------
	// AVERAGE WEIGHT PER SPECIES UNIT
	// -------------------------------------------------------------------------------------------------
	public HashMap<Species, Double> getAverageWeightPerSpeciesKg() {
		HashMap<Species, Double> averageWeightPerSpeciesKg = new HashMap<>();
		for (Species species : this.speciesList) {
			averageWeightPerSpeciesKg.put(species,
					this.calculateAverageWeightPerSpeciesKg(species));
		}
		return averageWeightPerSpeciesKg;
	}

	public double calculateAverageWeightPerSpeciesKg(Species species) {
		double totalWeightPerSpeciesKg = 0;
		int totalFishQuantityPerSpecies = 0;
		for (Town town : townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getSpecies().equals(species)) {
					totalWeightPerSpeciesKg += cultive
							.calculateTotalCultiveWeightKg();
					totalFishQuantityPerSpecies += cultive
							.getHarvestedQuantity();
				}
			}
		}
		return totalWeightPerSpeciesKg / totalFishQuantityPerSpecies;
	}

	// -------------------------------------------------------------------------------------------------
	// FISH FOOD QUANTITY
	// -------------------------------------------------------------------------------------------------
	public HashMap<Food, Integer> getFishFoodQuantityPerType() {
		HashMap<Food, Integer> fishFoodQuantityPerType = new HashMap<>();
		for (Food food : Food.values()) {
			fishFoodQuantityPerType.put(food,
					this.calculateFishFoodQuantityPerType(food));
		}
		return fishFoodQuantityPerType;
	}

	public int calculateFishFoodQuantityPerType(Food food) {
		int fishFoodQuantityPerType = 0;
		for (Town town : this.townList) {
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getSpecies().getFood().equals(food))
					fishFoodQuantityPerType += cultive.getCultivatedQuantity();
			}
		}
		return fishFoodQuantityPerType;
	}

	// -------------------------------------------------------------------------------------------------
	// WATER TYPE MORE USED
	// -------------------------------------------------------------------------------------------------
	public HashMap<WaterType, Integer> getWaterTypeQuantityPerType() {
		HashMap<WaterType, Integer> waterTypeQuantityPerType = new HashMap<>();
		for (WaterType waterType : WaterType.values()) {
			waterTypeQuantityPerType.put(waterType,
					this.calculateWaterTypeQuantityPerType(waterType));
		}
		return waterTypeQuantityPerType;
	}

	public int calculateWaterTypeQuantityPerType(WaterType waterType) {
		int waterTypeQuantityPerType = 0;
		for (Town town : this.townList) {
			for (Cultive cultive : town.getCultiveList()) {
				// System.out.println(cultive.getId() + " " +
				// cultive.getSpecies().getName());
				if (cultive.getSpecies().getWaterType().equals(waterType))
					waterTypeQuantityPerType += cultive.getCultivatedQuantity();
			}
		}
		return waterTypeQuantityPerType;
	}

	// -------------------------------------------------------------------------------------------------
	// CULTIVE PER TOWN
	// -------------------------------------------------------------------------------------------------
	public ArrayList<Object[]> getCultivesPerTown(String townSearched) {
		ArrayList<Object[]> cultivesTown = new ArrayList<Object[]>();
		for (Town town : townList) {
			if (town.getName().equalsIgnoreCase(townSearched)) {
				cultivesTown = town.toObjectVectorCultives();
				break;
			}
		}
		return cultivesTown;
	}

	public HashMap<String, ArrayList<Object[]>> cultivesPerTownReport(
			String townSearched) {
		HashMap<String, ArrayList<Object[]>> cultivesPerTwon = new HashMap<>();
		cultivesPerTwon.put(townSearched, getCultivesPerTown(townSearched));
		return cultivesPerTwon;
	}

	// -------------------------------------------------------------------------------------------------
	// CULTIVE PER SPECIE
	// -------------------------------------------------------------------------------------------------

	public HashMap<String, ArrayList<Object[]>> getCultivesPerSpecies(
			String specieSearched) {
		HashMap<String, ArrayList<Object[]>> cultivesPerSpecies = new HashMap<>();
		for (Town town : townList) {
			ArrayList<Object[]> cultivesSpecie = new ArrayList<Object[]>();
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getSpecies().getName()
						.equalsIgnoreCase(specieSearched)) {
					cultivesSpecie.add(cultive.toObjectVector());
				}
			}
			cultivesPerSpecies.put(Util.getConvertedTownName(town),
					cultivesSpecie);
		}
		return cultivesPerSpecies;
	}

	// -------------------------------------------------------------------------------------------------
	// CULTIVE PER YEAR
	// -------------------------------------------------------------------------------------------------

	public HashMap<String, ArrayList<Object[]>> getCultivesPerYear(
			int yearSearched) {
		HashMap<String, ArrayList<Object[]>> cultivesPerYear = new HashMap<>();
		for (Town town : townList) {
			ArrayList<Object[]> cultivesYear = new ArrayList<Object[]>();
			for (Cultive cultive : town.getCultiveList()) {
				if (cultive.getYear() == (yearSearched)) {
					cultivesYear.add(cultive.toObjectVector());
				}
			}
			cultivesPerYear.put(Util.getConvertedTownName(town), cultivesYear);
		}
		return cultivesPerYear;
	}

	// Esto es solo de prueba
	public void showConsoleReport() {
		for (Town tow : this.townList) {
			System.out.println(tow.getId() + ". " + tow.getName());
			for (Cultive cultive : tow.getCultiveList()) {
				System.out.println("\t" + cultive.getId() + ". Cultivo de "
						+ cultive.getSpecies().getName() + "\n\t\t("
						+ cultive.getYear() + ") Catidad: "
						+ cultive.getCultivatedQuantity());
			}
		}
	}

	public void holaputo() {
		for (int species : getCultiveYearList()) {
			System.out.println(species);
		}
	}
}