package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoveSet {
    public static ArrayList<String> normalTypeMoves = new ArrayList<>(
            List.of("Bite", "Tailwhip", "Flash", "Roar", "Karate Chop")
    );

    public static ArrayList<String> getMoves(int movesKnown) {
        ArrayList<String> listOfMoves = new ArrayList<>(movesKnown);
        while (listOfMoves.size() < movesKnown) {
            Random getRandomMove = new Random();
            int getMove = getRandomMove.nextInt(normalTypeMoves.size());
            String randomMove = normalTypeMoves.get(getMove);
            if (!listOfMoves.contains(randomMove)) {
                listOfMoves.add(randomMove);
            }
        }
        return listOfMoves;
    }


}

//Loop: Check if name to add to getMoves is already in list of normalTypeMoves.
//