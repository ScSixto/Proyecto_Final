package models;

import java.text.DecimalFormat;

public class TesterMetodos {

    private static DecimalFormat doubleFormat = new DecimalFormat("#.###");

    public static String formatDouble(double num){
        String parcialFormatedDouble = doubleFormat.format(num);;
        String formatedDouble = "";
        int i = parcialFormatedDouble.length()-1;
        while(i >= 0 && parcialFormatedDouble.charAt(i) != doubleFormat.getDecimalFormatSymbols().getDecimalSeparator()){
            formatedDouble = parcialFormatedDouble.charAt(i) + formatedDouble;
            i--;
        }
        formatedDouble = formatInteger(Long.parseLong(parcialFormatedDouble.substring(0,i))) + doubleFormat.getDecimalFormatSymbols().getDecimalSeparator() + formatedDouble;
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
        System.out.println("Entero: "+formatedInteger);
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

    // public static void main(String[] args) {
    //     System.out.println(TesterMetodos.formatDouble(321234343345634531.2));
    // }
}