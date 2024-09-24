package fr.humanbooster.harrypotter.controller;

import fr.humanbooster.harrypotter.dto.HouseHistoryDto;
import fr.humanbooster.harrypotter.dto.SubjectDto;
import fr.humanbooster.harrypotter.entity.HouseHistory;
import fr.humanbooster.harrypotter.entity.Subject;
import fr.humanbooster.harrypotter.service.HouseHistoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static fr.humanbooster.harrypotter.util.UrlPath.*;

@RestController
@RequestMapping(HOUSE_HISTORY_URL)
@AllArgsConstructor
public class HouseHistoryController {
    private final HouseHistoryService househistoryService;

    @GetMapping
    public List<HouseHistory> getAllSubject() {
        return househistoryService.list();
    }

    @GetMapping("/{id}")
    public HouseHistory getHouseHistoryById(@PathVariable Integer id) {
        return househistoryService.findById(id);
    }

    @PostMapping(CREATE)
    public HouseHistory createHouseHistory(@Valid  @RequestBody HouseHistoryDto houseHistoryDto) {
        return househistoryService.create(houseHistoryDto);
    }

    @PutMapping(UPDATE + "/{id}")
    public HouseHistory updateHouseHistory(@PathVariable Integer id, @Valid @RequestBody HouseHistoryDto houseHistoryDto) {
        return househistoryService.update(houseHistoryDto, id);
    }

    @DeleteMapping(DELETE + "/{id}")
    public void deleteHouseHistory(@PathVariable Integer id) {
        househistoryService.delete(id);
    }

}
