package at.nacs.pokemonlive.communication;

import at.nacs.pokemonlive.logic.PokemonManager;
import at.nacs.pokemonlive.persistence.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pokemons")
public class PokemonEndpoint {

    private final PokemonManager manager;

    @GetMapping
    List<Pokemon> getAll() {
        return manager.findAll();
    }

    @GetMapping("/name/{name}")
    Pokemon getByName(@PathVariable String name) {
        Optional<Pokemon> pokemon = manager.findByName(name);
        return pokemon.orElse(null);
    }

    @GetMapping("/type/{type}")
    List<Pokemon> getByType(@PathVariable String type) {
        return manager.findByType(type);
    }

    @GetMapping("/subtype/{subtype}")
    List<Pokemon> getBySubtype(@PathVariable String subtype) {
        return manager.findBySubtype(subtype);
    }

}
