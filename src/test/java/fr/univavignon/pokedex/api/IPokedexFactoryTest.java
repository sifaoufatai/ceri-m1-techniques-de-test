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
        //Pokemon p1 = new Pokemon(0, "fata", 12, 12, 4, 3, 12, 12, 12.0)
        //Pokemon p1 = new Pokemon(1, "fata", 12, 12, 4, 3, 12, 12, 12.0)
    }

    @Test
    public void testCreatePokedex() {

        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);


        assertNotNull(createdPokedex);

}
}
