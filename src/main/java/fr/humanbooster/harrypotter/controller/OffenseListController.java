package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.OffenseDto;
import fr.humanbooster.harrypotter.dto.OffenseListDto;
import fr.humanbooster.harrypotter.entity.Offense;
import fr.humanbooster.harrypotter.entity.OffenseList;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.OffenseListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offenselists")
@AllArgsConstructor
public class OffenseListController {

    private final OffenseListService offenselistService;


    @GetMapping
    @JsonView(HouseJsonview.showHouseSimple.class)
    public List<OffenseList> getAllOffenseList() {
        return offenselistService.list();
    }

    @GetMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public OffenseList getOffenseListById(@PathVariable Integer id) {
        return offenselistService.findById(id);
    }

    @PostMapping
    public OffenseList createOffenseList(@RequestBody OffenseListDto offenseListDto) {
        return offenselistService.create(offenseListDto);
    }

    @PutMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public OffenseList updateOffenseList(@PathVariable Integer id, @RequestBody OffenseListDto offenseListDto) {
        return offenselistService.update(offenseListDto, id);
    }

    @DeleteMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteOffenseList(@PathVariable Integer id) {
        offenselistService.delete(id);
    }
}
