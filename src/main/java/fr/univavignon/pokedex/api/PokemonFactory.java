package fr.univavignon.pokedex.api;

/**
 * Factory class for creating instances of {@link Pokemon}.
 * This class implements the {@link IPokemonFactory} interface.
 * It provides a method to create Pokemon instances with specified attributes.
 * Usage example:
 * <pre>{@code
 * IPokemonFactory pokemonFactory = new PokemonFactory();
 * Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
 * }</pre>
 *
 * <p>This implementation provides a default constructor for creating instances of PokemonFactory.</p>
 *
 * <p><b>Note:</b> The default constructor does not perform any additional initialization or logic.</p>
 *
 * @author [Your Name]
 * @see IPokemonFactory
 * @see Pokemon
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Default constructor for creating instances of PokemonFactory.
     */
    public PokemonFactory() {
        // Constructor logic, if any
    }

    /**
     * Creates a new Pokemon instance with the specified attributes.
     *
     * @param index the index of the Pokemon.
     * @param cp    the combat power (CP) of the Pokemon.
     * @param hp    the hit points (HP) of the Pokemon.
     * @param dust  the stardust cost of the Pokemon.
     * @param candy the candy cost of the Pokemon.
     * @return a new instance of {@link Pokemon} with the specified attributes.
     * @throws IllegalArgumentException if the index is out of the valid range.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws IllegalArgumentException {
        // Vérification des attributs
        if (index < 0 || index > 150)
            throw new IllegalArgumentException("Index out of bounds (0-150): " + index);

        // Si les attributs sont valides, créer et retourner un nouvel objet Pokémon
        return new Pokemon(index, "Aquali", 0, 0, 0, cp, hp, dust, candy, 0.0);
    }
}
