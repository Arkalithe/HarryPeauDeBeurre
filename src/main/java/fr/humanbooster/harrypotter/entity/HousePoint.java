package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.HousePointJsonview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class HousePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @JsonView(HousePointJsonview.showHousePointSimple.class)
    private Integer year;

    @Column(nullable = false)
    @NotNull
    @JsonView(HousePointJsonview.showHousePointSimple.class)
    private Integer totalPoint;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(HousePointJsonview.showHousePointSimple.class)
    private House house;
}