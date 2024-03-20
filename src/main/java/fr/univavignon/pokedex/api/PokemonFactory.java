package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Vérification des attributs
        if(0> index || index > 150) throw new IllegalArgumentException("index  out of bound ");



        // Si les attributs sont valides, créer et retourner un nouvel objet Pokémon
        return new Pokemon(index, "Aquali", 0, 0, 0, cp, hp, dust, candy, 0.0);
    }
}
