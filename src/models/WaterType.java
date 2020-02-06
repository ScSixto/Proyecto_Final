package models;

public enum WaterType{
    
    SALTWATER("Agua salada"), SWEET_WATER("Agua dulce");

    private String name;

    WaterType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}