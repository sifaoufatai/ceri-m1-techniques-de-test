package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a Pokedex that stores information about captured Pokemon.
 * It provides methods to manage Pokemon such as adding, retrieving, and sorting.
 * Usage example:
 * <pre>{@code
 * IPokemonMetadataProvider metadataProvider = new SomeMetadataProvider();
 * IPokemonFactory pokemonFactory = new SomePokemonFactory();
 * IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
 * }</pre>
 *
 * @author [Your Name]
 * @see IPokedex
 * @see IPokemonMetadataProvider
 * @see IPokemonFactory
 */
public class Pokedex implements IPokedex {

    private final List<Pokemon> pokemonList;
    private final IPokemonMetadataProvider pokemonMetadataProvider;
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructs a new Pokedex instance with the given metadata provider and Pokemon factory.
     *
     * @param pokemonMetadataProvider the metadata provider to be used for retrieving Pokemon metadata.
     * @param pokemonFactory the Pokemon factory to be used for creating Pokemon instances.
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemonList = new ArrayList<>();
    }

    /**
     * Returns the number of Pokemon stored in the Pokedex.
     *
     * @return the number of Pokemon in the Pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }

    /**
     * Adds a new Pokemon to the Pokedex.
     *
     * @param pokemon the Pokemon to be added.
     * @return the index of the added Pokemon.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemon.getIndex();
    }

    /**
     * Retrieves the Pokemon with the specified ID from the Pokedex.
     *
     * @param id the ID of the Pokemon to retrieve.
     * @return the Pokemon with the specified ID.
     * @throws PokedexException if the specified ID is not valid or the Pokemon does not exist.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon with ID " + id + " not valid .");
    }

    /**
     * Retrieves all the Pokemon stored in the Pokedex.
     *
     * @return a list containing all the Pokemon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemonList);
    }

    /**
     * Retrieves all the Pokemon stored in the Pokedex, sorted using the specified comparator.
     *
     * @param order the comparator used to sort the Pokemon.
     * @return a list containing all the Pokemon in the Pokedex, sorted using the specified comparator.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemonList);
        sortedList.sort(order);
        return sortedList;
    }

    /**
     * Creates a new Pokemon instance with the specified parameters.
     *
     * @param index the index of the Pokemon.
     * @param cp the combat power (CP) of the Pokemon.
     * @param hp the hit points (HP) of the Pokemon.
     * @param dust the stardust cost of the Pokemon.
     * @param candy the candy cost of the Pokemon.
     * @return a new instance of {@link Pokemon} with the specified parameters.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retrieves the metadata of the Pokemon with the specified index.
     *
     * @param index the index of the Pokemon.
     * @return the metadata of the Pokemon with the specified index.
     * @throws PokedexException if the metadata for the specified Pokemon index cannot be retrieved.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
