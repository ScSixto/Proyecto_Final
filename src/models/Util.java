package models;

import java.util.ArrayList;

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
    		vector[i++] = object[1];
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
    
    public static int veryfyObject(Object object) {
    	return (object == null)? 0:(int)object;
    }
}
