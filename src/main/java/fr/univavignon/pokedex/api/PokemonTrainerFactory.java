package fr.univavignon.pokedex.api;

/**
 * Factory class for creating instances of {@link PokemonTrainer}.
 * This class implements the {@link IPokemonTrainerFactory} interface.
 * It provides a method to create PokemonTrainer instances with specified attributes.
 * Usage example:
 * <pre>{@code
 * IPokemonMetadataProvider metadataProvider = new SomeMetadataProvider();
 * IPokemonFactory pokemonFactory = new SomePokemonFactory();
 * IPokedexFactory pokedexFactory = new SomePokedexFactory();
 * IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory(metadataProvider, pokemonFactory);
 * PokemonTrainer trainer = trainerFactory.createTrainer(name, team, pokedexFactory);
 * }</pre>
 *
 * @author [Your Name]
 * @see IPokemonTrainerFactory
 * @see PokemonTrainer
 * @see IPokemonMetadataProvider
 * @see IPokemonFactory
 * @see IPokedexFactory
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    /**
     * Constructs a new PokemonTrainerFactory instance with the given metadata provider and Pokemon factory.
     *
     * @param metadataProvider the metadata provider to be used for creating Pokemon metadata.
     * @param pokemonFactory   the Pokemon factory to be used for creating Pokemon instances.
     */
    public PokemonTrainerFactory(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Creates a new PokemonTrainer instance with the specified attributes.
     *
     * @param name           the name of the trainer.
     * @param team           the team of the trainer.
     * @param pokedexFactory the factory for creating the trainer's Pokedex.
     * @return a new instance of {@link PokemonTrainer} with the specified attributes.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
