package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata pokemonMetadata;
    IPokemonMetadataProvider iPokemonMetadataProvider;

    @Before
    public void setUp() throws Exception {
        int index = 0;
        String name = "goulou";
        int attack = 0;
        int defense = 0;
        int stamina = 0;

        pokemonMetadata = new PokemonMetadata(index, name, attack, defense, stamina);
        iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void getPokemonMetadata() {
        try{
            when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
            assertEquals(pokemonMetadata, iPokemonMetadataProvider.getPokemonMetadata(0));
        }
        catch(Exception exception) {
            exception.getMessage();
        }

    }

    // Test when pokemon is not found
    @Test(expected = PokedexException.class)
    public void shouldThrowPokedexExceptionUnknownPokemon() throws PokedexException {
            when(iPokemonMetadataProvider.getPokemonMetadata(4)).thenThrow(PokedexException.class);
            iPokemonMetadataProvider.getPokemonMetadata(4);
    }

    // Test when index given is higher than index limit
    @Test(expected = PokedexException.class)
    public void shouldThrowPokedexExceptionIndexLimitExceeded() throws PokedexException {
        int maxNum = 200;
        when(iPokemonMetadataProvider.getPokemonMetadata(203)).thenThrow(PokedexException.class);
        iPokemonMetadataProvider.getPokemonMetadata(203);
    }

}