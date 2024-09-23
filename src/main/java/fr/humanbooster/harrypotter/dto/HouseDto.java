package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;


@Data
@NoArgsConstructor
@JsonView(HouseJsonview.showHouseSimple.class)
public class HouseDto {
    private String houseName;
    private String founderFirstName;
    private String founderLastName;
}
