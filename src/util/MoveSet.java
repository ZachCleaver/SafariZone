package util;

import model.PokemonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MoveSet {
    static ArrayList<String> whichListOfMovesToUse = new ArrayList<>();
    public static ArrayList<String> normalTypeMoves = new ArrayList<>(
            List.of("Bite", "Tailwhip", "Flash", "Roar", "Karate Chop")
    );
    public static ArrayList<String> waterTypeMoves = new ArrayList<>(
            List.of("Rain Dance", "Water Gun", "Water Shuriken", "Jet Punch", "Max Geyser")
    );
    public static ArrayList<String> psychicTypeMoves = new ArrayList<>(
            List.of("Calm Mind", "Psyblade", "Magic Coat", "Role Play", "Zen Headbutt")
    );

    public static ArrayList<String> getMoves(int movesKnown, PokemonType pokemonType) {
        if (pokemonType.equals(PokemonType.PSYCHIC)){
            whichListOfMovesToUse = psychicTypeMoves;
        } else if (pokemonType.equals(PokemonType.WATER)) {
            whichListOfMovesToUse = waterTypeMoves;
        } else {
            whichListOfMovesToUse = normalTypeMoves;
        }
        if (movesKnown >= whichListOfMovesToUse.size()) {
            return whichListOfMovesToUse;
        }
        ArrayList<String> listOfMoves = new ArrayList<>(movesKnown);
        while (listOfMoves.size() < movesKnown) {
            Random getRandomMove = new Random();
            int getMove = getRandomMove.nextInt(whichListOfMovesToUse.size());
            String randomMove = whichListOfMovesToUse.get(getMove);
            if (!listOfMoves.contains(randomMove)) {
                listOfMoves.add(randomMove);
            }
        }
        return listOfMoves;
    }
}