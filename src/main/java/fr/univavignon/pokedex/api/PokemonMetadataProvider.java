package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    public static final List<PokemonMetadata> Listemetadat = new ArrayList<>();
    ;

    public PokemonMetadataProvider() {

        PokemonMetadata obj1 = new PokemonMetadata(12, "Bulbizarre", 106, 104, 60);
        PokemonMetadata obj2 = new PokemonMetadata(144, "Aquali", 166, 108, 160);
        Listemetadat.add(obj1);
        Listemetadat.add(obj2);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }

        for (PokemonMetadata pokemonMetadata : Listemetadat) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }

        throw new PokedexException("Pokemon with index " + index + " not found.");
    }
}




