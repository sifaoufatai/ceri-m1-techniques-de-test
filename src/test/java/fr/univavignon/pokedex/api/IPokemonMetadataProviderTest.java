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
        mockMetadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Configuration du mock pour retourner des métadonnées spécifiques quand un index spécifique est demandé
        when(mockMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Buibizare", 126, 126, 90));
        when(mockMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali ", 186, 168, 260));


        // Exécution de la méthode testée
        PokemonMetadata metadata = mockMetadataProvider.getPokemonMetadata(0);

        // Assertions pour vérifier le comportement attendu
        assertEquals(0, metadata.getIndex());
        assertEquals("Buibizare", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());

        // second exemple
        PokemonMetadata metadata2 = mockMetadataProvider.getPokemonMetadata(133);
        assertEquals(133, metadata2.getIndex());
        assertEquals("Aquali", metadata2.getName());
        assertEquals(186, metadata2.getAttack());
        assertEquals(168, metadata2.getDefense());
        assertEquals(260, metadata2.getStamina());

    }

    @Test
    public void testGetPokemonMetadataThrowsExceptionWhenIndexIsInvalid() throws PokedexException {
        // Configuration du mock pour lancer une exception quand un index invalide est demandé
        int invalidIndex = -1;
        IPokemonMetadataProvider mockMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(mockMetadataProvider.getPokemonMetadata(invalidIndex))
                .thenThrow(new PokedexException("Invalid this  index: " + invalidIndex));

        // Vérification que l'exception est bien lancée avec cet index
        assertThrows(PokedexException.class, () -> {
            mockMetadataProvider.getPokemonMetadata(invalidIndex);
        });
    }

}
