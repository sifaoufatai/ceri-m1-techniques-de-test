package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory mockIpokemonTrainer;
    private IPokedexFactory mockPokedexFactory;
    private Team mockteam ;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory  pokemonFactory;

    @BeforeEach
    public void setUp() {
        // Création de mocks pour les dépendances
        mockIpokemonTrainer = mock(IPokemonTrainerFactory.class);
        mockPokedexFactory= mock(IPokedexFactory.class);
        mockteam= mock (Team.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testPokemonTrainercreateTrainer(){

        String name = "Acquali";
        // mock de IPokedex
        IPokedex mockPokedex = mock(IPokedex.class);
        //return pockedex  createPokedex
        when(mockPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mockPokedex);

        PokemonTrainer expectedTrainer = new PokemonTrainer(name, mockteam, mockPokedex);

        when(mockIpokemonTrainer.createTrainer(name, mockteam, mockPokedexFactory)).thenReturn(expectedTrainer);


        PokemonTrainer actualTrainer = mockIpokemonTrainer.createTrainer(name, mockteam, mockPokedexFactory);


        assertEquals(expectedTrainer, actualTrainer);
    }
}
