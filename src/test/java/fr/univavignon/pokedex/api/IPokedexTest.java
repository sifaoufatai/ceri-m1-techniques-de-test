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


    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;


    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon1 = new Pokemon(
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
        pokedex.addPokemon(pokemon1);
    }

    @Test
    public void testSize() throws PokedexException {

        assertEquals(1, pokedex.size());
    }

    @Test

    public void testSizeEmptyPokedex() {

        assertEquals(1, pokedex.size());
    }


    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pokemon2 = new Pokemon(
                2, // index
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


        assertEquals(2, pokedex.addPokemon(pokemon2));

    }

    @Test
    public void testGetPokemon() throws PokedexException {

        Pokemon actual = new Pokemon(
                12,
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
        pokedex.addPokemon(actual);
        Pokemon expected = pokedex.getPokemon(12);

        assertEquals(actual, expected);
    }

    @Test
    public void testGetPokemons() throws PokedexException {
        Pokedex pokedex1 = new Pokedex(pokemonMetadataProvider, pokemonFactory);
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
            pokedex1.addPokemon(pokemon);
        }

        assertEquals(pokemonList, pokedex1.getPokemons());
    }

    @Test

    public void testGetPokemonsSorted() throws PokedexException {
        List<Pokemon> pokemonList2 = new ArrayList<>();
        Pokedex pokedex2 = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        Pokemon pokemon1 = new Pokemon(
                1,
                "A",
                45,
                49,
                49,
                12,
                35,
                5,
                80,
                0.5
        );
        pokemonList2.add(pokemon1);

        Pokemon pokemon2 = new Pokemon(
                1,
                "B",
                45,
                49,
                49,
                12,
                35,
                5,
                80,
                0.5
        );
        pokemonList2.add(pokemon2);
        Pokemon pokemon3 = new Pokemon(
                3,
                "B",
                45,
                49,
                49,
                12,
                35,
                5,
                80,
                0.5
        );
        pokemonList2.add(pokemon3);


        pokedex2.addPokemon(pokemon1);
        pokedex2.addPokemon(pokemon2);
        pokedex2.addPokemon(pokemon3);

        // Triez les deux listes par ordre alphabétique des noms
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        pokemonList2.sort(comparator);

        List<Pokemon> sortedPokemons = pokedex2.getPokemons(comparator);


        assertEquals(pokemonList2, sortedPokemons);
        System.out.println("liste sorted ");
    }
}