package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    Pokemon pokemon;
    IPokemonFactory pokemonFactory;

    // Pokemon returned by the factory method
    Pokemon factoryPokemon;

    @Before
    public void setUp() throws Exception {

        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokemon = new Pokemon(0, "gouloulou", 0, 0, 0, 0, 0, 0, 0, 0);
        factoryPokemon = new Pokemon(0, "gouloulou", 0, 0, 0, 0, 0, 0, 0, 0);
    }

    // should create pokemon object with the correct parameters
    @Test
    public void createPokemon() {
        when(pokemonFactory.createPokemon(0, 0, 0, 0, 0)).thenReturn(factoryPokemon);
        assertEquals(factoryPokemon.getName() , pokemon.getName());
    }

}