package views;

import java.util.ArrayList;

import views.UtilView;

public enum CountValueToRoundNumber {

    //Importante: La lista de constantes de be estar ordenada en base al atributo 'value' en orden ascendente, 
    //              de lo contrario puede causar conflicto en las clases que hacen uso del enumerado. 
    ZERO(0,""), ONE(1,"K"), TWO(2,"M"), THREE(3,"KM"), FOUR(4,"B");

    private int value;
    private String text;

    CountValueToRoundNumber(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public static ArrayList<Integer> getValueList() {
        ArrayList<Integer> valueList = new ArrayList<>();
        for (CountValueToRoundNumber countValue : CountValueToRoundNumber.values()) {
            valueList.add(countValue.value);
        }
        return valueList;
    }

    public String getText() {
        return text;
    }

	public static String getRoundedValue(double value) {
	    double roundedValue = value;
	    String roundedValueFormat = "";
	    int count = 0;
	    while (roundedValue / 1000 >= 1 && count <= UtilView.getMaxValueInteger(CountValueToRoundNumber.getValueList())) {
	        roundedValue = UtilView.calculateRoundedValue(roundedValue);
	        count++;
	    }
	    roundedValueFormat = String.format("%1.1f", roundedValue) + UtilView.getCountValueToRoundNumber(count);
	    return roundedValueFormat;
	}
}
