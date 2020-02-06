package models;

import exeptions.UnfoundObject;

import java.util.ArrayList;

public class Town{

    public static final int VALUE_NOT_FOUND_CODE = -1;
    public static final String CULTIVE_UNFOUNDED_MESSAGE = "Cultivo no encontrado.";

    private int id;
    private static int sequential = 0;
    private String name;
    private ArrayList<Cultive> cultiveList;

    public Town(String name) {
        this.id = Town.sequential++;
        this.name = name;
        this.cultiveList = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void addCultive(Cultive cultive){
        this.cultiveList.add(cultive);
    }

    public void removeCultive(int id) throws UnfoundObject{
        this.cultiveList.remove(this.cultiveList.get(this.searchCultive(id)));
    }

    public int searchCultive(int id) throws UnfoundObject{
        int position = VALUE_NOT_FOUND_CODE;
        for(int i = 0; i < cultiveList.size(); i++)
            if(cultiveList.get(i).getId() == id){
                position = i;
                break;
            }
        if(position == VALUE_NOT_FOUND_CODE) throw new UnfoundObject(CULTIVE_UNFOUNDED_MESSAGE);
        else return position;
    }

    public ArrayList<Cultive> getCultiveList(){
        return cultiveList;
    }
    
    public ArrayList<Object[]> toObjectVectorCultives(){
    	ArrayList<Object[]> toObjectVectorCultives = new ArrayList<>();
    	for (Cultive cultive : cultiveList) {
    		toObjectVectorCultives.add(cultive.toObjectVector());
		}
    	return toObjectVectorCultives;
    }
    
    public Object[] toObjectVector() {
    	return new Object[] {this.id,this.name,this.toObjectVectorCultives()};
    }
}