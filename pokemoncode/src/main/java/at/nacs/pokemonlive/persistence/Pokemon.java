package at.nacs.pokemonlive.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

    private String id;
    private String name;
    private String type;
    private String subtype;
}