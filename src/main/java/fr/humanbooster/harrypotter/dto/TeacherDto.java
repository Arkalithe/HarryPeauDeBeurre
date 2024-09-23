package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.TeacherJsonview;


@Data
@NoArgsConstructor
@JsonView(TeacherJsonview.showTeacherSimple.class)
public class TeacherDto {
    private String name;
}
