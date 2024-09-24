package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.HouseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;


@RestController
@RequestMapping(HOUSE_URL)
@AllArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping
    @JsonView(HouseJsonview.showHouseSimple.class)
    public List<House> getAllHouse() {
        return houseService.list();
    }

    @GetMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public House getHouseById(@PathVariable Integer id) {
        return houseService.findById(id);
    }

    @PostMapping(CREATE)
    public House createHouse(@Valid @RequestBody HouseDto houseDto) {
        return houseService.create(houseDto);
    }

    @PutMapping(UPDATE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public House updateHouse(@PathVariable Integer id, @Valid @RequestBody HouseDto houseDto) {
        return houseService.update(houseDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteHouse(@PathVariable Integer id) {
        houseService.delete(id);
    }
}
