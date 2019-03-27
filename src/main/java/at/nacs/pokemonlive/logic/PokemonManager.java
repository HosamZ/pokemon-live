package at.nacs.pokemonlive.logic;

import at.nacs.pokemonlive.persistence.Pokemon;
import at.nacs.pokemonlive.persistence.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonManager {

    private final PokemonRepository repository;

    public List<Pokemon> findAll() {
        return repository.findAll();
    }

    public Optional<Pokemon> findByName(String name) {
        return repository.findOneByName(name);
    }

    public List<Pokemon> findByType(String type) {
        return repository.findByType(type);
    }

    public List<Pokemon> findBySubtype(String subtype) {
        return repository.findBySubtype(subtype);
    }

}
