package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.Jsonviews;
import fr.humanbooster.harrypotter.jsonviews.OffenseListJsonview;
import fr.humanbooster.harrypotter.jsonviews.StudentJsonview;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(StudentJsonview.showStudentSimple.class)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @JsonView(StudentJsonview.showStudentDetailed.class)
    private Integer yearOfBirth;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Jsonviews.showStudentSimple.class)
    private String name;

    @Column(nullable = false)
    @NotNull
    @JsonView({StudentJsonview.showStudentDetailed.class, TypeClassJsonview.showTypeClassDetailed.class})
    @JsonProperty("IsAlive")
    private boolean isAlive;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView({StudentJsonview.showStudentSimple.class, TypeClassJsonview.showTypeClassDetailed.class,
            OffenseListJsonview.showOffenseListDetailed.class})
    private House house;

    @ManyToMany(mappedBy = "student")
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<OffenseList> offenseList = new ArrayList<>();
}