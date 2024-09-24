package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.OffenseDto;
import fr.humanbooster.harrypotter.dto.OffenseListDto;
import fr.humanbooster.harrypotter.entity.Offense;
import fr.humanbooster.harrypotter.entity.OffenseList;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.jsonviews.OffenseJsonview;
import fr.humanbooster.harrypotter.jsonviews.OffenseListJsonview;
import fr.humanbooster.harrypotter.service.OffenseListService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(OFFENSE_LIST_URL)
@AllArgsConstructor
public class OffenseListController {

    private final OffenseListService offenselistService;


    @GetMapping
    @JsonView(OffenseListJsonview.showOffenseListSimple.class)
    public List<OffenseList> getAllOffenseList() {
        return offenselistService.list();
    }

    @GetMapping("/{id}")
    @JsonView(OffenseListJsonview.showOffenseListDetailed.class)
    public OffenseList getOffenseListById(@PathVariable Integer id) {
        return offenselistService.findById(id);
    }

    @PostMapping(CREATE)
    public OffenseList createOffenseList(@Valid  @RequestBody OffenseListDto offenseListDto) {
        return offenselistService.create(offenseListDto);
    }

    @PutMapping(UPDATE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public OffenseList updateOffenseList(@PathVariable Integer id,@Valid @RequestBody OffenseListDto offenseListDto) {
        return offenselistService.update(offenseListDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteOffenseList(@PathVariable Integer id) {
        offenselistService.delete(id);
    }
}
