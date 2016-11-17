package animalGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimalReader {
    String folderPath;
    FileReader fr;
    Scanner s;
	
    Map<String, Boolean> traits = new HashMap<>();
    Animal[] animalList;
    int numAnimals = 0;
    
    String name, phyloClass;
    boolean laysEggs, flies, hasScales, sixOrMoreLegs, 
            hasFeathers, breatheUnderwater, warmBlooded;
    
    //sets the folder that contains all animals
    public AnimalReader(String folderPath){
    	this.folderPath = folderPath;
    	animalList = new Animal[100];
    }
    
    public AnimalReader(String folderPath, int maxAnimals){
    	this.folderPath = folderPath;
    	animalList = new Animal[maxAnimals];
    }
    
    //reads an individual file, calls the getTrait() method each line
    public void readFromText(String filepath)throws FileNotFoundException{
        fr = new FileReader(filepath);
        s = new Scanner(fr);
        String line = "error";
        while(s.hasNextLine()){
            line = s.nextLine();
            getTrait(line);
        }
    }
    
    //separates a string into a key and a value, storing it in a map or a string value
    public void getTrait(String line){
        String[] field = line.split(" ");
        String fieldName = field[0];
        if(!(fieldName.equals("name")||fieldName.equals("phyloClass"))){
            traits.put(fieldName, Boolean.parseBoolean(field[1]));
        }
        else if(fieldName.equals("name"))name = field[1];
        else if(fieldName.equals("phyloClass"))phyloClass = field[1];
    }
    
    //sets up boolean traits for an individual animal
    public void setTraits(){
    	flies = traits.get("flies");
        laysEggs = traits.get("laysEggs");
        hasScales = traits.get("hasScales");
        hasFeathers = traits.get("hasFeathers");
        warmBlooded = traits.get("warmBlooded");
        sixOrMoreLegs = traits.get("sixOrMoreLegs");
        breatheUnderwater = traits.get("breatheUnderwater");
    }
    
    //takes all the traits set up and creates an animal in a list
    public void createAnimal(){
        Animal currAnimal = new Animal(name, phyloClass, laysEggs, flies, hasScales, 
    		      	   		sixOrMoreLegs, hasFeathers, breatheUnderwater, warmBlooded);
    	animalList[numAnimals] = currAnimal;
        numAnimals ++;
    }
    
    //the "big" method that makes all of the previous ones work together
    public Animal[] getAnimalList(){
    	File[] fileList = new File(folderPath).listFiles();
    	for(int i=0; i<fileList.length; i++){
    		if(fileList[i].isFile()){
                    try{
                        readFromText(folderPath+"/"+fileList[i].getName());
    			setTraits();
    			createAnimal();
                    }
                    
                    catch(FileNotFoundException e){
                        System.out.println("Error in reading the animal files. File is not found.");
                    }
    		}
    	}
    	return animalList;
    }
    
    
}

