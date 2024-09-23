package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.OffenseListJsonview;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@JsonView(OffenseListJsonview.showOffenseListSimple.class)
public class OffenseListDto {

    private LocalDateTime createdAt;


    private Integer offenseSeriousness;
}
