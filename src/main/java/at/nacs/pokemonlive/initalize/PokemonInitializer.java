package at.nacs.pokemonlive.initalize;

import at.nacs.pokemonlive.file.PokemonReader;
import at.nacs.pokemonlive.persistence.PokemonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

//@Configuration
public class PokemonInitializer {

    @Bean
    ApplicationRunner initialize(PokemonRepository repository, PokemonReader reader) {
        return args -> reader.readPokemons()
                .forEach(repository::save);
    }
}