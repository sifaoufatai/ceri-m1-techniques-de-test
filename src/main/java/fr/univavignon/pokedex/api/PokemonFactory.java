package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Vérification des attributs
        if (cp < 0 || cp > 1000) {
            throw new IllegalArgumentException("CP value out of bounds");
        }
        if (hp < 0 || hp > 300) {
            throw new IllegalArgumentException("HP value out of bounds");
        }
        if (dust < 0 || dust > 5000) {
            throw new IllegalArgumentException("Dust value out of bounds");
        }
        if (candy < 0 || candy > 100) {
            throw new IllegalArgumentException("Candy value out of bounds");
        }

        // Si les attributs sont valides, créer et retourner un nouvel objet Pokémon
        return new Pokemon(index, "Aquali", 0, 0, 0, cp, hp, dust, candy, 0.0);
    }
}
