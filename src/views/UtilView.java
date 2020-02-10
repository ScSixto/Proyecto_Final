package views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import views.ConstantsGUI;

import java.awt.Image;
import java.awt.Color;
import java.text.DecimalFormat;

public class UtilView {

    private static DecimalFormat doubleFormat = new DecimalFormat("#.###");

    public static HashMap<String, Double> getPercentValues(HashMap<String, Double> normalValues) {
        HashMap<String, Double> percentValues = new HashMap<>();
        double maxValue = getMaxValue(getHasMapValues(normalValues));
        Iterator<Entry<String, Double>> it = normalValues.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Double> value = it.next();
            percentValues.put(value.getKey(), value.getValue() * 100 / maxValue);
        }
        return percentValues;
    }

    public static double getMaxValue(ArrayList<Double> values) {
        double maxValue = 0;
        for (double value : values) {
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static int getMaxValueInteger(ArrayList<Integer> values) {
        int maxValue = 0;
        for (Integer value : values) {
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static Color getRandomColor() {
        int r = getRandomNumBetween(120, 255);
        int g = 0;
        int b = 0;
        if (r > 120) {
            g = getRandomNumBetween(120, 255);
            b = getRandomNumBetween(20, 170);
        } else {
            g = getRandomNumBetween(1, 125);
            b = getRandomNumBetween(35, 240);
        }
        return new Color(r, g, b);
    }

    public static int getRandomNumBetween(int minValue, int maxValue) {
        return (int) (((Math.random() * (maxValue - minValue))) + minValue);
    }

    public static String getRoundedValue(double value) {
        double roundedValue = value;
        String roundedValueFormat = "";
        int count = 0;
        while (roundedValue / 1000 >= 1 && count <= getMaxValueInteger(CountValueToRoundNumber.getValueList())) {
            roundedValue = calculateRoundedValue(roundedValue);
            count++;
        }
        roundedValueFormat = String.format("%1.1f", roundedValue) + getCountValueToRoundNumber(count);
        return roundedValueFormat;
    }

    public static double calculateRoundedValue(double value) {
        return value / 1000;
    }

    public static String getCountValueToRoundNumber(int count) {
        int countMaxValueToRoundNumber = getMaxValueInteger(CountValueToRoundNumber.getValueList());
        String countText = CountValueToRoundNumber.values()[countMaxValueToRoundNumber].getText();
        for (CountValueToRoundNumber countValue : CountValueToRoundNumber.values()) {
            if (count == countValue.getValue()) {
                countText = countValue.getText();
            }
        }
        return countText;
    }

    public static ArrayList<Double> getHasMapValues(HashMap<String, Double> hashMap) {
        ArrayList<Double> hashMapValues = new ArrayList<>();
        Iterator<Entry<String, Double>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            hashMapValues.add(it.next().getValue());
        }
        return hashMapValues;
    }

    public static String formatDouble(double num){
        String parcialFormatedDouble = doubleFormat.format(num);;
        String formatedDouble = "";
        int i = parcialFormatedDouble.length()-1;
        while(i >= 0 && parcialFormatedDouble.charAt(i) != doubleFormat.getDecimalFormatSymbols().getDecimalSeparator()){
            formatedDouble = parcialFormatedDouble.charAt(i) + formatedDouble;
            i--;
        }
        formatedDouble = (i < 0)?formatInteger(Long.parseLong(parcialFormatedDouble)):formatInteger(Long.parseLong(parcialFormatedDouble.substring(0,i))) + doubleFormat.getDecimalFormatSymbols().getDecimalSeparator() + formatedDouble;
        return formatedDouble;
    }

    public static String formatInteger(long num) {
        String parcialFormatedInteger = ""+num;
        String formatedInteger = "";
        int thousandCount = 0;
        for (int i = parcialFormatedInteger.length() - 1; i >= 0 ; i--) {
            formatedInteger = getNumericSeparator(thousandCount) + formatedInteger;
            for (int j = 0; j <= i && j < 3; j++) {
                formatedInteger = parcialFormatedInteger.charAt(i-j) + formatedInteger;
            }
            i -= 2;
            thousandCount++;
        }
        return formatedInteger;
    }

    private static String getNumericSeparator(int thousandCount) {
        String numericSeparator = "";
        if(thousandCount > 0){
            if(thousandCount%2 == 0){
                for(int i = 0; i < thousandCount/2; i++) {
                    numericSeparator += "'";
                }
            }else{
                numericSeparator = ".";
            }
        }
        return numericSeparator;
    }
    
    public static HashMap<String, ArrayList<Object[]>> formatCultivesTable(HashMap<String, ArrayList<Object[]>> cultivesTable){
		Iterator<Entry<String, ArrayList<Object[]>>> it = cultivesTable.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, ArrayList<Object[]>> entry = it.next();
			for (Object[] objectArray : entry.getValue()) {
				objectArray[3] = UtilView.formatDouble((int)objectArray[3]);
				objectArray[4] = UtilView.formatDouble((int)objectArray[4]);
				objectArray[5] = UtilView.formatDouble((double)objectArray[5]);
				objectArray[6] = "COL$ " + UtilView.formatDouble((double)objectArray[6]);
			}
		}
		return cultivesTable;
	}

	public static double getCircleGraphicAngle(int circleMaxValue, Double value) {
		return value * ConstantsGUI.CIRCLE_GRAPHIC_MAX_ANGLE / circleMaxValue;
    }
    
    public static String getHashMapValuesClass(HashMap<String, Object> data){
        String valuesClass = "Object";
        Iterator<Entry<String, Object>> it = data.entrySet().iterator();
        if(it.hasNext()){
            Entry<String, Object> entry = it.next();
            valuesClass = entry.getValue().getClass().getSimpleName();
        }
        // System.out.println(valuesClass + " ome " + Double.class.getSimpleName());
        // System.out.println(HashMap.class.getSimpleName());
        return valuesClass;
    }

	public static HashMap<String, Double> convertGraphicData(HashMap<String, Object> valueList) {
        HashMap<String, Double> retorno = new HashMap<>();
        Iterator<Entry<String, Object>> it= valueList.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Object> entry = it.next();
            retorno.put(entry.getKey(),(double)entry.getValue());
        }
		return retorno;
	}

    public static Icon convertToIcon(String route, int width, int heigth) {
        ImageIcon icon = new ImageIcon(route);
        Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(width,heigth, Image.SCALE_SMOOTH));
        return scaleIcon;
    }

	public static int getShowingValueQuantity(int valueQuantity){
        int retorno = valueQuantity;
        while (retorno >= ConstantsGUI.GRAPHIC_MAX_DATA_QUANTITY) {
            retorno /= 2;
        }
		return retorno-1;
	}
}