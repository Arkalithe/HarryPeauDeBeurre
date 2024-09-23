package fr.humanbooster.harrypotter.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.entity.OffenseList;
import fr.humanbooster.harrypotter.entity.TypeOfClass;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import fr.humanbooster.harrypotter.jsonviews.StudentJsonview;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@JsonView(StudentJsonview.showStudentSimple.class)
public class StudentDto {

    private Integer yearOfBirth;

    private House house;

    private String name;

    private boolean isAlive;

    private List<TypeOfClass> typeOfClasses;

    private List<OffenseList> offenseList;
}
