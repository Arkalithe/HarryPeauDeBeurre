package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.SubjectJsonview;


@Data
@NoArgsConstructor
@JsonView(SubjectJsonview.showSubjectSimple.class)
public class SubjectDto {
    @NotBlank
    private String subjectName;
}
