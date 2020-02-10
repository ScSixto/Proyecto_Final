package persistence;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.FileFormatInvalid;

public class TxtFile implements FileFormat {

    public static final char TOWN_SEPARATOR = ';';
    public static final char TOWN_FIELD_SEPARATOR = ':';
    public static final char CULTIVE_FIELD_SEPARATOR = '/';
    public static final char CULTIVE_ARRAY_SEPARATOR = ',';

    @Override
    @SuppressWarnings("unchecked")
    public void createFile(ArrayList<Object[]> data, String filePath) throws IOException, FileFormatInvalid {
        ArrayList<String> report = new ArrayList<>();
        for (Object[] objectArray : data) {
            String town = "";
            town += "" + objectArray[0];
            town += TOWN_FIELD_SEPARATOR + "" + objectArray[1];
            String cultiveArray = "";
            for (Object[] object : (ArrayList<Object[]>) objectArray[2]) {
                String cultive = "";
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[0];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[1];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[2];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[3];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[4];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[7];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[5];
                cultive += CULTIVE_FIELD_SEPARATOR + "" + object[6];
                cultiveArray += CULTIVE_ARRAY_SEPARATOR + cultive;
            }
            town += TOWN_FIELD_SEPARATOR + cultiveArray;
            report.add(town);
        }
        new WriterManager().writeFile(filePath, report);
    }
}