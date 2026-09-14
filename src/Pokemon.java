public class Pokemon {
    private String name;
    private boolean isShiny;
    public Pokemon(String pokemonName, boolean isItShiny){
        name = pokemonName;
        isShiny = isItShiny;
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
}
