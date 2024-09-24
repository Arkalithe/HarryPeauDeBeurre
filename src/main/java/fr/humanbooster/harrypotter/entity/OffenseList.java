package fr.humanbooster.harrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.jsonviews.OffenseListJsonview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class OffenseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @JsonView(OffenseListJsonview.showOffenseListSimple.class)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @NotNull
    @JsonView(OffenseListJsonview.showOffenseListSimple.class)
    private Integer offenseSeriousness;

    @ManyToOne
    @JoinColumn(name = "offense_id", nullable = false)
    @JsonView(OffenseListJsonview.showOffenseListDetailed.class)
    private Offense offense;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonView(OffenseListJsonview.showOffenseListSimple.class)
    private Student student;
}
