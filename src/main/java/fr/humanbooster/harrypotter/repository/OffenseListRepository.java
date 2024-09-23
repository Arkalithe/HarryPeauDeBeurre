package fr.humanbooster.harrypotter.repository;

import fr.humanbooster.harrypotter.entity.OffenseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseListRepository extends JpaRepository<OffenseList, Integer> {

}