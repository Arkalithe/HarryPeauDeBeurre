package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.TeacherJsonview;
import fr.humanbooster.harrypotter.jsonviews.TypeClassJsonview;
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
public class TypeOfClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @JsonView({TypeClassJsonview.showTypeClassSimple.class, TeacherJsonview.showTeacherSimple.class})
    private Integer yearTaught;

    @ManyToMany
    @JoinTable(
            name = "student_type_of_class",
            joinColumns = @JoinColumn(name = "type_of_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonView(TypeClassJsonview.showTypeClassSimple.class)
    private List<Student> student = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @JsonView(TypeClassJsonview.showTypeClassSimple.class)
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    @JsonView({TypeClassJsonview.showTypeClassSimple.class, TeacherJsonview.showTeacherSimple.class})
    private Subject subject;

}