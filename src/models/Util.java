package models;

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
}
