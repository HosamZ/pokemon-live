package at.nacs.pokemonlive.logic;

import at.nacs.pokemonlive.persistence.Pokemon;
import at.nacs.pokemonlive.persistence.PokemonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PokemonManagerTest {

    @Autowired
    PokemonManager manager;

    @Autowired
    PokemonRepository repository;

    @Autowired
    List<Pokemon> pokemons;

    @Autowired
    Pokemon pokemon;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.saveAll(pokemons);
    }

    @Test
    void findAll() {
        List<Pokemon> actual = manager.findAll();
        assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void findByName() {

        Optional<Pokemon> actual = manager.findByName(pokemon.getName());
        assertThat(actual.get().getId()).isNotBlank();
        assertThat(actual.get().getName()).isEqualTo(pokemon.getName());
    }

    @Test
    void findByType() {

    }

    @Test
    void findBySubtype() {
    }
}