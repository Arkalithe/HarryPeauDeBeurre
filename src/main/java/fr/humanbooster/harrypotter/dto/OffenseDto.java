package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.OffenseJsonview;


@Data
@NoArgsConstructor
@JsonView(OffenseJsonview.showOffenseSimple.class)
public class OffenseDto {
    @NotBlank
    private String label;
}
