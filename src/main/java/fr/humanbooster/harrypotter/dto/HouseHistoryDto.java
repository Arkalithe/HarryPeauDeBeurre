package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HouseHistoryJsonview;


@Data
@NoArgsConstructor

public class HouseHistoryDto {
    @NotBlank
    private String setOldFounderFirstName;
    @NotBlank
    private String setOldFounderLastName;
    @NotBlank
    private String oldHouseName;

}
