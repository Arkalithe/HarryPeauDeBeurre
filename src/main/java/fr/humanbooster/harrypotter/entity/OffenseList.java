package fr.humanbooster.harrypotter.entity;

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
    @NotNull
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @NotNull
    private Integer offenseSeriousness;

    @ManyToOne
    @JoinColumn(name = "offense_id", nullable = false)
    private Offense offense;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
