package fr.humanbooster.harrypotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.harrypotter.dto.HouseDto;
import fr.humanbooster.harrypotter.dto.HousePointDto;
import fr.humanbooster.harrypotter.entity.House;
import fr.humanbooster.harrypotter.entity.HousePoint;
import fr.humanbooster.harrypotter.jsonviews.HouseJsonview;
import fr.humanbooster.harrypotter.jsonviews.HousePointJsonview;
import fr.humanbooster.harrypotter.service.HousePointService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(HOUSE_POINT_URL)
@AllArgsConstructor
public class HousePointController {

    private final HousePointService housepointService;

    @GetMapping
    @JsonView(HousePointJsonview.showHousePointSimple.class)
    public List<HousePoint> getAllHousePoint() {
        return housepointService.list();
    }

    @GetMapping("/{id}")
    @JsonView(HousePointJsonview.showHousePointDetailed.class)
    public HousePoint getHousePointById(@PathVariable Integer id) {
        return housepointService.findById(id);
    }

    @PostMapping(CREATE)
    public HousePoint createHousePoint(@Valid @RequestBody HousePointDto housePointDto) {
        return housepointService.create(housePointDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public HousePoint updateHousePoint(@PathVariable Integer id, @Valid @RequestBody HousePointDto housePointDto) {
        return housepointService.update(housePointDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    @JsonView(HouseJsonview.showHouseSimple.class)
    public void deleteHousePoint(@PathVariable Integer id) {
        housepointService.delete(id);
    }
}
