package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.OffenseListJsonview;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@JsonView(OffenseListJsonview.showOffenseListSimple.class)
public class OffenseListDto {
    @NotBlank
    private LocalDateTime createdAt;

    @NotNull
    private Integer offenseSeriousness;
}
