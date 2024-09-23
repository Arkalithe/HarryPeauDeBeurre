package fr.humanbooster.harrypotter.repository;

import fr.humanbooster.harrypotter.entity.Offense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseRepository extends JpaRepository<Offense, Integer> {

}