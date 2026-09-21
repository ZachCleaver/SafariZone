package util;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Random;
import model.PokemonType;

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
    public static ArrayList<String> setTheStartingMoves(int movesKnown, PokemonType pokemonType) {
        ArrayList<String> startingMoves = MoveSet.getMoves(movesKnown, pokemonType);
        return startingMoves;
    }

    public static PokemonType declareType(String name) {
        PokemonType typeOfPokemon;
        if (name.contains("Mew")) {
            typeOfPokemon = PokemonType.PSYCHIC;
        } else if (name.contains("Snorlax")) {
            typeOfPokemon = PokemonType.NORMAL;
        } else {
            typeOfPokemon = PokemonType.WATER;
        }
        return typeOfPokemon;
    }
}
