import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
    public ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();

    public void listPokemon() {
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemon.getName());
        }
    }
}
