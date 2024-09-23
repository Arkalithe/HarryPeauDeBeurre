package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/houses")
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

    @PostMapping
    public House createHouse(@RequestBody HouseDto houseDto) {
        return houseService.create(houseDto);
    }

    @PutMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public House updateHouse(@PathVariable Integer id, @RequestBody HouseDto houseDto) {
        return houseService.update(houseDto, id);
    }

    @DeleteMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteHouse(@PathVariable Integer id) {
        houseService.delete(id);
    }
}
