import model.PokemonType;
import org.junit.Test;
import util.MoveSet;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MoveSetTest {
    @Test
    public void getBackMovesTest() {
        List<String> moves = MoveSet.getMoves(3, PokemonType.PSYCHIC);

        assertEquals(3, moves.size());
    }

    @Test
    public void getTooManyMovesTest() {
        List<String> moves = MoveSet.getMoves(10, PokemonType.PSYCHIC);

        assertEquals(5, moves.size());
    }
}
