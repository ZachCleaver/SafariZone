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
    private int pokeLevel;
    private int addExperienceByPetting = 50;
    private int currentExperience;
    private PokemonType pokemonType;
    private ArrayList<String> startingMoves = new ArrayList<>();

    public Pokemon(String pokemonName, boolean isItShiny){
        name = pokemonName;
        isShiny = isItShiny;
        shinyColoring = "";
        healthPoints = StatCreators.setStartingHealth(name);
        poopFactor = StatCreators.setDoesItPoop();
        pokeLevel = StatCreators.setStartingLevel();
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
        checkForLevelUp();
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
        System.out.println("Your " + name + " has the starting level of " + pokeLevel + " and has the starting health points of: " + healthPoints);
        System.out.println("Your " + name + " has " + movesKnown + " moves!");
        System.out.println("Your pokemon knows: " + startingMoves + "!");
        if (poopFactor) {
            System.out.println("Your " + name + " needs to poop!");
        }
    }

    private void checkForLevelUp() {
        int requiredXp = getTotalXpForLevel(pokeLevel + 1) - getTotalXpForLevel(pokeLevel);
        if (currentExperience >= requiredXp) {
            currentExperience -= requiredXp;
            pokeLevel++;
            System.out.println("Your " + name + " is now level " + pokeLevel + "!");
        } else {
            System.out.println("Keep training");
        }
    }

    private int getXpRequiredForLevel(int level) {
        if (level <= 1) {
            return 0;
        }

        return (int) (100 * Math.pow(1.25, level - 2));
    }

    private int getTotalXpForLevel(int targetLevel) {
        int total = 0;
        for (int i = 2; i <= targetLevel; i++) {
            total += getXpRequiredForLevel(i);
        }

        return total;
    }

    public void displayLevel() {
        int requiredXp = getTotalXpForLevel(pokeLevel + 1) - getTotalXpForLevel(pokeLevel);
        System.out.println("You need " + requiredXp + " XP for the next level.");
        System.out.println("You have " + currentExperience + " currently.");
    }
}
