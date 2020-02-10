package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import views.ConstantsGUI;

public class Util{
	
	public static final double GRAMS_BY_KILOGRAM = 1000;
	public static final double GRAMS_BY_POUND = 1000;


    public static WaterType getWaterType(String waterTypeName){
        WaterType waterType = null;
        for(WaterType water: WaterType.values()){
            if(water.getName().equals(waterTypeName)){
                waterType = water;
                break;
            }
        }
        return waterType;
    }
    
    public static double toKilograms(double gramQuantity){
    	return gramQuantity/GRAMS_BY_KILOGRAM;
    }

    public static Food getFood(String foodName){
        Food food = null;
        for(Food foodValue: Food.values()){
            if(foodValue.getName().equals(foodName)){
                food = foodValue;
                break;
            }
        }
        return food;
    }
    
    public static Object[] transformTownsArray(ArrayList<Object[]> townList) {
    	Object[] vector = new Object[townList.size()];
    	int i = 0;
    	for (Object[] object : townList) {
    		vector[i++] = getConvertedTownAndSpeciesName((String)object[1]);
		}
    	return vector;
    }
    
    public static Object[] transformYearsArray(ArrayList<Integer> yearsList) {
    	Object[] vector = new Object[yearsList.size()];
    	int i = 0;
    	for (int year : yearsList) {
			vector[i++]=year;
		}
    	return vector;
    }
    
    public static String getConvertedTownAndSpeciesName(String town){
        return town.substring(0,1).toUpperCase() + town.substring(1).toLowerCase();
    }

    public static int veryfyObject(Object object) {
    	return (object == null)? 0:(int)object;
    }
    
    public static Object[] convertInformation(Object[] info) {
    	info[3] = Integer.parseInt((String)info[3]);
    	info[4] = Integer.parseInt((String)info[4]);
    	info[5] = Util.toKilograms(Double.parseDouble((String)info[5]));
    	return info;
    }
    
    public static void editCultive(Cultive cultive, Object[] info) {
    	cultive.setSpecies((Species)info[2]);
    	cultive.setCultivatedQuantity((int)info[3]);
    	cultive.setHarvestedQuantity((int)info[4]);
    	cultive.setAverageWeightByHarvestedAnimalKg((double)info[5]);
    }
    
    public static HashMap<String, Object> convertToReportPerYear(HashMap<Integer, Long> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<Integer, Long>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<Integer, Long> entry = it.next();
            reportFormat.put(""+entry.getKey(), Double.parseDouble(""+entry.getValue()));
        }
        return reportFormat;
    }

    public static HashMap<String, Object> convertToReportPerTown(HashMap<Town, Double> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<Town, Double>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<Town, Double> entry = it.next();
            reportFormat.put(getConvertedTownName(entry.getKey()), entry.getValue());
        }
        return reportFormat;
    }

    public static String getConvertedTownName(Town town){
        return town.getName().substring(0,1).toUpperCase() + town.getName().substring(1).toLowerCase();
    }

    public static String getConvertedSpeciesName(Species species){
        return species.getName().substring(0,1).toUpperCase() + species.getName().substring(1).toLowerCase();
    }

    public static HashMap<String, Object> convertToReportPerSpecies(HashMap<Species, Double> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<Species, Double>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<Species, Double> entry = it.next();
            reportFormat.put(getConvertedSpeciesName(entry.getKey()), entry.getValue());
        }
        return reportFormat;
    }

    public static HashMap<String, Object> convertToReportPerSpeciesPerYear(HashMap<Integer, HashMap<Species, Double>> data) {
        HashMap<String, Object> reportFormat = new HashMap<>();
        HashMap<String,Object> hashTemp;
        Iterator<Entry<Integer, HashMap<Species,Double>>> it1 = data.entrySet().iterator();
        while(it1.hasNext()){
            Entry<Integer, HashMap<Species,Double>> entry1 = it1.next();
            Iterator<Entry<Species, Double>> it2 = entry1.getValue().entrySet().iterator();
            hashTemp = new HashMap<>();
            while(it2.hasNext()){
                Entry<Species, Double> entry2 = it2.next();
                hashTemp.put(entry2.getKey().getName(),entry2.getValue());
            }
            reportFormat.put(""+entry1.getKey(), hashTemp);
        }
        return reportFormat;
	}

    public static HashMap<String, Object> convertToReportFood(HashMap<Food,Integer> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<Food, Integer>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<Food, Integer> entry = it.next();
            reportFormat.put(entry.getKey().getName(), Double.parseDouble(""+entry.getValue()));
        }
        return reportFormat;
    }

    public static HashMap<String, Object> convertToReportWaterType(HashMap<WaterType,Integer> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<WaterType, Integer>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<WaterType, Integer> entry = it.next();
            reportFormat.put(entry.getKey().getName(), Double.parseDouble(""+entry.getValue()));
        }
        return reportFormat;
    }

	public static HashMap<String, Object> convertToReportPerTownPerYear(HashMap<Integer, HashMap<Town, Double>> data) {
        HashMap<String, Object> reportFormat = new HashMap<>();
        HashMap<String,Object> hashTemp;
        Iterator<Entry<Integer, HashMap<Town,Double>>> it1 = data.entrySet().iterator();
        while(it1.hasNext()){
            Entry<Integer, HashMap<Town,Double>> entry1 = it1.next();
            Iterator<Entry<Town, Double>> it2 = entry1.getValue().entrySet().iterator();
            hashTemp = new HashMap<>();
            while(it2.hasNext()){
                Entry<Town, Double> entry2 = it2.next();
                hashTemp.put(getConvertedTownName(entry2.getKey()),entry2.getValue());
            }
            reportFormat.put(""+entry1.getKey(), hashTemp);
        }
        return reportFormat;
	}

	public static HashMap<String, Object> convertToReportPerYearPerCultiveState(HashMap<Character, HashMap<Integer, Long>> data) {
        HashMap<String, Object> report = new HashMap<>();
        HashMap<String,Object> hashTemp;
        Iterator<Entry<Character, HashMap<Integer, Long>>> it1 = data.entrySet().iterator();
        while (it1.hasNext()){
            Entry<Character, HashMap<Integer, Long>> entry1 = it1.next();
            Iterator<Entry<Integer, Long>> it2 = entry1.getValue().entrySet().iterator();
            hashTemp = new HashMap<>();
            while (it2.hasNext()) {
                Entry<Integer, Long> entry2 = it2.next();
                hashTemp.put(""+entry2.getKey(),entry2.getValue());
            }
            report.put(getCultiveStateConstant(entry1.getKey()),hashTemp);
        }
		return report;
	}

	private static String getCultiveStateConstant(Character key){
        String constant = "";
        switch (key) {
            case FishFarmManager.HARVESTED_FISHES_STATE:
                constant = ConstantsGUI.T_CULTIVATED_CULTIVE_STATE;
                break;
            case FishFarmManager.CULTIVATED_FISHES_STATE:
                constant = ConstantsGUI.T_HARVESTED_CULTIVE_STATE;
                break;
            default:
                break;
        }
        return constant;
    }

    public static HashMap<String, Object> convertToReportPerTownPerCultiveStatePerYear(HashMap<Character, HashMap<Integer, HashMap<Town, Double>>> data) {
        HashMap<String, Object> report = new HashMap<>();
        HashMap<String,Object> hashTemp1;
        HashMap<String,Object> hashTemp2;
        Iterator<Entry<Character, HashMap<Integer, HashMap<Town, Double>>>> it1 = data.entrySet().iterator();
        while (it1.hasNext()) {
            Entry<Character, HashMap<Integer, HashMap<Town, Double>>> entry1 = it1.next();
            Iterator<Entry<Integer, HashMap<Town, Double>>> it2 = entry1.getValue().entrySet().iterator();
            hashTemp2 = new HashMap<>();
            while (it2.hasNext()){
                Entry<Integer, HashMap<Town, Double>> entry2 = it2.next();
                Iterator<Entry<Town, Double>> it3 = entry2.getValue().entrySet().iterator();
                hashTemp1 = new HashMap<>();
                while (it3.hasNext()) {
                    Entry<Town, Double> entry3 = it3.next();
                    hashTemp1.put(getConvertedTownName(entry3.getKey()),entry3.getValue());
                }
                hashTemp2.put(""+entry2.getKey(),hashTemp1);
            }
            report.put(getCultiveStateConstant(entry1.getKey()),hashTemp2);
        }
		return report;
	}
}
