package util;

import java.util.ArrayList;
import java.util.Random;

public class StatCreators {
    private static Random randomGen = new Random();


    public static int setStartingHealth(String name) {
        int healthPoints;
        if (name.contains("Mew")) {
            healthPoints = randomGen.nextInt(30, 49);
        } else if (name.contains("Snorlax")) {
            healthPoints = randomGen.nextInt(42, 75);
        } else {
            healthPoints = randomGen.nextInt(20, 42);
        }
        return healthPoints;
    }

    public static boolean setDoesItPoop() {
        boolean poopFactor = false;
        int doesItPoop = randomGen.nextInt(1, 101);
        if (doesItPoop >= 95) {
            poopFactor = true;
        }
        return poopFactor;
    }

    public static int setStartingLevel() {
        int initialLevel;
        initialLevel = randomGen.nextInt(1, 4);
        return initialLevel;
    }

    public static int setNumberOfStartingMoves() {
        int movesKnown;
        movesKnown = randomGen.nextInt(1, 4);
        return movesKnown;
    }
    public static ArrayList<String> setTheStaringMoves(int movesKnown) {
        ArrayList<String> startingMoves = MoveSet.getMoves(movesKnown);
        return startingMoves;
    }

}
