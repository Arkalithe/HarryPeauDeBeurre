package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.HouseHistoryJsonview;


@Data
@NoArgsConstructor

public class HouseHistoryDto {

    private String setOldFounderFirstName;
    private String setOldFounderLastName;
    private String oldHouseName;

}
