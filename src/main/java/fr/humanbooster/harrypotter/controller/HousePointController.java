package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.dto.HousePointDto;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.entity.HousePoint;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.service.HousePointService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housepoints")
@AllArgsConstructor
public class HousePointController {

    private final HousePointService housepointService;

    @GetMapping
    @JsonView(HouseJsonview.showHouseSimple.class)
    public List<HousePoint> getAllHousePoint() {
        return housepointService.list();
    }

    @GetMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public HousePoint getHousePointById(@PathVariable Integer id) {
        return housepointService.findById(id);
    }

    @PostMapping
    public HousePoint createHousePoint(@RequestBody HousePointDto housePointDto) {
        return housepointService.create(housePointDto);
    }

    @PutMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public HousePoint updateHousePoint(@PathVariable Integer id, @RequestBody HousePointDto housePointDto) {
        return housepointService.update(housePointDto, id);
    }

    @DeleteMapping("/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteHousePoint(@PathVariable Integer id) {
        housepointService.delete(id);
    }
}
