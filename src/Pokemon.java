import java.util.Random;

public class Pokemon {
    private String name;
    private boolean isShiny;
    private String shinyColoring;
    private int healthPoints;
    private boolean poopFactor;
    private int movesKnown;
    private int initialLevel;
    private Random randomGen = new Random();

    public Pokemon(String pokemonName, boolean isItShiny){
        name = pokemonName;
        isShiny = isItShiny;
        shinyColoring = "";
        setStartingHealth();
        setDoesItPoop();
        setStartingLevel();
        setNumberOfStartingMoves();
    }
    public void petPokemon() {
//        System.out.println(name + " " + name + "!");
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
        System.out.println("Your " + name + " has the starting level of " + initialLevel + " and has the starting health points of: " + healthPoints);
        System.out.println("Your " + name + " has " + movesKnown + " moves!");
        if (poopFactor) {
            System.out.println("Your " + name + " needs to poop!");
        }
    }

    private void setStartingHealth() {
        if (name.contains("Mew")) {
            healthPoints = randomGen.nextInt(30, 49);
        } else if (name.contains("Snorlax")) {
            healthPoints = randomGen.nextInt(42, 75);
        } else {
            healthPoints = randomGen.nextInt(20, 42);
        }
    }

    private void setDoesItPoop() {
        int doesItPoop = randomGen.nextInt(1, 101);
        if (doesItPoop >= 95) {
            poopFactor = true;
        }
    }

    private void setStartingLevel() {
        initialLevel = randomGen.nextInt(1, 3);
    }

    private void setNumberOfStartingMoves() {
        movesKnown = randomGen.nextInt(1, 3);
    }

}
