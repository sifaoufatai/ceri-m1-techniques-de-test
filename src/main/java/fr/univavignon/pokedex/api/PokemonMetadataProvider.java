package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides metadata for Pokemon.
 * This class implements the {@link IPokemonMetadataProvider} interface.
 * It maintains a list of {@link PokemonMetadata} objects and provides a method to retrieve metadata for a specific Pokemon index.
 * Usage example:
 * <pre>{@code
 * IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
 * PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
 * }</pre>
 *
 * @author [Your Name]
 * @see IPokemonMetadataProvider
 * @see PokemonMetadata
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /** List of Pokemon metadata. **/
    public static final List<PokemonMetadata> metadataList = new ArrayList<>();

    /**
     * Constructs a new PokemonMetadataProvider instance and initializes metadata for some Pokemon.
     */
    public PokemonMetadataProvider() {
        PokemonMetadata obj1 = new PokemonMetadata(12, "Bulbizarre", 106, 104, 60);
        PokemonMetadata obj2 = new PokemonMetadata(144, "Aquali", 166, 108, 160);
        metadataList.add(obj1);
        metadataList.add(obj2);
    }

    /**
     * Retrieves the metadata for the Pokemon with the specified index.
     *
     * @param index the index of the Pokemon.
     * @return the metadata for the Pokemon with the specified index.
     * @throws PokedexException if the index is invalid or the metadata for the Pokemon cannot be found.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }

        for (PokemonMetadata pokemonMetadata : metadataList) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }

        throw new PokedexException("Pokemon with index " + index + " not found.");
    }
}
