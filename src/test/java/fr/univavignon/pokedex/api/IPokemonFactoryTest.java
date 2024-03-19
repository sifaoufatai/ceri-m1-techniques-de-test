package fr.univavignon.pokedex.api;
import static org.mockito.Mockito.*;
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
    public void testCreatePokemon() throws PokedexException {
        // Configuration des métadonnées pour un Pokémon spécifique
        int index = 0;
        String name = "Aquali";
        int attack = 0;
        int defense = 0;
        int stamina = 0;
        int cp = 0;
        int hp = 0;
        int dust = 0;
        int candy = 0;
        double iv = 0.0;




        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertNotNull(pokemon);

        // Assertions pour vérifier si le Pokémon créé possède correspond a ceux créer
        assertAll("pokemon",
                () -> assertEquals(index, pokemon.getIndex()),
                () -> assertEquals(name, pokemon.getName()),
                () -> assertEquals(attack, pokemon.getAttack()),
                () -> assertEquals(defense, pokemon.getDefense()),
                () -> assertEquals(stamina, pokemon.getStamina()),
                () -> assertEquals(cp, pokemon.getCp()),
                () -> assertEquals(hp, pokemon.getHp()),
                () -> assertEquals(dust, pokemon.getDust()),
                () -> assertEquals(candy, pokemon.getCandy()),
                () -> assertEquals(iv, pokemon.getIv(), 0.01)//
        );
    }







}