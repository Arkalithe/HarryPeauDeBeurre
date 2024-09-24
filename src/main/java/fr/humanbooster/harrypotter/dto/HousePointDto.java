package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.entity.House;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HousePointJsonview;


@Data
@NoArgsConstructor
@JsonView(HousePointJsonview.showHousePointSimple.class)
public class HousePointDto {
    @NotBlank
    private Integer totalPoint;
    @NotNull
    private Integer year;

    private House house;

}
