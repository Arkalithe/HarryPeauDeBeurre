package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.*;
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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(HouseJsonview.showHouseSimple.class)
        private Integer id;

    @Column(nullable = false)
    @NotBlank
    @JsonView({HouseJsonview.showHouseSimple.class, StudentJsonview.showStudentSimple.class, TypeClassJsonview.showTypeClassDetailed.class, OffenseListJsonview.showOffenseListDetailed.class, HousePointJsonview.showHousePointSimple.class})
    private String houseName;

    @JsonView(HouseJsonview.showHouseSimple.class)
    @Column(nullable = false)
    @NotBlank
    private String founderFirstName;

    @JsonView(HouseJsonview.showHouseSimple.class)
    @Column(nullable = false)
    @NotBlank
    private String founderLastName;

    @OneToMany(mappedBy = "house")
    private List<Student> student = new ArrayList<>();

    @OneToMany(mappedBy = "house")
    private List<HousePoint> housePoint = new ArrayList<>();
}