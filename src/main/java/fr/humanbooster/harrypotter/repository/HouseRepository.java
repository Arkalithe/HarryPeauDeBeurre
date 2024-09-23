package fr.humanbooster.harrypotter.repository;

import fr.humanbooster.harrypotter.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

}