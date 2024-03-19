package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider mockMetadataProvider;

    @BeforeEach
    public void setUp() {
        // Création d'un mock pour IPokemonMetadataProvider
        mockMetadataProvider = new PokemonMetadataProvider();
    }

    @Test

    public void testGetPokemonMetadata() throws PokedexException {

        // Exécution de la méthode testée
        PokemonMetadata metadata = mockMetadataProvider.getPokemonMetadata(12);

        // Assertions pour vérifier le comportement attendu
        assertEquals(12, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(106, metadata.getAttack());
        assertEquals(104, metadata.getDefense());
        assertEquals(60, metadata.getStamina());

        // second exemple
        PokemonMetadata metadata2 = mockMetadataProvider.getPokemonMetadata(144);
        assertEquals(144, metadata2.getIndex());
        assertEquals("Aquali", metadata2.getName()); // corrected name
        assertEquals(166, metadata2.getAttack());
        assertEquals(108, metadata2.getDefense());
        assertEquals(160, metadata2.getStamina());
    }

    @Test
    public void testInvalidPokemonIndex() {
        // Vérification que l'appel avec un index invalide génère une PokedexException
        assertThrows(PokedexException.class, () -> {
            mockMetadataProvider.getPokemonMetadata(-1);
        });
    }


}

