package fr.humanbooster.harrypotter.entity;

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
public class HouseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String oldHouseName;

    @Column(nullable = false)
    @NotBlank
    private String oldFounderFirstName;

    @Column(nullable = false)
    @NotBlank
    private String oldFounderLastName;


}