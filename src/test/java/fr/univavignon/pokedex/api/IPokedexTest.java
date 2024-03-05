package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private PokemonMetadata pokemonMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 45, 49, 49);
    }

    @Test
    public void testSize() throws PokedexException {
        when(pokedex.size()).thenReturn(1);
        assertEquals(1, pokedex.size());
    }

    @Test

    public void testSizeEmptyPokedex() {
        when(pokedex.size()).thenReturn(0);
        assertEquals(0, pokedex.size());
    }


    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(
                1, // index
                "Bulbasaur", // name
                45, //
                49, //
                49, //
                12, //
                35, //
                5, //
                80, //
                0.5
        );
        when(pokedex.addPokemon(pokemon)).thenReturn(1);
        assertEquals(1, pokedex.addPokemon(pokemon));
        when(pokedex.addPokemon(pokemon)).thenReturn(1);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon expectedPokemon = new Pokemon(
                1,
                "Bulbasaur",
                45,
                49,
                49,
                12,
                35,
                5,
                80,
                0.5
        );
        when(pokedex.getPokemon(1)).thenReturn(expectedPokemon);
        assertEquals(expectedPokemon, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() throws PokedexException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = new Pokemon(
                    i + 1,
                    "Bulbasaur",
                    45,
                    49,
                    49,
                    12,
                    35,
                    5,
                    80,
                    0.5
            );
            pokemonList.add(pokemon);
        }
        when(pokedex.getPokemons()).thenReturn(pokemonList);
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsSorted() throws PokedexException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = new Pokemon(
                    i + 1,
                    "Math",
                    45,
                    49,
                    49,
                    12,
                    35,
                    5,
                    80,
                    0.5
            );
            pokemonList.add(pokemon);
        }
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        pokemonList.sort(comparator);
        when(pokedex.getPokemons(comparator)).thenReturn(pokemonList);
        assertEquals(pokemonList, pokedex.getPokemons(comparator));
    }
}
