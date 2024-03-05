package fr.univavignon.pokedex.api;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;


    @BeforeEach
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);

    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Configuration des métadonnées pour un Pokémon spécifique
        int index = 1;
        String name = "balboard";
        int attack = 52;
        int defense = 69;
        int stamina = 45;
        int cp = 550;
        int hp = 60;
        int dust = 3000;
        int candy = 1;
        double iv = 0.85;



       // comment le mock fonctionne
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy))
                .thenReturn(new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv));

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



    @Test
    public void testCreatePokemonWithAttributesOutOfBounds() {
        // Configuration du mock pour simuler une validation des attributs
        when(pokemonFactory.createPokemon(anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenAnswer(invocation -> {
            int attack = invocation.getArgument(2);
            int defense = invocation.getArgument(3);
            int stamina = invocation.getArgument(4);

            // Validation de l'attaque, la défense et l'endurance
            if (attack < 0 || attack > 15) {
                throw new IllegalArgumentException("Attack value out of bounds");
            }
            if (defense < 0 || defense > 15) {
                throw new IllegalArgumentException("Defense value out of bounds");
            }
            if (stamina < 0 || stamina > 15) {
                throw new IllegalArgumentException("Stamina value out of bounds");
            }

            // Si les attributs sont valides, retourner un objet Pokémon mocké
            return new Pokemon(1, "Pikachu", attack, defense, stamina, 500, 60, 1000, 50, 0.8);

        });

        // Vérification que l'exception est bien lancée pour chaque attribut hors des limites
        assertThrows(IllegalArgumentException.class,
                // Vérification que l'exception est bien lancée pour chaque attribut hors des limites

                () -> pokemonFactory.createPokemon(1, 500, 60, 16, 10), "Attack value out of bounds");
        assertThrows(IllegalArgumentException.class,
                () -> pokemonFactory.createPokemon(1, 500, 60, 10, 16), "Defense value out of bounds");
        assertThrows(IllegalArgumentException.class,
                () -> pokemonFactory.createPokemon(1, 500, 60, 10, 10), "Stamina value out of bounds");
    }




}