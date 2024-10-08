package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.TeacherJsonview;
import fr.humanbooster.harrypotter.jsonviews.TypeClassJsonview;
import fr.humanbooster.harrypotter.slugger.SluggerInterface;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Subject implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @JsonView({TypeClassJsonview.showTypeClassSimple.class, TeacherJsonview.showTeacherSimple.class})
    private String subjectName;

    private String slug;

    public String getField() {return subjectName; }

}