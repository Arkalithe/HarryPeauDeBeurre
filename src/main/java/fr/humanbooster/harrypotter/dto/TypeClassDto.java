package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.entity.Student;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.entity.Teacher;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.TypeClassJsonview;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@JsonView(TypeClassJsonview.showTypeClassSimple.class)
public class TypeClassDto {
    @NotNull
    private Integer yearTaught;

    private List<Student> student = new ArrayList<>();

    private Teacher teacher;

    private Subject subject;

}
