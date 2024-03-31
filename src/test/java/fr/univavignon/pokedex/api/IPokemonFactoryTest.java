package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    IPokemonFactory rocketPockemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
        rocketPockemonFactory = new RocketPokemonFactory();

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


        Pokemon rocketPockemonFactoryPokemon = rocketPockemonFactory.createPokemon(0,613, 202, 5000, 4);
        assertEquals(0, rocketPockemonFactoryPokemon.getIndex());
        assertEquals(613, rocketPockemonFactoryPokemon.getCp());
        assertEquals(202, rocketPockemonFactoryPokemon.getHp());
        assertEquals(5000, rocketPockemonFactoryPokemon.getDust());
        assertEquals(4, rocketPockemonFactoryPokemon.getCandy());

/*
attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
 */
        Pokemon rocketPockemonFactoryPokemon1 = rocketPockemonFactory.createPokemon(-1,2729, 64, 4000, 4);
        assertEquals(-1, rocketPockemonFactoryPokemon1.getIndex());
        assertEquals(2729, rocketPockemonFactoryPokemon1.getCp());
        assertEquals(64, rocketPockemonFactoryPokemon1.getHp());
        assertEquals(4000, rocketPockemonFactoryPokemon1.getDust());
        assertEquals(4, rocketPockemonFactoryPokemon1.getCandy());
        assertEquals(1000, rocketPockemonFactoryPokemon1.getAttack());
        assertEquals(1000, rocketPockemonFactoryPokemon1.getDefense());
        assertEquals(1000, rocketPockemonFactoryPokemon1.getStamina());
        assertEquals(0.0, rocketPockemonFactoryPokemon1.getIv());
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
