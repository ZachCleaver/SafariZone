// List of available Pokemon to catch
private ArrayList<String> pokemonInSafari = new ArrayList<>(
        List.of("Snorlax", "Magmar", "Squirtle")
);

private final Scanner scanner = new Scanner(System.in);

private final String CATCH_ACTION = "CATCH";
private final String LIST_POKEMON_IN_INVENTORY = "LIST";
private final String RELEASE_ACTION = "RELEASE";
private final String SHOW_ACTION = "SHOW";
private final String DONE_ACTION = "DONE";
private final String RENAME_POKEMON = "RENAME";
private final String PET_ACTION = "PET";

// Valid actions a user can enter in the console

private ArrayList<String> validActions = new ArrayList<>(
        List.of(CATCH_ACTION, RELEASE_ACTION, LIST_POKEMON_IN_INVENTORY, SHOW_ACTION, RENAME_POKEMON, PET_ACTION, DONE_ACTION)
);

// Player's inventory for each Pokemon they've caught
private ArrayList<String> pokemonInInventory = new ArrayList<>();

void main() {
    showWelcomeMessage();

    String userAction = "";

    // Main loop to allow user to input actions in the console
    while (true) {
        userAction = scanner.nextLine();
        performAction(userAction);
    }
}

/**
 * Shows a welcome message to the user.
 */
private void showWelcomeMessage() {
    System.out.println("Welcome to the Pokemon Safari! We have " + pokemonInSafari.size() + " unique type of Pokemon to catch.");
    System.out.println("Use the following actions: " + validActions);
    System.out.println("Gotta catch 'em all!");

}

/**
 * Performs an action.
 *
 * @param action String action the user is performing
 */
private void performAction(String action) {
    String actionInAllCaps = action.toUpperCase();
    if (!validActions.contains(actionInAllCaps)) {
        System.out.println("Invalid action performed! I don't know what " + action + " means...");
        return;
    }

    if (CATCH_ACTION.equals(actionInAllCaps)) {
        catchPokemon();
    } else if (RELEASE_ACTION.equals(actionInAllCaps)) {
        releasePokemon();
    } else if (DONE_ACTION.equals(actionInAllCaps)) {
        endGame();
    } else if (LIST_POKEMON_IN_INVENTORY.equals(actionInAllCaps)) {
        listPokemon();
    } else if (SHOW_ACTION.equals(actionInAllCaps)) {
        showAllAvailablePokemonInSafari();
    } else if (PET_ACTION.equals(actionInAllCaps)) {
        petPokemon();
    } else if (RENAME_POKEMON.equals(actionInAllCaps)) {
        renamePokemon();
    } else {
        System.out.println("Well that didn't work...");
    }
}

/**
 * Lists all possible Pokemon the user can catch.
 */
private void showAllAvailablePokemonInSafari() {
    System.out.println("Here are all the Pokemon you can catch:");
    System.out.println(pokemonInSafari);
}

/**
 * Catches a random Pokemon and adds it to the user's inventory.
 */
private void catchPokemon() {
    // Generates a random number between the first int and up to (but not including) the last int
    Random rand = new Random();
    String getPokemon = "";
    int randomNumber = rand.nextInt(1, 101);
    if (randomNumber <= 30) {
       getPokemon = pokemonInSafari.get(1);
        System.out.println("You caught a " + getPokemon + "!");
    } else if (randomNumber >= 31 && randomNumber <=80) {
        getPokemon = pokemonInSafari.get(2);
        System.out.println("You caught a " + getPokemon + "!");
    } else {
       getPokemon = pokemonInSafari.get(0);
        System.out.println("You caught a the rare " + getPokemon + "!");
    }
    pokemonInInventory.add(getPokemon);
//    String randomlySelectedPokemon = pokemonInSafari.get(randomNumber);
//
//    System.out.println("You caught a " + randomlySelectedPokemon + "!");
//    pokemonInInventory.add(randomlySelectedPokemon);
    trySpecialEvent(getPokemon);
}

private void trySpecialEvent(String pokemon) {
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/" + pokemon)) {
        if (inputStream == null) {
            return;
        }

        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
        System.out.println(result);
    } catch (IOException e) {
        // No special event for you!
    }
}

/**
 * Allows the user to release a Pokemon. Can either release by passing in the exact name,
 * or by providing a number equaling the index of the Pokemon to remove from the user's list.
 */
private void releasePokemon() {
    System.out.println("You have " + pokemonInInventory.size() + " Pokemon. Which one do you want to release?");
    System.out.println(pokemonInInventory);

    // If user provided a number, remove a Pokemon based on the index of the List
    if (scanner.hasNextInt()) { //Removes accurate index of pokemon and states if not valid input
        int pokemonIndexToRemove = Integer.parseInt(scanner.nextLine());
        if (pokemonIndexToRemove < 0 || pokemonIndexToRemove >= pokemonInInventory.size()) {
            System.out.println("Do you not know basic math computations?");
        } else {
            String releasedPokemon = pokemonInInventory.get(pokemonIndexToRemove);
            pokemonInInventory.remove(pokemonIndexToRemove);
            System.out.println("Your Pokemon " + releasedPokemon + " has been removed!");
        }
    } else { // Remove a Pokemon by its name
        String pokemonNameToRemove = scanner.nextLine();

        if (!pokemonInInventory.contains(pokemonNameToRemove)) {
            System.out.println("Pokemon named " + pokemonNameToRemove + " doesn't exist!");
        } else {
            pokemonInInventory.remove(pokemonNameToRemove);
            System.out.println("Pokemon has been removed!");
        }
    }
}

private void listPokemon() {
    System.out.println("You've caught " + pokemonInInventory.size() + " Pokemon so far:");
    System.out.println(pokemonInInventory);
}

private void petPokemon() {
    System.out.println("");
}

private void renamePokemon() {
    System.out.println("Which Pokemon would you like to rename?");
    System.out.println(pokemonInInventory);
    String orginalPokemon = scanner.nextLine();
    int indexOfPokemon;
    if (pokemonInInventory.contains(orginalPokemon)) {
        indexOfPokemon = pokemonInInventory.indexOf(orginalPokemon);
        System.out.println("Enter new name.");
        String namePokemon = scanner.nextLine();
        pokemonInInventory.set(indexOfPokemon, namePokemon);
//        pokemonInInventory.add(namePokemon);
        System.out.println("Your pokemon " + orginalPokemon + " is now named " + namePokemon + "!");
//        pokemonInInventory.remove(orginalPokemon);
    } else {
        System.out.println("That is not a valid Pokemon you have caught, try again.");
    }
}

private void endGame() {
    System.out.println("Thanks for playing!");
    System.out.println("You caught: " + pokemonInInventory.size() + " pokemon!");
    System.out.println("Look at you go!");
    System.exit(0);
}
/**
 * Feed a random Pokemon and output if it was yummy or not!
 */
private void feedPokemon() {
    // TODO: Implement me
}
