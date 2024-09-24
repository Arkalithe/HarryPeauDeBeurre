package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;


@Data
@NoArgsConstructor
@JsonView(HouseJsonview.showHouseSimple.class)
public class HouseDto {
    @NotBlank
    private String houseName;
    @NotBlank
    private String founderFirstName;
    @NotBlank
    private String founderLastName;
}
