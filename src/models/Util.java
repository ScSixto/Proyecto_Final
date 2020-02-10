package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

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

    public static HashMap<String, Object> convertToReportSpeciesPerYear(HashMap<Species, Double> data){
        HashMap<String, Object> reportFormat = new HashMap<>();
        Iterator<Entry<Species, Double>> it = data.entrySet().iterator();
        while (it.hasNext()){
            Entry<Species, Double> entry = it.next();
            reportFormat.put(getConvertedSpeciesName(entry.getKey()), entry.getValue());
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
}
