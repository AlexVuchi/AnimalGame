package animalGame;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AnimalGame {
    Animal[] animalList;
    int numAnimals;

    //TRAITS IN ORDER:
    //laysEggs, flies, hasScales, sixOrMoreLegs, hasFeathers, breatheUnderwater, warmBlooded;
        
    int numTraits = 7;
    int askedQuestionsNum = 0;
    String x;
    
    String[] alreadyAsked = new String[numTraits];
    
    String[] traitNames = {
        "laysEggs", 
        "flies", 
        "hasScales", 
        "sixOrMoreLegs", 
        "hasFeathers", 
        "breatheUnderwater", 
        "warmBlooded"
    };
    
    String[] traitQuestions = {
        "Does your animal lay eggs?",
        "Can your animal fly?",
        "Does your animal have scales?",
        "Does your animal have six or more legs?",
        "Does your animal have feathers?",
        "Can your animal breathe underwater?",
        "Is your animal warm blooded?",
    };
    
//    public void setX(String a){
//        x = a;
//    }
//    public String outputX(){
//        return x;
//    }
    
    public AnimalGame(Animal[] animalList, int numAnimals){
        this.animalList = animalList;
        this.numAnimals = numAnimals;
    }
    
    public void printAnimalList(){
        for (int i = 0; i < numAnimals; i++) {
            //System.out.println(i);
            System.out.println(animalList[i].name);
        }
    }
    
    public static int getIndexOf(String[] list, String s){
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if(s.equals(list[i])){
                index = i;
                break;
            }
        }
        //System.out.println(index);
        return index;
    }
    
    public boolean getAnimalTrait(Animal animal, String traitName){
        if(traitName.equals("laysEggs"))return animal.laysEggs;
        else if(traitName.equals("flies"))return animal.flies;
        else if(traitName.equals("hasScales"))return animal.hasScales;
        else if(traitName.equals("sixOrMoreLegs"))return animal.sixOrMoreLegs;
        else if(traitName.equals("hasFeathers"))return animal.hasFeathers;
        else if(traitName.equals("breatheUnderwater"))return animal.breatheUnderwater;
        else if(traitName.equals("warmBlooded"))return animal.warmBlooded;
        else {
            System.out.println("Error in getAnimalTrait method; Cannot find traitName");
            return false;
        }
    }
    
    //use with a text-based version
    public boolean askQuestion(String question){
    	Scanner s = new Scanner(System.in);
    	System.out.println(question);
        String input = s.next().toLowerCase();
        if(input.startsWith("y")){
            return true;
        }
        else return false;
    }
    
    
    public Animal[] getNewAnimalList(boolean userInput, String questionAsked){
        Animal[] newList = new Animal[100];
        int newNumAnimals = 0;
        
        int traitIndex = getIndexOf(traitQuestions, questionAsked);
        String traitToCheck = traitNames[traitIndex];
        for (int i = 0; i < numAnimals; i++) {
            if(getAnimalTrait(animalList[i], traitToCheck)==userInput){
                newList[newNumAnimals] = animalList[i];
                newNumAnimals ++;
                
            }
        }
        for (int i = 0; i < newNumAnimals; i++) {
            System.out.println(newList[i].name);
            
        }
        this.numAnimals = newNumAnimals;
        return newList;
    }
    
    //Determines which question would exclude 50% or closest to 50% of all animals in the database
    public String findNextQuestion(Animal[] animalList){
        //System.out.println("Hi");
        Animal currAnimal;
        int[] fieldCounts = new int[numTraits];
        
        
        for (int i = 0; i < fieldCounts.length; i++) {
            fieldCounts[i] = 0;
        }
        
        for(int i = 0; i < numAnimals; i++) {
            currAnimal = animalList[i];
            boolean[] fields = {currAnimal.laysEggs, currAnimal.flies, currAnimal.hasScales, currAnimal.sixOrMoreLegs, 
                                currAnimal.hasFeathers, currAnimal.breatheUnderwater, currAnimal.warmBlooded};
            
            //currAnimal.printInfo();
            
            for (int j = 0; j < fields.length; j++) {
                if(fields[j]==true){
                    fieldCounts[j] ++;
                }
            }
        }
        
        //checks which traits is closest to including 50% of all animals
        int chosenTraitIndex = 0;
        double percent;
        
        for (int i = 0; i < fieldCounts.length; i++) {
            percent = (double)fieldCounts[i]/(double)numAnimals*100;
            //System.out.println(traitNames[i]+": "+percent);
            
            if(Math.abs(percent-50) < Math.abs((double)fieldCounts[chosenTraitIndex]*100/(double)numAnimals-50)){
                chosenTraitIndex = i;
            }
        }
        
        String chosenTrait = traitNames[chosenTraitIndex];
        alreadyAsked[askedQuestionsNum] = chosenTrait;
        askedQuestionsNum ++;
        
        //System.out.println("Chosen trait: "+chosenTrait);
        return traitQuestions[chosenTraitIndex];
    }
    
    
    public void printAlreadyAsked(){
        for (int i = 0; i < alreadyAsked.length; i++) {
            System.out.println(alreadyAsked[i]);
        }
    }
    
    public String printAnswer(){
        String a = animalList[0].name;
        return a;
        
    }
    
    //TODO:
    //Return string question to Alex's program, 
    //Retrieve True/False response from Alex's Program
    //Choose next Question
    //Set defining questions for animals	
    
//    public static void main(String[] args){
//        String question;
//        boolean answer;
//    	
//    	AnimalReader ar = new AnimalReader("animals");
//        AnimalGame ag = new AnimalGame(ar.getAnimalList(), ar.numAnimals);
//
//        //System.out.println(ag.numAnimals);
//        
//        while(ag.numAnimals>1){
//            //ag.printAnimalList();
//            question = ag.findNextQuestion(ag.animalList);
//            //ag.printAlreadyAsked();
//            if(AnimalGame.getIndexOf(ag.alreadyAsked,question)!= -1){
//                break;
//            }
//            answer = ag.askQuestion(question);
//            ag.animalList = Arrays.copyOf(ag.getNewAnimalList(answer, question),ag.animalList.length);
//            
//            
//            //System.out.println(ag.numAnimals);
//            //ag.printAnimalList();
//        }
//        
//        for (int i = 0; i < ag.numAnimals; i++) {
//            System.out.println("I believe that your animal is a(n): "+ag.animalList[i].name);
//        }
//    	
//    }

}


