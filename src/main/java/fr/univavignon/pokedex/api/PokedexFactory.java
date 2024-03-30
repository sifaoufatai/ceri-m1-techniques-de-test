package fr.univavignon.pokedex.api;

/**
 * Factory class for creating instances of {@link IPokedex}.
 * This class provides methods to create instances of Pokedex with specified metadata provider and Pokemon factory.
 * Usage example:
 * <pre>{@code
 * IPokemonMetadataProvider metadataProvider = new SomeMetadataProvider();
 * IPokemonFactory pokemonFactory = new SomePokemonFactory();
 * IPokedexFactory pokedexFactory = new PokedexFactory();
 * IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
 * }</pre>
 *
 * @author [Your Name]
 * @see IPokedexFactory
 * @see IPokedex
 * @see IPokemonMetadataProvider
 * @see IPokemonFactory
 */
public class PokedexFactory implements IPokedexFactory {

    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructs a new PokedexFactory instance with the given metadata provider and Pokemon factory.
     *
     * @param metadataProvider the metadata provider to be used for creating Pokemon metadata.
     * @param pokemonFactory   the Pokemon factory to be used for creating Pokemon instances.
     */
    public PokedexFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Creates a new Pokedex instance with the specified metadata provider and Pokemon factory.
     *
     * @param metadataProvider the metadata provider to be used for creating Pokemon metadata.
     * @param pokemonFactory   the Pokemon factory to be used for creating Pokemon instances.
     * @return a new instance of {@link IPokedex}.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

    /**
     * Constructs a new PokedexFactory instance with default implementations of metadata provider and Pokemon factory.
     * This constructor uses {@link PokemonMetadataProvider} and {@link PokemonFactory} as default implementations.
     */
    public PokedexFactory() {
        this(new PokemonMetadataProvider(), new PokemonFactory());
    }
}
