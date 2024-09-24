package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HousePointDto;
import fr.humanbooster.harrypotter.dto.OffenseDto;
import fr.humanbooster.harrypotter.entity.HousePoint;
import fr.humanbooster.harrypotter.entity.Offense;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.jsonviews.OffenseJsonview;
import fr.humanbooster.harrypotter.service.OffenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(OFFENSE_URL)
@AllArgsConstructor
public class OffenseController {

    private final OffenseService offenseService;

    @GetMapping
    @JsonView(OffenseJsonview.showOffenseSimple.class)
    public List<Offense> getAllOffense() {
        return offenseService.list();
    }

    @GetMapping("/{id}")
    @JsonView(OffenseJsonview.showOffenseDetailed.class)
    public Offense getOffenseById(@PathVariable Integer id) {
        return offenseService.findById(id);
    }

    @PostMapping(CREATE)
    public Offense createOffense(@Valid  @RequestBody OffenseDto offenseDto) {
        return offenseService.create(offenseDto);
    }

    @PutMapping(UPDATE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public Offense updateOffense(@PathVariable Integer id,@Valid @RequestBody OffenseDto offenseDto) {
        return offenseService.update(offenseDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteOffense(@PathVariable Integer id) {
        offenseService.delete(id);
    }
}
