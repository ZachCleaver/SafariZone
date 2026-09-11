import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    @Test
    public void test_renamePokemon() {
        Pokemon pokemon = new Pokemon("Pikachu");
        pokemon.renamePokemon("Garble");
        assertEquals("Garble", pokemon.getName());
    }
}

