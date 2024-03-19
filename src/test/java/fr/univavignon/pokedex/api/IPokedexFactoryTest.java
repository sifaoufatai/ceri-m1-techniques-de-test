package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {

        pokedexFactory = new PokedexFactory();


        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        assertNotNull(createdPokedex);

}
}
