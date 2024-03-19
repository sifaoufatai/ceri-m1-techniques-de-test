package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Before
    public void setUp() {
        metadataProvider = mock(PokemonMetadataProvider.class);
        pokemonFactory = mock(PokemonFactory.class);
        pokedexFactory = mock(PokedexFactory.class);
        pokedex = mock(Pokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        pokemonTrainerFactory = new PokemonTrainerFactory(metadataProvider, pokemonFactory);
    }

    @Test
    public void testCreateTrainer() {
        // Création d'un PokémonTrainer
        String trainerName = "Ash";
        Team trainerTeam = Team.VALOR;
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);
        assertNotNull(trainer, "should not be null.");

        // Vérification des attributs du PokémonTrainer
        Assert.assertEquals(trainerName, trainer.getName());
        Assert.assertEquals(trainerTeam, trainer.getTeam());
        Assert.assertEquals(pokedex, trainer.getPokedex());
        assertNotNull(trainer.getPokedex(), "lack of pokedex" );
    }
}
