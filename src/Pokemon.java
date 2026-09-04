public class Pokemon {
    private String name;
    public Pokemon(String pokemonName){
        name = pokemonName;
    }

    public void petPokemon() {
        System.out.println(name + " " + name + "!");
    }
    public void renamePokemon(String newName) {
         name = newName;
    }
}
