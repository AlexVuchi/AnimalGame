package animalGame;

    
public class Animal {
    String name;
    String phyloClass;
    boolean laysEggs;
    boolean flies;
    boolean hasScales;
    boolean sixOrMoreLegs;
    boolean hasFeathers;
    boolean breatheUnderwater;
    boolean warmBlooded;
    
    public Animal(String name, String phyloClass, boolean laysEggs, boolean flies, boolean hasScales, 
            boolean sixOrMoreLegs, boolean hasFeathers, boolean breatheUnderwater, boolean warmBlooded) {
        this.name = name;
        this.phyloClass = phyloClass;
        this.laysEggs = laysEggs;
        this.flies = flies;
        this.hasScales = hasScales;
        this.sixOrMoreLegs = sixOrMoreLegs;
        this.hasFeathers = hasFeathers;
        this.breatheUnderwater = breatheUnderwater;
        this.warmBlooded = warmBlooded;
    }
    
        public void printInfo(){
        System.out.println("\n\nname: "+this.name);
        System.out.println("phyloClass: "+this.phyloClass);
        System.out.println("laysEggs: "+this.laysEggs);
        System.out.println("flies: "+this.flies);
        System.out.println("hasScales: "+this.hasScales);
        System.out.println("sixOrMoreLegs: "+sixOrMoreLegs);
        System.out.println("hasFeathers: "+this.hasFeathers);
        System.out.println("breatheUnderwater: "+this.breatheUnderwater);
        System.out.println("warmBlooded :"+this.warmBlooded);
    }

}
