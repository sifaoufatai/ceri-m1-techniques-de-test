package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        int index = 1;
        int cp = 45;
        int hp = 49;
        int dust = 49;
        int candy = 12;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("Aquali", pokemon.getName());
        assertEquals(0, pokemon.getAttack());
        assertEquals(0, pokemon.getDefense());
        assertEquals(0, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(0.0, pokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        assertAll("Invalid indexes",
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    pokemonFactory.createPokemon(-2, 45, 49, 49, 12); // Index -2, en dehors de l'intervalle
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    pokemonFactory.createPokemon(151, 45, 49, 49, 12); // Index 151, en dehors de l'intervalle
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    pokemonFactory.createPokemon(-1, 45, 49, 49, 12); // Index -1, en dehors de l'intervalle
                })
        );
    }

}
