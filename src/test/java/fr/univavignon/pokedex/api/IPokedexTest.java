package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() {

        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 45, 49, 126, 4000, 25, 25, 1, 3.0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(1, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 45, 49, 126, 4000, 25, 25, 1, 3.0);
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(1);

        org.junit.Assert.assertEquals(pokemon, retrievedPokemon);

    }


    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonList = pokedex.getPokemons();
        assertEquals(0, pokemonList.size());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(new Pokemon(1, "Bulbasaur", 45, 49, 126, 4000, 25, 25, 3, 2.5));
        pokemonList.add(new Pokemon(2, "Ivysaur", 60, 62, 151, 8000, 50, 25, 3 ,2.5));
        pokemonList.add(new Pokemon(3, "Venusaur", 80, 82, 182, 12000, 75, 25, 3 , 2.5));


        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        pokemonList.sort(comparator);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);
        org.junit.Assert.assertEquals(pokemonList, sortedPokemons);

    }
}
