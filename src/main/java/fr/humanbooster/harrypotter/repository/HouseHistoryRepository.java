package fr.humanbooster.harrypotter.repository;

import fr.humanbooster.harrypotter.entity.HouseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseHistoryRepository extends JpaRepository<HouseHistory, Integer> {

}