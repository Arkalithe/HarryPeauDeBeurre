package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HousePointDto;
import fr.humanbooster.harrypotter.dto.OffenseDto;
import fr.humanbooster.harrypotter.entity.HousePoint;
import fr.humanbooster.harrypotter.entity.Offense;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.OffenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offenses")
@AllArgsConstructor
public class OffenseController {

    private final OffenseService offenseService;

    @GetMapping
    @JsonView(HouseJsonview.showHouseSimple.class)
    public List<Offense> getAllOffense() {
        return offenseService.list();
    }

    @GetMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public Offense getOffenseById(@PathVariable Integer id) {
        return offenseService.findById(id);
    }

    @PostMapping
    public Offense createOffense(@RequestBody OffenseDto offenseDto) {
        return offenseService.create(offenseDto);
    }

    @PutMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public Offense updateOffense(@PathVariable Integer id, @RequestBody OffenseDto offenseDto) {
        return offenseService.update(offenseDto, id);
    }

    @DeleteMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteOffense(@PathVariable Integer id) {
        offenseService.delete(id);
    }
}
