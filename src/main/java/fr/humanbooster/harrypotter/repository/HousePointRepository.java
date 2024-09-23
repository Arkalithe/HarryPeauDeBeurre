package fr.humanbooster.harrypotter.repository;

import fr.humanbooster.harrypotter.entity.HousePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousePointRepository extends JpaRepository<HousePoint, Integer> {

}