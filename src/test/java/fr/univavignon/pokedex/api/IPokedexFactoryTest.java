package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokemonFactory ipokemonFactory;

    IPokemonMetadataProvider iPokemonMetadataProvider;

    IPokedexFactory iPokedexFactory;

    IPokedex iPokedex;

    IPokedex factoryIpokedex;

    @Before
    public void setUp() throws Exception {
        ipokemonFactory = Mockito.mock(IPokemonFactory.class);
        iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        iPokedex = Mockito.mock(IPokedex.class);
        factoryIpokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void createPokedexTest() {
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, ipokemonFactory)).thenReturn(factoryIpokedex);
        assertEquals(factoryIpokedex.size(), iPokedex.size());
    }
}