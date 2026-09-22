import model.PokemonType;
import util.StatCreators;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private boolean isShiny;
    private String shinyColoring;
    private int healthPoints;
    private boolean poopFactor;
    private int movesKnown;
    private int initialLevel;
    private int startingExperiencePoints;
    private int addExperienceByPetting = 50;
    private int currentExperience;
    private double levelIncreaseModifier;
    private double expNeededToLevel;
    private int pokeLevel;
    private PokemonType pokemonType;
    private ArrayList<String> startingMoves = new ArrayList<>();

    public Pokemon(String pokemonName, boolean isItShiny){
        name = pokemonName;
        isShiny = isItShiny;
        shinyColoring = "";
        healthPoints = StatCreators.setStartingHealth(name);
        poopFactor = StatCreators.setDoesItPoop();
        initialLevel = StatCreators.setStartingLevel();
        startingExperiencePoints = initialLevel * 100;
        currentExperience = startingExperiencePoints;
        movesKnown = StatCreators.setNumberOfStartingMoves();
        pokemonType = StatCreators.declareType(name);
        startingMoves = StatCreators.setTheStartingMoves(movesKnown, pokemonType);
    }
    public void petPokemon() {
        currentExperience = currentExperience + addExperienceByPetting;
        if (name.contains("Mew")) {
            System.out.println("Mewww!!!");
        } else if (name.contains("Squirtle")) {
            System.out.println("Squirt all over my face!");
        } else if (name.contains("Snorlax")) {
            System.out.println("*Yawns and rolls over*");
        } else {
            System.out.println(name + " " + name + "!");
        }
        if (isShiny) {
            System.out.println("I am shiny, bitch!");
        }
        System.out.println("Your " + name + " gained " + addExperienceByPetting);
        System.out.println("Total experience is at " + currentExperience);
    }
    public void renamePokemon(String newName) {
         name = newName;
    }
    public String getName() {
        return name;
    }
    public boolean getShiny() {
        return isShiny;
    }
    public void setShinyColor(String getShinyColor) {
        if (isShiny) {
            shinyColoring = getShinyColor;
        }
    }
    public String getShinyColoring() {
        return shinyColoring;
    }

    public void printStartingStats() {
        System.out.println("You caught a " + pokemonType + " Pokemon!");
        System.out.println("Your " + name + " has the starting level of " + initialLevel + " and has the starting health points of: " + healthPoints);
        System.out.println("Your " + name + " has " + movesKnown + " moves!");
        System.out.println("Your pokemon knows: " + startingMoves + "!");
        if (poopFactor) {
            System.out.println("Your " + name + " needs to poop!");
        }
    }

    /**Attempted to create compounding experience needed to level.
     * Supposed to take the starting experiences points and times it by 1.25 to create experience needed for next level
     * Is supposed to continously evolve the experienced needed for each level by the same recipe.
     * Does not fully work
     */
//    public void calculateExperienceLevel() {
//        levelIncreaseModifier = (startingExperiencePoints * 1.25);
//        System.out.println(levelIncreaseModifier);
//        expNeededToLevel = (int)levelIncreaseModifier - currentExperience;
//        System.out.println(expNeededToLevel);
//        if (expNeededToLevel > 0) {
//            System.out.println("You need " + expNeededToLevel + " more experience to level!");
//        } else {
//            pokeLevel = initialLevel++;
//            int leftOverExp = currentExperience - (int)levelIncreaseModifier;
//            expNeededToLevel = (currentExperience - leftOverExp) *1.25;
//            levelIncreaseModifier = expNeededToLevel;
//            System.out.println("Your " + name + " is now level " + pokeLevel + "!");
//            System.out.println("Your " + name + " now needs " + expNeededToLevel + "!");
//        }
//        }

    public void displayLevel() {
        currentExperience /= 100;
        System.out.println("Your " + " is at level " + currentExperience);
    }
}
