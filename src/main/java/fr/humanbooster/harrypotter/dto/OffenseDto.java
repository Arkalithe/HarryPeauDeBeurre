package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.OffenseJsonview;


@Data
@NoArgsConstructor
@JsonView(OffenseJsonview.showoffenseSimple.class)
public class OffenseDto {
    private String label;
}
