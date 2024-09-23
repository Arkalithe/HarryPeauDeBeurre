package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.entity.House;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HousePointJsonview;


@Data
@NoArgsConstructor
@JsonView(HousePointJsonview.showHousePointSimple.class)
public class HousePointDto {

    private Integer totalPoint;
    private Integer year;
    private House house;

}
