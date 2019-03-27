package at.nacs.pokemonlive.file;

import at.nacs.pokemonlive.persistence.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Stream;

@Component
public class PokemonReader {

    @Value("${pokemon.file}")
    private String fileName;

    public Stream<Pokemon> readPokemons() {
        try {
            File file = ResourceUtils.getFile(fileName);
            return Files.lines(file.toPath())
                    .skip(1)
                    .map(toPokemon());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    private Function<String, Pokemon> toPokemon() {
        return line -> {
            String[] columns = line.split(";");
            String name = columns[1];
            String type = columns[2];
            String subtype = columns[3];
            return Pokemon.builder()
                    .name(name)
                    .type(type)
                    .subtype(subtype)
                    .build();
        };
    }
}